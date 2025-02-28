package jdbcboard.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jdbcboard.dao.ArticleDAO;
import jdbcboard.model.Article;
import jdbcboard.model.ArticleCriteria;
import jdbcboard.util.SqlMapUtil;

public class ArticleDAOImpl implements ArticleDAO {
	
	private static ArticleDAOImpl articleDAOImpl = new ArticleDAOImpl();
	
	private ArticleDAOImpl() {
	}
	
	public static ArticleDAOImpl getArticleDAOImpl() {
		return articleDAOImpl;
	}
	
	@Override
	public List<Article> selectArticle(ArticleCriteria articleCriteria) {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		List<Article> articleList = sqlSession.selectList("article.selectArticle", articleCriteria);
		sqlSession.close();
		return articleList;
	}
	
	@Override
	public Article getArticle(int aid) {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		Article article = sqlSession.selectOne("article.getArticle", aid);
		sqlSession.close();
		return article;
	}
	
	@Override
	public int insertArticle(Article article) {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		int result = sqlSession.insert("article.insertArticle", article);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	@Override
	public int updateArticle(Article article) {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		int result = sqlSession.update("article.updateArticle", article);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	@Override
	public int deleteArticle(int aid) {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		int result = sqlSession.delete("article.deleteArticle", aid);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	@Override
	public int increaseAvcnt(int aid) {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		int result = sqlSession.update("article.increaseAvcnt", aid);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

}












