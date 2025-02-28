package jdbcboard.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jdbcboard.dao.BoardDAO;
import jdbcboard.model.Board;
import jdbcboard.util.SqlMapUtil;

public class BoardDAOImpl implements BoardDAO {

	private static BoardDAOImpl boardDAOImpl = new BoardDAOImpl();

	private BoardDAOImpl() {
	}

	public static BoardDAOImpl getBoardDAOImpl() {
		return boardDAOImpl;
	}

	@Override
	public List<Board> selectBoard() {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		List<Board> boardList = sqlSession.selectList("board.selectBoard");
		sqlSession.close();
		return boardList;
	}

	@Override
	public Board getBoard(int bid) {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		Board board = sqlSession.selectOne("board.getBoard", bid);
		sqlSession.close();
		return board;
	}

	@Override
	public int insertBoard(Board board) {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		int result = sqlSession.insert("board.insertBoard", board);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public int updateBoard(Board board) {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		int result = sqlSession.update("board.updateBoard", board);
		sqlSession.commit();
		sqlSession.close();		
		return result;
	}

	@Override
	public int deleteBoard(int bid) {
		SqlSession sqlSession = SqlMapUtil.getSqlSession();
		int result = sqlSession.delete("board.deleteBoard", bid);	
		sqlSession.commit();
		sqlSession.close();		
		return result;
	}

}
