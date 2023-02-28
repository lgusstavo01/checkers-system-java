package checkers.console;

import java.util.Scanner;

import checkers.exception.BoardException;
import checkers.game.CheckersPiece;
import checkers.game.CheckersPosition;
import checkers.game.Color;

public class UI {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	public static CheckersPosition readCheckersPosition(Scanner sc) {
		try {
			String x = sc.nextLine();
			char column = x.charAt(0);
			int row = Integer.parseInt(x.substring(1));
			return new CheckersPosition(column, row);
		} catch(RuntimeException e) {
			throw new BoardException("Error in reading the position. Valid values are a1 through h8.");
		}
	}
	
	public static void printBoard(CheckersPiece[][] pieces) {
		for(int i = 0; i < pieces.length; i++) {
			System.out.print(8 - i + " ");
				for(int j = 0; j < pieces.length; j++) {
					printPiece(pieces[i][j]);
				}
			System.out.println();
		}
		System.out.print("  A B C D E F G H");
	}
	
	public static void printPiece(CheckersPiece piece) {
		if(piece == null) 
			System.out.print("-");
		else {
			if(piece.getColor() == Color.WHITE)
				System.out.print(ANSI_WHITE + piece + ANSI_RESET);
			else
				System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
			
		}
		System.out.print(" ");
	}
}
