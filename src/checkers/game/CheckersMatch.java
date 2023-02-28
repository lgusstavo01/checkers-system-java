package checkers.game;

import boardgame.Board;
import boardgame.Position;
import checkers.piece.Pawn;

public class CheckersMatch {
	private Board board;
	
	public CheckersMatch() {
		board = new Board(8, 8);	
		initialSetup();
	}
	
	public CheckersPiece[][] getPiece(){
		CheckersPiece[][] temp = new CheckersPiece[board.getRows()][board.getColumns()];
		
		for(int i = 0; i < board.getRows(); i++) {
			for(int j = 0; j < board.getColumns(); j++) {
				temp[i][j] = (CheckersPiece)board.piece(i, j);
			}
		}
		return temp;
	}
	
	public void initialSetup() {
		board.placePiece(new Pawn(board, Color.BLACK), new Position(0, 0));
		board.placePiece(new Pawn(board, Color.BLACK), new Position(0, 2));
		board.placePiece(new Pawn(board, Color.BLACK), new Position(0, 4));
		board.placePiece(new Pawn(board, Color.BLACK), new Position(0, 6));
		board.placePiece(new Pawn(board, Color.BLACK), new Position(1, 1));
		board.placePiece(new Pawn(board, Color.BLACK), new Position(1, 3));
		board.placePiece(new Pawn(board, Color.BLACK), new Position(1, 5));
		board.placePiece(new Pawn(board, Color.BLACK), new Position(1, 7));
		board.placePiece(new Pawn(board, Color.BLACK), new Position(2, 0));
		board.placePiece(new Pawn(board, Color.BLACK), new Position(2, 2));
		board.placePiece(new Pawn(board, Color.BLACK), new Position(2, 4));
		board.placePiece(new Pawn(board, Color.BLACK), new Position(2, 6));
		
		board.placePiece(new Pawn(board, Color.WHITE), new Position(7, 0));
		board.placePiece(new Pawn(board, Color.WHITE), new Position(7, 2));
		board.placePiece(new Pawn(board, Color.WHITE), new Position(7, 4));
		board.placePiece(new Pawn(board, Color.WHITE), new Position(7, 6));
		board.placePiece(new Pawn(board, Color.WHITE), new Position(6, 1));
		board.placePiece(new Pawn(board, Color.WHITE), new Position(6, 3));
		board.placePiece(new Pawn(board, Color.WHITE), new Position(6, 5));
		board.placePiece(new Pawn(board, Color.WHITE), new Position(6, 7));
		board.placePiece(new Pawn(board, Color.WHITE), new Position(5, 0));
		board.placePiece(new Pawn(board, Color.WHITE), new Position(5, 2));
		board.placePiece(new Pawn(board, Color.WHITE), new Position(5, 4));
		board.placePiece(new Pawn(board, Color.WHITE), new Position(5, 6));

	}
}