package jdbcboard.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jdbcboard.model.Article;
import jdbcboard.model.ArticleCriteria;
import jdbcboard.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:jdbcboard/conf/applicationContext.xml")
public class ArticleServiceTest {

	@Autowired
	private	ArticleService articleService;
		
	@Test
	public void test() throws Throwable {
		List<Article> articleList = articleService.selectArticle(new ArticleCriteria(null, null, null));
		System.out.println(articleList);
	}
}
