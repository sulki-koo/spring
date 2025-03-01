package jdbcboard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jdbcboard.dao.ReplyDAO;
import jdbcboard.model.Reply;
import jdbcboard.service.ReplyService;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDAO replyDAO;
	
	@Override
	public List<Reply> selectReply() {
		return replyDAO.selectReply();
	}
	
	@Override
	public Reply getReply(int rid) {
		return replyDAO.getReply(rid);
	}
	
	@Override
	public int insertReply(Reply reply) {
		return replyDAO.insertReply(reply);
	}
	
	@Override
	public int updateReply(Reply reply) {
		return replyDAO.updateReply(reply);
	}
	
	@Override
	public int deleteReply(int rid) {
		return replyDAO.deleteReply(rid);
	}

}
