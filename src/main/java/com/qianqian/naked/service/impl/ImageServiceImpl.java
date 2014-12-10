package com.qianqian.naked.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.qianqian.common.mapper.ImageMapper;
import com.qianqian.common.model.Image;
import com.qianqian.common.model.ImageExample;
import com.qianqian.naked.service.IImageService;

/**
 * 对图片的操作
 * 
 * @Project : cms.maxtp
 * @Program Name: com.qianqian.naked.service.impl.ImageServiceImpl.java
 * @ClassName : ImageServiceImpl
 * @Author : shenzhenxing
 * @CreateDate : 2014年5月23日 上午11:28:16
 */
@Service("imageService")
public class ImageServiceImpl implements IImageService {
	private Logger log = LoggerFactory.getLogger(ImageServiceImpl.class);
	@Resource
	private ImageMapper imageMapper;

	/**
	 * 增加图片
	 */
	public void addImage(Image image) {
		log.info("image info:" + image);
		image.setCreateTime(new Date());// 当前创建时间
		image.setImageState(1);
		image.setSpaceId(100l);// 当前登录用户的默认图片空间ID
		image.setUpdateTime(new Date());// 当前修改时间
		imageMapper.insert(image);

	}

	/**
	 * 删除图片
	 */
	public void deleteImage(Image image) {
		log.info("delete image :" + image);
		// 图片只进行逻辑删除
		image.setImageState(0);
		imageMapper.updateByPrimaryKeySelective(image);
		// imageMapper.deleteByPrimaryKey(imageId);
	}

	/**
	 * 根据空间id查找空间下的图片
	 */
	public List<Image> getAllImage(Long spaceId, PageBounds page) {
		ImageExample example = new ImageExample();
		example.createCriteria().andSpaceIdEqualTo(spaceId)
				.andImageStateEqualTo(1);
		List<Image> images = imageMapper.selectByExample(example, page);
		return images;
	}

	/**
	 * 根据空间id和图片名称查找空间下的图片
	 */
	public List<Image> getAllImage(Long spaceId, String imageNmae,
			PageBounds page) {
		ImageExample example = new ImageExample();
		example.createCriteria().andSpaceIdEqualTo(spaceId)
				.andImageNameLike("%" + imageNmae + "%")
				.andImageStateEqualTo(1);
		List<Image> images = imageMapper.selectByExample(example, page);
		return images;
	}

}
