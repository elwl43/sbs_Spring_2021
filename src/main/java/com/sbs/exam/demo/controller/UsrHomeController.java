package com.sbs.exam.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class UsrHomeController {
	
	@RequestMapping("/usr/home/getString")
	@ResponseBody
	public String getString() {
		return "Hi";
	}
	@RequestMapping("/usr/home/getInt")
	@ResponseBody
	public int getInt() {
		return 10;
	}
	@RequestMapping("/usr/home/getFloat")
	@ResponseBody
	public float getFloat() {
		return 10.5f;
	}
	@RequestMapping("/usr/home/getDouble")
	@ResponseBody
	public double getDouble() {
		return 10.5;
	}
	@RequestMapping("/usr/home/getBoolean")
	@ResponseBody
	public boolean getBoolean() {
		return true;
	}
	@RequestMapping("/usr/home/getChar")
	@ResponseBody
	public char getChar() {
		return 'a';
	}
	@RequestMapping("/usr/home/getMap")
	@ResponseBody
	public Map getMap() {
		Map<String, Object> map = new HashMap<>();
		
		map.put("철수의 나이", 22);
		map.put("영희의 나이", 33);
		
		return map;
	}
	@RequestMapping("/usr/home/getList")
	@ResponseBody
	public List<String> getList() {
		List<String> list = new ArrayList<>();
		
		list.add("철수의 나이");
		list.add("영히의 나이");
		
		return list;
	}
	@RequestMapping("/usr/home/getArticle")
	@ResponseBody
	public Article getArticle() {
		Article article = new Article(1, "제목1");
		Article article1 = new Article();
		
		return article;
	}
	@RequestMapping("/usr/home/getArticles")
	@ResponseBody
	public List<Article> getArticles(){
		Article article1 = new Article(1, "제목1");
		Article article2 = new Article(2, "제목2");
		
		List<Article> list = new ArrayList<>();
		
		list.add(article1);
		list.add(article2);
		
		return list;
	}
}
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	class Article{
		private int id;
		private String title;
	}

