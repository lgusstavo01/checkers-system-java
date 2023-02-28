package checkers.console;

import java.util.Scanner;

import checkers.game.CheckersMatch;
import checkers.game.CheckersPiece;
import checkers.game.CheckersPosition;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CheckersMatch checkersMatch = new CheckersMatch();

		while(true) {
			UI.printBoard(checkersMatch.getPiece());
			System.out.println();
			System.out.print("Source: ");
			CheckersPosition source = UI.readCheckersPosition(sc);
			
			System.out.println();
			System.out.print("Target: ");
			CheckersPosition target = UI.readCheckersPosition(sc);
			
			CheckersPiece capturesPiece = checkersMatch.performCheckersMove(source, target);
		}
	}
}
