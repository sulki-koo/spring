package jdbcboard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jdbcboard.dao.ArticleDAO;
import jdbcboard.model.Article;
import jdbcboard.model.ArticleCriteria;
import jdbcboard.service.ArticleService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleDAO articleDAO;
	
	@Override
	public List<Article> selectArticle(ArticleCriteria articleCriteria) {
		return articleDAO.selectArticle(articleCriteria);
	}
	
	@Override
	public Article getArticle(int aid) {
		return articleDAO.getArticle(aid);
	}
	
	@Override
	public int insertArticle(Article article) {
		return articleDAO.insertArticle(article);
	}
	
	@Override
	public int updateArticle(Article article) {
		return articleDAO.updateArticle(article);
	}
	
	@Override
	public int deleteArticle(int aid) {
		return articleDAO.deleteArticle(aid);
	}
	
	@Override
	public int increaseAvcnt(int aid) {
		return articleDAO.increaseAvcnt(aid);
	}
	
	@Override
	public int getSequenceNextVal() {
		return articleDAO.getSequenceNextVal();
	}
	
	@Override
	public int getTotalRowCount(ArticleCriteria articleCriteria) {
		return articleDAO.getTotalRowCount(articleCriteria);
	}

}
