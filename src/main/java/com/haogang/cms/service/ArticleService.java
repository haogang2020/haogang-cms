package com.haogang.cms.service;

import com.github.pagehelper.PageInfo;
import com.haogang.cms.domain.Article;

/**
 * ArticleService
 * @author 86178
 *
 */
public interface ArticleService {
	
	/**
	 * 文章列表
	 * @param article
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<Article> selects(Article article,Integer pageNum,Integer pageSize);
	
	/**
	 * 查询文章详情
	 * @param id
	 * @return
	 */
	Article select(Integer id);
	
	/**
	 * 增加（发布）文章
	 * @param article
	 * @return
	 */
	int insert(Article article);	
}
