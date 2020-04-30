package com.haogang.cms.dao;

import java.util.List;

import com.haogang.cms.domain.Article;

/**
 * 文章mapper
 * @author 86178
 *
 */
public interface ArticleMapper {

	/**
	 * 文章的列表查询
	 * @param article
	 * @return
	 */
	List<Article> selects(Article article);
	
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
