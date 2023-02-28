package checkers.console;

import checkers.game.CheckersMatch;

public class Program {

	public static void main(String[] args) {
		CheckersMatch checkersMatch = new CheckersMatch();
		UI.printBoard(checkersMatch.getPiece());
	}
}
