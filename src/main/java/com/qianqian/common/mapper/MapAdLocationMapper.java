package com.qianqian.common.mapper;

import com.qianqian.common.model.MapAdLocation;
import com.qianqian.common.model.MapAdLocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MapAdLocationMapper {
    int countByExample(MapAdLocationExample example);

    int deleteByExample(MapAdLocationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MapAdLocation record);

    int insertSelective(MapAdLocation record);

    List<MapAdLocation> selectByExample(MapAdLocationExample example);

    MapAdLocation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MapAdLocation record, @Param("example") MapAdLocationExample example);

    int updateByExample(@Param("record") MapAdLocation record, @Param("example") MapAdLocationExample example);

    int updateByPrimaryKeySelective(MapAdLocation record);

    int updateByPrimaryKey(MapAdLocation record);
}