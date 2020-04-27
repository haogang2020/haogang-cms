package com.haogang.cms.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.haogang.cms.domain.Article;
import com.haogang.cms.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class ArticleServiceImplTest {

	@Resource 
	private ArticleService articleService;
	@Test
	public void testSelects() {
		List<Article> list = articleService.selects();
		System.out.println(list);
	}

}
