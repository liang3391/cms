package com.qianqian.common.mapper;

import com.qianqian.common.model.AdLocation;
import com.qianqian.common.model.ImageAd;
import com.qianqian.common.model.ImageAdExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ImageAdMapper {
    int countByExample(ImageAdExample example);

    int deleteByExample(ImageAdExample example);

    int deleteByPrimaryKey(Long adId);

    int insert(ImageAd record);

    int insertSelective(ImageAd record);

    List<ImageAd> selectByExample(ImageAdExample example);

    ImageAd selectByPrimaryKey(Long adId);

    int updateByExampleSelective(@Param("record") ImageAd record, @Param("example") ImageAdExample example);

    int updateByExample(@Param("record") ImageAd record, @Param("example") ImageAdExample example);

    int updateByPrimaryKeySelective(ImageAd record);

    int updateByPrimaryKey(ImageAd record);
    /**
     * 根据广告位置查询该位置对应的图片广告并且排序
     *  @Method_Name    : selectByLocationAndSort
     *  @param record
     *  @return 
     *  @return         : List<ImageAd>
     *  @Creation Date  : 2014年5月16日 下午3:41:28
     *  @version        : v1.00
     *  @Author         : caozhifei 
     *  @Update Date    : 
     *  @Update Author  :
     */
    List<ImageAd> selectByLocationAndSort(AdLocation record);
}