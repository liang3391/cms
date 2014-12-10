package com.qianqian.common.mapper;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.qianqian.common.model.Image;
import com.qianqian.common.model.ImageExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ImageMapper {
    int countByExample(ImageExample example);

    int deleteByExample(ImageExample example);

    int deleteByPrimaryKey(Long imageId);

    int insert(Image record);

    int insertSelective(Image record);

    List<Image> selectByExample(ImageExample example);
    
    List<Image> selectByExample(ImageExample example,PageBounds page);

    Image selectByPrimaryKey(Long imageId);

    int updateByExampleSelective(@Param("record") Image record, @Param("example") ImageExample example);

    int updateByExample(@Param("record") Image record, @Param("example") ImageExample example);

    int updateByPrimaryKeySelective(Image record);

    int updateByPrimaryKey(Image record);
}