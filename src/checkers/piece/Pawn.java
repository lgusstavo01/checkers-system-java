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
}