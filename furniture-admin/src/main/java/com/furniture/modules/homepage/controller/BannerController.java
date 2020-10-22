package com.furniture.modules.homepage.controller;

import java.io.File;
import java.io.IOException;
import java.util.*;

import com.furniture.common.exception.RRException;
import com.furniture.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.modules.homepage.entity.BannerEntity;
import com.furniture.modules.homepage.service.BannerService;
import com.furniture.common.utils.PageUtils;
import com.furniture.common.utils.R;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


/**
 * 
 *
 * @author liuqing
 * @email sunlightcs@gmail.com
 * @date 2020-10-21 13:41:42
 */
@RestController
@RequestMapping("homepage/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("homepage:banner:list")
    public R list(@RequestParam Map<String, Object> params){
        params.put("isDelete",0);
        PageUtils page = bannerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("homepage:banner:info")
    public R info(@PathVariable("id") Integer id){
        BannerEntity banner = bannerService.getById(id);

        return R.ok().put("banner", banner);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("homepage:banner:save")
    public R save(@RequestBody BannerEntity banner){
        bannerService.save(banner);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("homepage:banner:update")
    public R update(@RequestBody BannerEntity banner){
        ValidatorUtils.validateEntity(banner);
        bannerService.updateById(banner);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("homepage:banner:delete")
    public R delete(@RequestBody Integer[] ids){
        bannerService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    private static String savePath = "";
    @RequestMapping("/upload")
    public R upload(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request) {
        if (file.isEmpty()) {
            R.error("未上传文件");
        }
        if (file.getSize() > 1024 * 1024 * 1) {
            throw new RRException("上传文件大小超过1M");
        }
        //获取文件后缀
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        if (!"jpg,jpeg,gif,png".toUpperCase().contains(suffix.toUpperCase())) {
            throw new RRException("上传图片类型只能为jpg,jpeg,gif,png");
        }

        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
//        String filePath = "//Users//wangjia//Desktop//"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名

        getProperties("");
        File savePathFile = new File(savePath);
        if (!savePathFile.exists()) {
            //若不存在该目录，则创建目录
            savePathFile.mkdir();
        }
        try {
            //将文件保存指定目录
            file.transferTo(new File(savePath + fileName));
        } catch (Exception e) {
            throw new RRException(e.getMessage());
        }

        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("picPath",savePath + fileName);
        return R.ok(resultMap);
    }

    /**
     * 读取配置文件中的信息.
     *
     * @return
     */
    private static void getProperties(String name) {
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResources(new ClassPathResource("application.yml"));
//        factoryBean.setResources(new ClassPathResource("application"+name+"yml"));
        factoryBean.afterPropertiesSet();
        Properties object = factoryBean.getObject();
        savePath = (String) object.get("operation.savePath");
    }

}
