package boardgame;

public class Board {
	private Integer rows;
	private Integer columns;
	private Piece[][] pieces;
	
	public Board(Integer rows, Integer columns) {
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
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	
	/*===== Metodo para colocar uma peca no tabuleiro =====*/
	public void placePiece(Piece piece, Position position) {
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
}