package com.qianqian.common.mapper;

import com.qianqian.common.model.AdLocation;
import com.qianqian.common.model.AdLocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdLocationMapper {
    int countByExample(AdLocationExample example);

    int deleteByExample(AdLocationExample example);

    int deleteByPrimaryKey(Long locationId);

    int insert(AdLocation record);

    int insertSelective(AdLocation record);

    List<AdLocation> selectByExample(AdLocationExample example);

    AdLocation selectByPrimaryKey(Long locationId);

    int updateByExampleSelective(@Param("record") AdLocation record, @Param("example") AdLocationExample example);

    int updateByExample(@Param("record") AdLocation record, @Param("example") AdLocationExample example);

    int updateByPrimaryKeySelective(AdLocation record);

    int updateByPrimaryKey(AdLocation record);
   
}