package jdbcboard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jdbcboard.dao.BoardDAO;
import jdbcboard.model.Board;
import jdbcboard.service.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<Board> selectBoard() {
		return boardDAO.selectBoard();
	}
	
	@Override
	public Board getBoard(int bid) {
		return boardDAO.getBoard(bid);
	}
	
	@Override
	public int insertBoard(Board board) {
		return boardDAO.insertBoard(board);
	}
	
	@Override
	public int updateBoard(Board board) {
		return boardDAO.updateBoard(board);
	}
	
	@Override
	public int deleteBoard(int bid) {
		return boardDAO.deleteBoard(bid);
	}

}
