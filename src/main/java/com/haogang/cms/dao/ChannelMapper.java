package com.haogang.cms.dao;

import java.util.List;

import com.haogang.cms.domain.Category;
import com.haogang.cms.domain.Channel;

/**
 * 栏目
 * @author 86178
 *
 */
public interface ChannelMapper {

	/**
	 * 查询所有栏目
	 * @return
	 */
	List<Channel> selects();
	
	/**
	 * 根据栏目查询分类
	 * @param channelId
	 * @return
	 */
	List<Category> selectCategoryByChannelId(Integer channelId);
}
