package com.haogang.cms.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.haogang.cms.domain.Article;
import com.haogang.cms.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class ArticleServiceImplTest {

	@Resource 
	private ArticleService articleService;
	@Test
	public void testSelects() {
		PageInfo<Article> info = articleService.selects(new Article(),1,10);
		System.out.println(info.getList());
	}

}
