package checkers.piece;

import checkers.boardgame.Board;
import checkers.game.CheckersPiece;
import checkers.game.Color;

public class Pawn extends CheckersPiece{

	public Pawn(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		return mat;
	}
}