package jdbcboard.dao;

import java.util.List;

import jdbcboard.model.Reply;

public interface ReplyDAO {
	
	default List<Reply> selectReply() { return null; }
	
	default Reply getReply(int rid) { return null; }
	
	default int insertReply(Reply reply) { return 0; }
	
	default int updateReply(Reply reply) { return 0; }
	
	default int deleteReply(int rid) { return 0; }		

}
