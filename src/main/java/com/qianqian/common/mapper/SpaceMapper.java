package com.qianqian.common.mapper;

import com.qianqian.common.model.Space;
import com.qianqian.common.model.SpaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpaceMapper {
    int countByExample(SpaceExample example);

    int deleteByExample(SpaceExample example);

    int deleteByPrimaryKey(Long spaceId);

    int insert(Space record);

    int insertSelective(Space record);

    List<Space> selectByExample(SpaceExample example);

    Space selectByPrimaryKey(Long spaceId);

    int updateByExampleSelective(@Param("record") Space record, @Param("example") SpaceExample example);

    int updateByExample(@Param("record") Space record, @Param("example") SpaceExample example);

    int updateByPrimaryKeySelective(Space record);

    int updateByPrimaryKey(Space record);
}