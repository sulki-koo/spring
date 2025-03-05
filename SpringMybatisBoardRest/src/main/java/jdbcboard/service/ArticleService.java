package jdbcboard.service;

import java.util.List;

import jdbcboard.model.Article;
import jdbcboard.model.ArticleCriteria;

public interface ArticleService {

	public abstract List<Article> selectArticle(ArticleCriteria articleCriteria);

	public abstract Article getArticle(int aid);

	public abstract int insertArticle(Article article);

	public abstract int updateArticle(Article article);

	public abstract int deleteArticle(int aid);

	public abstract int increaseAvcnt(int aid);

}
