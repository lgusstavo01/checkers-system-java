package checkers.game;

import checkers.boardgame.Board;
import checkers.boardgame.Piece;
import checkers.boardgame.Position;

public abstract class CheckersPiece extends Piece{
	private Color color;
	
	public CheckersPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	/*===== Metodo responsavel por verificar se a peca e do adversario. =====*/
	protected boolean isThereOpponentPiece(Position position) {
		CheckersPiece p = (CheckersPiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
}