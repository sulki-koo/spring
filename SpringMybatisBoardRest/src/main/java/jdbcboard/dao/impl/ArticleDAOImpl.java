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
//		SqlSession sqlSession = SqlMapUtil.getSqlSession();
//		List<Article> articleList = sqlSession.selectList("article.selectArticle", articleCriteria);
//		sqlSession.close();
		return articleMapper.selectArticle(articleCriteria);
	}

	@Override
	public Article getArticle(int aid) {
//		SqlSession sqlSession = SqlMapUtil.getSqlSession();
//		Article article = sqlSession.selectOne("article.getArticle", aid);
//		sqlSession.close();
		return articleMapper.getArticle(aid);
	}

	@Override
	public int insertArticle(Article article) {
//		SqlSession sqlSession = SqlMapUtil.getSqlSession();
//		int result = sqlSession.insert("article.insertArticle", article);
//		sqlSession.commit();
//		sqlSession.close();
		return articleMapper.insertArticle(article);
	}

	@Override
	public int updateArticle(Article article) {
//		SqlSession sqlSession = SqlMapUtil.getSqlSession();
//		int result = sqlSession.update("article.updateArticle", article);
//		sqlSession.commit();
//		sqlSession.close();
		return articleMapper.updateArticle(article);
	}

	@Override
	public int deleteArticle(int aid) {
//		SqlSession sqlSession = SqlMapUtil.getSqlSession();
//		int result = sqlSession.delete("article.deleteArticle", aid);
//		sqlSession.commit();
//		sqlSession.close();
		return articleMapper.deleteArticle(aid);
	}

	@Override
	public int increaseAvcnt(int aid) {
//		SqlSession sqlSession = SqlMapUtil.getSqlSession();
//		int result = sqlSession.update("article.increaseAvcnt", aid);
//		sqlSession.commit();
//		sqlSession.close();
		return articleMapper.increaseAvcnt(aid);
	}

}
