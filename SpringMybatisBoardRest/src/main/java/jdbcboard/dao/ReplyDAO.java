package jdbcboard.dao;

import java.util.List;

import jdbcboard.model.Reply;

public interface ReplyDAO {
	
	public abstract List<Reply> selectReply();

	public abstract Reply getReply(int rid);

	public abstract int insertReply(Reply reply);

	public abstract int updateReply(Reply reply);

	public abstract int deleteReply(int rid);

}
