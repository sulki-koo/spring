package jdbcboard.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jdbcboard.dao.ArticleDAO;
import jdbcboard.mapper.ArticleMapper;
import jdbcboard.mapper.ReplyMapper;
import jdbcboard.model.Article;
import jdbcboard.model.ArticleCriteria;
import jdbcboard.util.SqlMapUtil;

@Repository("articleDAO")
public class ArticleDAOImpl implements ArticleDAO {

	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public List<Article> selectArticle(ArticleCriteria articleCriteria) {
		return articleMapper.selectArticle(articleCriteria);
	}

	@Override
	public Article getArticle(int aid) {
		return articleMapper.getArticle(aid);
	}

	@Override
	public int insertArticle(Article article) {
		return articleMapper.insertArticle(article);
	}

	@Override
	public int updateArticle(Article article) {
		return articleMapper.updateArticle(article);
	}

	@Override
	public int deleteArticle(int aid) {
		return articleMapper.deleteArticle(aid);
	}

	@Override
	public int increaseAvcnt(int aid) {
		return articleMapper.increaseAvcnt(aid);
	}

	@Override
	public int getSequenceNextVal() {
		return articleMapper.getSequenceNextVal();
	}
	
}
