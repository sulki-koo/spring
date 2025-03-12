package jdbcboard.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jdbcboard.model.Article;
import jdbcboard.model.ArticleCriteria;
import jdbcboard.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/articles")
	public ModelAndView selectArticle(@ModelAttribute ArticleCriteria articleCriteria) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("articleList", articleService.selectArticle(articleCriteria));
		mav.addObject("articleCriteria", articleCriteria);
		mav.setViewName("/article/listArticle");
		return mav;
	}
	
	@GetMapping("/articles/{aid}")
	public ModelAndView getArticle(@PathVariable int aid) {
		articleService.increaseAvcnt(aid);
		ModelAndView mav = new ModelAndView();
		mav.addObject("article", articleService.getArticle(aid));
		mav.setViewName("/article/getArticle");
		return mav;
	}
	
	@GetMapping("/insertArticleForm")
	public String insertArticleForm() {
		return "/article/insertArticleForm";
	}
	
	@PostMapping("/articles")
	@ResponseBody
	public String insertArticle(@RequestBody Article article) {
		int sequenceNextVal = articleService.getSequenceNextVal();
		article.setAid(sequenceNextVal);
		articleService.insertArticle(article);
		String aidJson = "{\"aid\":"+ sequenceNextVal +"}";
		return aidJson;
	}
	
	@GetMapping("/updateArticleForm/{aid}")
	public ModelAndView updateArticleForm(@PathVariable int aid) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("article", articleService.getArticle(aid));
		mav.setViewName("/article/updateArticleForm");
		return mav;
	}
	
	@PutMapping("/articles")
	@ResponseBody
	public String updateArticle(@RequestBody Article article){
		articleService.updateArticle(article);
		String aidJson = "{\"aid\":"+ article.getAid() +"}";
		return aidJson;
	}
	
	@DeleteMapping("/articles/{aid}")
	@ResponseBody
	public Map<String, Integer> deleteArticle(@PathVariable int aid){
		int result = articleService.deleteArticle(aid);
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		resultMap.put("result", result);
		return resultMap;
	}
	
}
