package checkers.game;

import checkers.boardgame.Position;
import checkers.exception.CheckersException;

public class CheckersPosition {
	private char column;
	private Integer row;
	
	public CheckersPosition(char column, Integer row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8)
			throw new CheckersException("Invalid value ! Only values from a1 to h8 are accepted.");
		
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column; 
	}

	public Integer getRow() {
		return row;
	}
	
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	protected static CheckersPosition fromPosition(Position position) {
		return new CheckersPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	
}
