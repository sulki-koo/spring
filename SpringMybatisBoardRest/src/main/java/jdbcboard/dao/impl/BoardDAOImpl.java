package jdbcboard.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jdbcboard.dao.BoardDAO;
import jdbcboard.mapper.BoardMapper;
import jdbcboard.model.Board;
import jdbcboard.util.SqlMapUtil;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<Board> selectBoard() {
//		SqlSession sqlSession = SqlMapUtil.getSqlSession();
//		List<Board> boardList = sqlSession.selectList("board.selectBoard");
//		sqlSession.close();
		return boardMapper.selectBoard();
	}

	@Override
	public Board getBoard(int bid) {
//		SqlSession sqlSession = SqlMapUtil.getSqlSession();
//		Board board = sqlSession.selectOne("board.getBoard", bid);
//		sqlSession.close();
		return boardMapper.getBoard(bid);
	}

	@Override
	public int insertBoard(Board board) {
//		SqlSession sqlSession = SqlMapUtil.getSqlSession();
//		int result = sqlSession.insert("board.insertBoard", board);
//		sqlSession.commit();
//		sqlSession.close();
		return boardMapper.insertBoard(board);
	}

	@Override
	public int updateBoard(Board board) {
//		SqlSession sqlSession = SqlMapUtil.getSqlSession();
//		int result = sqlSession.update("board.updateBoard", board);
//		sqlSession.commit();
//		sqlSession.close();		
		return boardMapper.updateBoard(board);
	}

	@Override
	public int deleteBoard(int bid) {
//		SqlSession sqlSession = SqlMapUtil.getSqlSession();
//		int result = sqlSession.delete("board.deleteBoard", bid);	
//		sqlSession.commit();
//		sqlSession.close();		
		return boardMapper.deleteBoard(bid);
	}

}
