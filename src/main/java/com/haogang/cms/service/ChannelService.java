package com.haogang.cms.service;

import java.util.List;

import com.haogang.cms.domain.Category;
import com.haogang.cms.domain.Channel;

public interface ChannelService {

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
