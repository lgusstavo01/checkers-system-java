package checkers.boardgame;

import checkers.exception.BoardException;

public class Board {
	private Integer rows;
	private Integer columns;
	private Piece[][] pieces;
	
	public Board(Integer rows, Integer columns) {
		if(rows < 1 || columns < 1)
			throw new BoardException("Error creating board ! At least 1 row and 1 column is required !");
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public Integer getColumns() {
		return columns;
	}

	public void setColumns(Integer columns) {
		this.columns = columns;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	/* ===== Metodos para retornar a peca que esta em determinada posicao ===== */
	public Piece piece(int row, int column) {
		if(!positionExists(row, column))
			throw new BoardException("There is no such position on the board !");
		
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if(!positionExistis(position))
			throw new BoardException("There is no such position on the board !");
		
		return pieces[position.getRow()][position.getColumn()];
	}
	
	/*===== Metodo para colocar uma peca no tabuleiro =====*/
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position))
			throw new BoardException("There is already a part in that position !" + position);
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	/*===== Metodo para remover uma peca do tabuleiro =====*/
	public Piece removePiece(Position position) {
		if(!positionExistis(position))
			throw new BoardException("There is no such position on the board !");
		if(piece(position) == null)
			return null;
		
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	/*===== Metodos para verificar se a posicao existe no tabuleiro*/
	public boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExistis(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	/*===== Metodo para verificar se existe uma peca na posicao =====*/
	public boolean thereIsAPiece(Position position) {
		if(!positionExistis(position))
			throw new BoardException("There is no part at the given position !");
		else
			return piece(position) != null;
	}
	
}