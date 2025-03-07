package jdbcboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jdbcboard.model.Reply;
import jdbcboard.service.ReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@GetMapping("/replies/{aid}")
	public List<Reply> getReplyList(@PathVariable Integer aid) {
		return replyService.selectReply(aid);
	}
	
	@PostMapping("/replies")
	public Map<String, Integer> insertReply(@RequestBody Reply reply){
		int result = replyService.insertReply(reply);
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		resultMap.put("result", result);
		return resultMap;
	}
	
	@DeleteMapping("/replies/{rid}")
	public Map<String, Integer> deleteReply(@PathVariable Integer rid){
		int result = replyService.deleteReply(rid);
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		resultMap.put("result", result);
		return resultMap;
	}
	
}
