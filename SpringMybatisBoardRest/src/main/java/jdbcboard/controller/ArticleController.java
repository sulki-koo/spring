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
	ArticleService articleService;
	
	@GetMapping("/articles")
	public ModelAndView selectArticle(@ModelAttribute ArticleCriteria articleCriteria) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("articleList", articleService.selectArticle(articleCriteria));
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
	public String insertArticle(@ModelAttribute Article article) {
		articleService.insertArticle(article);
		return "redirect:/article/articles";
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
	public Map<String, Integer> updateArticle(@RequestBody Article article){
		int result = articleService.updateArticle(article);
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		resultMap.put("result", result);
		return resultMap;
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
