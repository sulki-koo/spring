package jdbcboard.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jdbcboard.dao.ReplyDAO;
import jdbcboard.model.Reply;
import jdbcboard.util.SqlMapUtil;

public class ReplyDAOImpl implements ReplyDAO {
	
	private static ReplyDAOImpl replyDAOImpl = new ReplyDAOImpl();
	
	private ReplyDAOImpl() {
	}
	
	public static ReplyDAOImpl getReplyDAOImpl() {
		return replyDAOImpl;
	}
	
	@Override
	public List<Reply> selectReply() {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		List<Reply> replyList = sqlSession.selectList("reply.selectReply");
		sqlSession.close();		
		return replyList;
	}
	
	@Override
	public Reply getReply(int rid) {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		Reply reply = sqlSession.selectOne("reply.getReply", rid);
		sqlSession.close();		
		return reply;
	}
	
	@Override
	public int insertReply(Reply reply) {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		int result = sqlSession.insert("reply.insertReply", reply);
		sqlSession.commit();
		sqlSession.close();		
		return result;
	}
	
	@Override
	public int updateReply(Reply reply) {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		int result = sqlSession.update("reply.updateReply", reply);
		sqlSession.commit();
		sqlSession.close();			
		return result;
	}
	
	@Override
	public int deleteReply(int rid) {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		int result = sqlSession.delete("reply.deleteReply", rid);
		sqlSession.commit();
		sqlSession.close();			
		return result;
	}
	
}
