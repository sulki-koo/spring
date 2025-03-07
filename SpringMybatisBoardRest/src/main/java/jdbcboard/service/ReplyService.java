package jdbcboard.service;

import java.util.List;

import jdbcboard.model.Reply;

public interface ReplyService {
	
	public abstract List<Reply> selectReply(int aid);

	public abstract Reply getReply(int rid);

	public abstract int insertReply(Reply reply);

	public abstract int updateReply(Reply reply);

	public abstract int deleteReply(int rid);

}
