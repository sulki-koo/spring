package jdbcboard.test;

import jdbcboard.model.Article;
import jdbcboard.service.ArticleService;
import jdbcboard.service.impl.ArticleServiceImpl;

public class ArticleServiceTest {
	
	public static void main(String[] args) {
		
		ArticleService articleService = ArticleServiceImpl.getArticleServiceImpl();
		
		// insert
		for (int i=1; i<101; i++) {
			Article article = new Article(0, "새제목"+i, "새내용"+i, 0, null, "N", 0, 0, 3, "hong1", null);
			int result = articleService.insertArticle(article);
		}
//		if (result>0) {
//			System.out.println("입력 성공!");
//		}
		
		// update
//		Article article = new Article(1, "(수정)게시물제목", "(수정)게시물내용", 0, null, "N", 0, 0, 1, "hong", null);
//		int result = articleService.updateArticle(article);
//		if (result>0) {
//			System.out.println("수정 성공!");
//		}	
		
		// delete
//		int result = articleService.deleteArticle(3);
//		if (result>0) {
//			System.out.println("삭제 성공!");
//		}
		
		// select
//		List<Article> articleList = articleService.selectArticle();
//		for (Article article : articleList) {
//			System.out.println(article);
//		}
		
		// get
//		Article article = articleService.getArticle(1);
//		System.out.println(article);
		
	}

}












