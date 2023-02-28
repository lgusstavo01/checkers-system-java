package checkers.game;

import checkers.boardgame.Board;
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
	
	public void placeNewPiece(char column, int row, CheckersPiece piece) {
		board.placePiece(piece, new CheckersPosition(column, row).toPosition());
	}
	
	public void initialSetup() {
		placeNewPiece('a', 8, new Pawn(board, Color.BLACK));
		placeNewPiece('c', 8, new Pawn(board, Color.BLACK));
		placeNewPiece('e', 8, new Pawn(board, Color.BLACK));
		placeNewPiece('g', 8, new Pawn(board, Color.BLACK));
		placeNewPiece('b', 7, new Pawn(board, Color.BLACK));
		placeNewPiece('d', 7, new Pawn(board, Color.BLACK));
		placeNewPiece('f', 7, new Pawn(board, Color.BLACK));
		placeNewPiece('h', 7, new Pawn(board, Color.BLACK));
		placeNewPiece('a', 6, new Pawn(board, Color.BLACK));
		placeNewPiece('c', 6, new Pawn(board, Color.BLACK));
		placeNewPiece('e', 6, new Pawn(board, Color.BLACK));
		placeNewPiece('g', 6, new Pawn(board, Color.BLACK));

		placeNewPiece('a', 1, new Pawn(board, Color.BLACK));
		placeNewPiece('c', 1, new Pawn(board, Color.BLACK));
		placeNewPiece('e', 1, new Pawn(board, Color.BLACK));
		placeNewPiece('g', 1, new Pawn(board, Color.BLACK));
		placeNewPiece('b', 2, new Pawn(board, Color.BLACK));
		placeNewPiece('d', 2, new Pawn(board, Color.BLACK));
		placeNewPiece('f', 2, new Pawn(board, Color.BLACK));
		placeNewPiece('h', 2, new Pawn(board, Color.BLACK));
		placeNewPiece('a', 3, new Pawn(board, Color.BLACK));
		placeNewPiece('c', 3, new Pawn(board, Color.BLACK));
		placeNewPiece('e', 3, new Pawn(board, Color.BLACK));
		placeNewPiece('g', 3, new Pawn(board, Color.BLACK));
	}
}