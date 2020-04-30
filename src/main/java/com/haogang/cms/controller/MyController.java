package com.haogang.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.haogang.cms.domain.Article;
import com.haogang.cms.domain.Category;
import com.haogang.cms.domain.Channel;
import com.haogang.cms.service.ArticleService;
import com.haogang.cms.service.ChannelService;

/**
 * 个人中心
 * @author 86178
 *
 */
@RequestMapping("my")
@Controller
public class MyController {

	@Resource
	private ArticleService articleService;
	@Resource
	private ChannelService channelService;
	/**
	 * 进入个人首页
	 * @return
	 * 地址栏可以输入my  my/index都能进入首页
	 */
	@RequestMapping(value = {"","/","index"})
	public String index() {
		return "my/index";
	}
	
	/**
	 * 我的文章
	 * @param model
	 * @param article
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("articles")	
	public String article(Model model,Article article,@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "6")Integer pageSize) {
		PageInfo<Article> info = articleService.selects(article, pageNum, pageSize);
		model.addAttribute("info", info);
		return "my/articles";
	}
	
	/**
	 * 文章详情
	 * @param id
	 * @return
	 */
	@RequestMapping("article")	
	@ResponseBody
	public Article article(Integer id) {
		return articleService.select(id);	
	}
	
	/**
	 * 去发布文章页面
	 * @return
	 */
	@GetMapping("publish")	
	public String publish() {
		return "my/publish";
	}
	
	/**
	 * 执行发布文章
	 * @return
	 */
	@PostMapping("publish")	
	@ResponseBody
	public boolean publish(MultipartFile file,Article article) {
		//判断是否选择文件
		if(null!=file && !file.isEmpty()) {
			String path = "d:/pic/";//文件上传地址
			//为防止文件名重名，需要对文件进行处理
			String fileName = file.getOriginalFilename();//原始名称
			//新的文件名
			String newFilename = UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("."));
			File f = new File(path, newFilename);//根据地址构建新的文件
			try {
				file.transferTo(f);//文件写入硬盘
				article.setPicture(newFilename);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//初始化发布文件的属性信息
		article.setUserId(22);//发布人
		article.setStatus(0);//0:待审核 
		article.setCreated(new Date());//发布时间
		article.setUpdated(new Date());//修改时间
		article.setDeleted(0);//正常
		article.setHot(0);//0：非热门 1：热门
		article.setContentType("0");//0：html 1:json
		return articleService.insert(article)>0;
	}
	
	/**
	 * 查询所有的分类
	 * @return
	 */
	@RequestMapping("channels")
	@ResponseBody
	public List<Channel> channels(){
		return channelService.selects();
	}
	
	/**
	 * 根据栏目查询分类
	 * @param channelId
	 * @return
	 */
	@RequestMapping("selectCategorysByChannelId")
	@ResponseBody
	public List<Category> categorys(Integer channelId){
		return channelService.selectCategoryByChannelId(channelId);
	}
	
	
	
}
