package jdbcboard.service.impl;

import java.util.List;

import jdbcboard.dao.impl.BoardDAOImpl;
import jdbcboard.model.Board;
import jdbcboard.service.BoardService;

public class BoardServiceImpl implements BoardService {
	
	private static BoardServiceImpl boardServiceImpl = new BoardServiceImpl();
	private BoardDAOImpl boardDAOImpl;
	
	private BoardServiceImpl() {
		boardDAOImpl = BoardDAOImpl.getBoardDAOImpl();
	}
	
	public static BoardServiceImpl getBoardServiceImpl() {
		return boardServiceImpl;
	}
	
	@Override
	public List<Board> selectBoard() {
		return boardDAOImpl.selectBoard();
	}
	
	@Override
	public Board getBoard(int bid) {
		return boardDAOImpl.getBoard(bid);
	}
	
	@Override
	public int insertBoard(Board board) {
		return boardDAOImpl.insertBoard(board);
	}
	
	@Override
	public int updateBoard(Board board) {
		return boardDAOImpl.updateBoard(board);
	}
	
	@Override
	public int deleteBoard(int bid) {
		return boardDAOImpl.deleteBoard(bid);
	}

}
