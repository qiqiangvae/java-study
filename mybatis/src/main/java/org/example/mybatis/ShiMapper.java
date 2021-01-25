package org.example.mybatis;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author qiqiang
 * @date 2020-11-24 1:02 下午
 */
public interface ShiMapper {

    @Select(value = "select * from chinese_poetry_shi where id =#{id}")
    ShiEntity selectOne(@Param("id") Long id);

    @Select(value = "select * from chinese_poetry_shi where author like #{author} and title like #{title}")
    List<ShiEntity> selectBy(@Param("author") String author, @Param("title") String title);
}