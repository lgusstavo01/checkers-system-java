package checkers.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import checkers.boardgame.Board;
import checkers.boardgame.Piece;
import checkers.boardgame.Position;
import checkers.exception.CheckersException;
import checkers.piece.Pawn;

public class CheckersMatch {
	private Board board;
	private int turn;
	private Color currentPlayer;

	public List<Piece> piecesOnTheBoard = new ArrayList<>();
	public List<Piece> capturedPieces = new ArrayList<>();

	public List<Piece> getPiecesOnTheBoard() {
		return piecesOnTheBoard;
	}

	public List<Piece> getCapturedPieces() {
		return capturedPieces;
	}

	public CheckersMatch() {
		board = new Board(8, 8);
		turn = 1;
		currentPlayer = Color.WHITE;
		initialSetup();
	}

	public int getTurn() {
		return turn;
	}

	public Color getCurrentPlayer() {
		return currentPlayer;
	}

	public CheckersPiece[][] getPiece() {
		CheckersPiece[][] temp = new CheckersPiece[board.getRows()][board.getColumns()];

		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				temp[i][j] = (CheckersPiece) board.piece(i, j);
			}
		}
		return temp;
	}

	public boolean end() {
		List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((CheckersPiece) x).getColor() == Color.WHITE)
				.collect(Collectors.toList());
		List<Piece> list1 = piecesOnTheBoard.stream().filter(x -> ((CheckersPiece) x).getColor() == Color.BLACK)
				.collect(Collectors.toList());

		if (list.size() == 0) {
			System.out.println();
			System.out.println("BLACK WIN !");
			return true;
		}
		if (list1.size() == 0) {
			System.out.println();
			System.out.println("WHITE WIN !");
			return true;
		}
		return false;
	}

	/* ===== Metodo responsavel por realizar a jogada ===== */
	public CheckersPiece performCheckersMove(CheckersPosition sourcePosition, CheckersPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validatePositionSource(source);
		validatePositionTarget(source, target);
		Piece capturedPiece = makeMove(source, target);
		if (target != null) {
			if (target.getRow() > source.getRow() && target.getColumn() > source.getColumn()) {
				Position pieceToRemove = new Position(target.getRow() - 1, target.getColumn() - 1);
				removePiece(pieceToRemove);
			}
			if (target.getRow() > source.getRow() && target.getColumn() < source.getColumn()) {
				Position pieceToRemove = new Position(target.getRow() - 1, target.getColumn() + 1);
				removePiece(pieceToRemove);
			}
			if (target.getRow() < source.getRow() && target.getColumn() > source.getColumn()) {
				Position pieceToRemove = new Position(target.getRow() + 1, target.getColumn() - 1);
				removePiece(pieceToRemove);
			}
			if (target.getRow() < source.getRow() && target.getColumn() < source.getColumn()) {
				Position pieceToRemove = new Position(target.getRow() + 1, target.getColumn() + 1);
				removePiece(pieceToRemove);
			}
		}
		nextTurn();
		return (CheckersPiece) capturedPiece;
	}

	private void removePiece(Position x) {
		Piece p = board.removePiece(x);
		piecesOnTheBoard.remove(p);
		getCapturedPieces().add(p);
	}

	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}

	public boolean[][] possibleMoves(CheckersPosition sourcePosition) {
		Position position = sourcePosition.toPosition();
		validatePositionSource(position);
		return board.piece(position).possibleMoves();
	}

	public void placeNewPiece(char column, int row, CheckersPiece piece) {
		board.placePiece(piece, new CheckersPosition(column, row).toPosition());
		piecesOnTheBoard.add(piece);
	}

	/* ===== Metodos responsaveis por validar o movimento da peca ====== */
	public void validatePositionSource(Position position) {
		if (!board.thereIsAPiece(position))
			throw new CheckersException("There is no part in the origin position.");
		if (!board.piece(position).isThereAnyPossibleMoves())
			throw new CheckersException("The piece is trapped. There is no movement possible.");
		if (currentPlayer != ((CheckersPiece) board.piece(position)).getColor())
			throw new CheckersException("There is a piece in position. But it's the opponent");
	}

	public void validatePositionTarget(Position source, Position target) {
		if (!board.piece(source).possibleMove(target))
			throw new CheckersException("The chosen piece cannot move to the target position.");
	}

	private void nextTurn() {
		turn++;
		currentPlayer = currentPlayer == Color.WHITE ? Color.BLACK : Color.WHITE;
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

		placeNewPiece('b', 1, new Pawn(board, Color.WHITE));
		placeNewPiece('d', 1, new Pawn(board, Color.WHITE));
		placeNewPiece('f', 1, new Pawn(board, Color.WHITE));
		placeNewPiece('h', 1, new Pawn(board, Color.WHITE));
		placeNewPiece('a', 2, new Pawn(board, Color.WHITE));
		placeNewPiece('c', 2, new Pawn(board, Color.WHITE));
		placeNewPiece('e', 2, new Pawn(board, Color.WHITE));
		placeNewPiece('g', 2, new Pawn(board, Color.WHITE));
		placeNewPiece('b', 3, new Pawn(board, Color.WHITE));
		placeNewPiece('d', 3, new Pawn(board, Color.WHITE));
		placeNewPiece('f', 3, new Pawn(board, Color.WHITE));
		placeNewPiece('h', 3, new Pawn(board, Color.WHITE));
		
	}
}