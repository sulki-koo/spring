package jdbcboard.test;

import java.util.List;

import jdbcboard.model.Board;
import jdbcboard.service.BoardService;
import jdbcboard.service.impl.BoardServiceImpl;

public class BoardServiceTest {
	
	public static void main(String[] args) {
		
		BoardService boardService = BoardServiceImpl.getBoardServiceImpl();
		
		// insert
//		Board board = new Board(0, "유머게시판", 0);
//		int result = boardService.insertBoard(board);
//		if (result>0) {
//			System.out.println("등록 성공!");
//		}
		
		// update
//		Board board = new Board(3, "(수정)유머게시판", 0);
//		int result = boardService.updateBoard(board);
//		if (result>0) {
//			System.out.println("수정 성공!");
//		}		
		
		// delete
//		int result = boardService.deleteBoard(2);
//		if (result>0) {
//			System.out.println("삭제 성공!");
//		}
		
		// select
//		List<Board> boardList = boardService.selectBoard();
//		for (Board board : boardList) {
//			System.out.println(board);
//		}
		
		// get
//		Board board = boardService.getBoard(1);
//		System.out.println(board);
		
	}

}













