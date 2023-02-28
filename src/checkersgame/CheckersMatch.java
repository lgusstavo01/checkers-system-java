package checkersgame;

import boardgame.Board;

public class CheckersMatch {
	private Board board;
	
	public CheckersMatch() {
		board = new Board(8, 8);	
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
}