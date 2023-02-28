package checkers.game;

import checkers.boardgame.Board;
import checkers.boardgame.Piece;
import checkers.boardgame.Position;
import checkers.exception.BoardException;
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
	
	/*===== Metodo responsavel por realizar a jogada =====*/
	public CheckersPiece performCheckersMove(CheckersPosition sourcePosition, CheckersPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validatePositionSource(source);
		Piece capturedPiece = makeMove(source, target);
		return (CheckersPiece)capturedPiece;
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	public void placeNewPiece(char column, int row, CheckersPiece piece) {
		board.placePiece(piece, new CheckersPosition(column, row).toPosition());
	}
	
	public void validatePositionSource(Position position) {
		if(!board.thereIsAPiece(position))
			throw new BoardException("There is no part in the origin position.");
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

		placeNewPiece('a', 1, new Pawn(board, Color.WHITE));
		placeNewPiece('c', 1, new Pawn(board, Color.WHITE));
		placeNewPiece('e', 1, new Pawn(board, Color.WHITE));
		placeNewPiece('g', 1, new Pawn(board, Color.WHITE));
		placeNewPiece('b', 2, new Pawn(board, Color.WHITE));
		placeNewPiece('d', 2, new Pawn(board, Color.WHITE));
		placeNewPiece('f', 2, new Pawn(board, Color.WHITE));
		placeNewPiece('h', 2, new Pawn(board, Color.WHITE));
		placeNewPiece('a', 3, new Pawn(board, Color.WHITE));
		placeNewPiece('c', 3, new Pawn(board, Color.WHITE));
		placeNewPiece('e', 3, new Pawn(board, Color.WHITE));
		placeNewPiece('g', 3, new Pawn(board, Color.WHITE));
	}
}