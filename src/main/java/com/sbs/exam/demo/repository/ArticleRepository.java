package com.sbs.exam.demo.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.sbs.exam.demo.vo.Article;

@Mapper
public interface ArticleRepository {

	public void writeArticle(@Param("memberId") int memberId, @Param("boardId") int boardId,
			@Param("title") String title, @Param("body") String body);	public Article getArticle(@Param("id") int id);
	public void deleteArticle(@Param("id") int id);
	public void modifyArticle(@Param("id") int id, @Param("title") String title, @Param("body") String body);
	public List<Article> getArticles(int boardId, String searchKeywordTypeCode, String searchKeyword,
			int limitStart, int limitTake);
	public int getLastInsertId();
	public int getArticlesCount(int boardId, String searchKeywordTypeCode, String searchKeyword);
}