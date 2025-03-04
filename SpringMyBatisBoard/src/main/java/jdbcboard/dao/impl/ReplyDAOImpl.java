package jdbcboard.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jdbcboard.dao.ReplyDAO;
import jdbcboard.mapper.ReplyMapper;
import jdbcboard.model.Reply;
import jdbcboard.util.SqlMapUtil;

@Repository("replyDAO")
public class ReplyDAOImpl implements ReplyDAO {
	
	@Autowired
	private ReplyMapper replyMapper;

	@Override
	public List<Reply> selectReply() {
//		SqlSession sqlSession = SqlMapUtil.getSqlSession();
//		List<Reply> replyList = sqlSession.selectList("reply.selectReply");
//		sqlSession.close();		
		return replyMapper.selectReply();
	}
	
	@Override
	public Reply getReply(int rid) {
//		SqlSession sqlSession = SqlMapUtil.getSqlSession();
//		Reply reply = sqlSession.selectOne("reply.getReply", rid);
//		sqlSession.close();		
		return replyMapper.getReply(rid);
	}
	
	@Override
	public int insertReply(Reply reply) {
//		SqlSession sqlSession = SqlMapUtil.getSqlSession();
//		int result = sqlSession.insert("reply.insertReply", reply);
//		sqlSession.commit();
//		sqlSession.close();		
		return replyMapper.insertReply(reply);
	}
	
	@Override
	public int updateReply(Reply reply) {
//		SqlSession sqlSession = SqlMapUtil.getSqlSession();
//		int result = sqlSession.update("reply.updateReply", reply);
//		sqlSession.commit();
//		sqlSession.close();			
		return replyMapper.updateReply(reply);
	}
	
	@Override
	public int deleteReply(int rid) {
//		SqlSession sqlSession = SqlMapUtil.getSqlSession();
//		int result = sqlSession.delete("reply.deleteReply", rid);
//		sqlSession.commit();
//		sqlSession.close();			
		return replyMapper.deleteReply(rid);
	}
	
}
