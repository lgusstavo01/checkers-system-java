package application;

import checkers.console.UI;
import checkersgame.CheckersMatch;

public class Program {

	public static void main(String[] args) {
		CheckersMatch checkersMatch = new CheckersMatch();
		UI.printBoard(checkersMatch.getPiece());
	}
}
