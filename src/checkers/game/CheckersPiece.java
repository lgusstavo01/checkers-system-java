package checkers.game;

import checkers.boardgame.Board;
import checkers.boardgame.Piece;

public abstract class CheckersPiece extends Piece{
	private Color color;

	public CheckersPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
}