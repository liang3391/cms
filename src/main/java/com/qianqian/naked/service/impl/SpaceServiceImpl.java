package com.qianqian.naked.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qianqian.common.mapper.SpaceMapper;
import com.qianqian.common.model.Space;
import com.qianqian.naked.service.ISpaceService;
/**
 * 图片空间的service
 * @Project 	: cms.maxtp
 * @Program Name: com.qianqian.naked.service.impl.SpaceServiceImpl.java
 * @ClassName	: SpaceServiceImpl 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年5月23日 下午1:54:12
 */
@Service("spaceService")
public class SpaceServiceImpl implements ISpaceService {
	@Resource
	private SpaceMapper spaceMapper;
	@Override
	public void addSpace(Space space) {
		spaceMapper.insert(space);

	}

}
