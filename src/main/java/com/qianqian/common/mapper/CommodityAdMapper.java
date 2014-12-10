package com.qianqian.common.mapper;

import com.qianqian.common.model.AdLocation;
import com.qianqian.common.model.CommodityAd;
import com.qianqian.common.model.CommodityAdExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CommodityAdMapper {
    int countByExample(CommodityAdExample example);

    int deleteByExample(CommodityAdExample example);

    int deleteByPrimaryKey(Long adId);

    int insert(CommodityAd record);

    int insertSelective(CommodityAd record);

    List<CommodityAd> selectByExample(CommodityAdExample example);

    CommodityAd selectByPrimaryKey(Long adId);

    int updateByExampleSelective(@Param("record") CommodityAd record, @Param("example") CommodityAdExample example);

    int updateByExample(@Param("record") CommodityAd record, @Param("example") CommodityAdExample example);

    int updateByPrimaryKeySelective(CommodityAd record);

    int updateByPrimaryKey(CommodityAd record);
    /**
     * 根据广告位置查询该位置对应的商品广告并且排序
     *  @Method_Name    : selectByLocationAndSort
     *  @param record
     *  @return 
     *  @return         : List<CommodityAd>
     *  @Creation Date  : 2014年5月16日 下午3:41:28
     *  @version        : v1.00
     *  @Author         : caozhifei 
     *  @Update Date    : 
     *  @Update Author  :
     */
    List<CommodityAd> selectByLocationAndSort(AdLocation record);
}