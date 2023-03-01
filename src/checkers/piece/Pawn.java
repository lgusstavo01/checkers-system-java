package checkers.piece;

import checkers.boardgame.Board;
import checkers.boardgame.Position;
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
		
		Position p = new Position(0, 0);
		
		if(getColor() == Color.WHITE) {
			/*===== Nordeste =====*/
			p.setValues(position.getRow() - 1, position.getColumn() + 1);	
			if(getBoard().positionExistis(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			if(getBoard().positionExistis(p) && isThereOpponentPiece(p)) {
				p.setValues(position.getRow() - 2, position.getColumn() + 2);
					if(getBoard().positionExistis(p) && !getBoard().thereIsAPiece(p))
						mat[p.getRow()][p.getColumn()] = true;
			}
			
			/*===== Noroeste =====*/
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if(getBoard().positionExistis(p) && !getBoard().thereIsAPiece(p)) 
				mat[p.getRow()][p.getColumn()] = true;
			
			if(getBoard().positionExistis(p) && isThereOpponentPiece(p)) {
				p.setValues(position.getRow() - 2, position.getColumn() - 2);
					if(getBoard().positionExistis(p) && !getBoard().thereIsAPiece(p))
						mat[p.getRow()][p.getColumn()] = true;
			}
		}
		
		if(getColor() == Color.BLACK) {
			/*===== Sudeste =====*/
			p.setValues(position.getRow() + 1, position.getColumn() + 1);	
			if(getBoard().positionExistis(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			if(getBoard().positionExistis(p) && isThereOpponentPiece(p)) {
				p.setValues(position.getRow() + 2, position.getColumn() + 2);
				if(getBoard().positionExistis(p) && !getBoard().thereIsAPiece(p))
						mat[p.getRow()][p.getColumn()] = true;
			}
			
			/*===== Sudoeste ======*/
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if(getBoard().positionExistis(p) && !getBoard().thereIsAPiece(p)) 
				mat[p.getRow()][p.getColumn()] = true;
			
			if(getBoard().positionExistis(p) && isThereOpponentPiece(p)) {
				p.setValues(position.getRow() + 2, position.getColumn() - 2);
					if(getBoard().positionExistis(p) && !getBoard().thereIsAPiece(p))
						mat[p.getRow()][p.getColumn()] = true;
			}
		}
		return mat;
	}
}