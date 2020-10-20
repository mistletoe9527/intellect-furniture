/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.furniture.io
 *
 * 版权所有，侵权必究！
 */

package com.furniture.dao;

import java.util.List;
import java.util.Map;

/**
 * 数据库接口
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface GeneratorDao {
    List<Map<String, Object>> queryList(Map<String, Object> map);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);
}
