package com.haogang.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.haogang.cms.dao.ChannelMapper;
import com.haogang.cms.domain.Category;
import com.haogang.cms.domain.Channel;
import com.haogang.cms.service.ChannelService;

@Service
public class ChannelServiceImpl implements ChannelService {

	@Resource
	ChannelMapper channelMapper;
	@Override
	public List<Channel> selects() {
		// TODO Auto-generated method stub
		return channelMapper.selects();
	}

	@Override
	public List<Category> selectCategoryByChannelId(Integer channelId) {
		// TODO Auto-generated method stub
		return channelMapper.selectCategoryByChannelId(channelId);
	}

}
