package com.pg.generate.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pg.generate.entity.TablesSchema;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TablesSchemaMapper extends BaseMapper<TablesSchema> {

    /**
     * 查询表下面所有的字段
     * @param tableSchema
     * @param tableName
     */
    List<TablesSchema> queryTableColumnAll(@Param("tableSchema") String tableSchema, @Param("tableName") String tableName);
}
