package jdbcboard.service;

import java.util.List;

import jdbcboard.model.Board;

public interface BoardService {
	
	public abstract List<Board> selectBoard();

	public abstract Board getBoard(int bid);

	public abstract int insertBoard(Board board);

	public abstract int updateBoard(Board board);

	public abstract int deleteBoard(int bid);

}
