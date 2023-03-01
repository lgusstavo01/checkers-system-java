package checkers.console;

import java.util.InputMismatchException;
import java.util.Scanner;

import checkers.exception.CheckersException;
import checkers.game.CheckersMatch;
import checkers.game.CheckersPiece;
import checkers.game.CheckersPosition;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CheckersMatch checkersMatch = new CheckersMatch();

		while (true) {
			try {
				UI.clearScreen();
				UI.printBoard(checkersMatch.getPiece());
				System.out.println();
				System.out.println();
				System.out.print("Source: ");
				CheckersPosition source = UI.readCheckersPosition(sc);
				boolean[][] possibleMoves = checkersMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(checkersMatch.getPiece(), possibleMoves);

				System.out.println();
				System.out.println();
				System.out.print("Target: ");
				CheckersPosition target = UI.readCheckersPosition(sc);
				
				CheckersPiece capturesPiece = checkersMatch.performCheckersMove(source, target);
			} catch (CheckersException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}
}
