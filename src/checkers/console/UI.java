package checkers.console;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import checkers.exception.BoardException;
import checkers.game.CheckersMatch;
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
	
	public static void printMatch(CheckersMatch checkersMatch, List<CheckersPiece> list) {
		printBoard(checkersMatch.getPiece());
		System.out.println();
		printCapturedPieces(list);
		System.out.println("Turn: " + checkersMatch.getTurn());
		System.out.println("Waiting player: " + checkersMatch.getCurrentPlayer());
	}
	
	public static void printBoard(CheckersPiece[][] pieces) {
		for(int i = 0; i < pieces.length; i++) {
			System.out.print(8 - i + " ");
				for(int j = 0; j < pieces.length; j++) {
					printPiece(pieces[i][j], false);
				}
			System.out.println();
		}
		System.out.print("  A B C D E F G H");
	}
	
	public static void printBoard(CheckersPiece[][] pieces, boolean[][] possibleMoves) {
		for(int i = 0; i < pieces.length; i++) {
			System.out.print(8 - i + " ");
				for(int j = 0; j < pieces.length; j++) {
					printPiece(pieces[i][j], possibleMoves[i][j]);
				}
			System.out.println();
		}
		System.out.print("  A B C D E F G H");
	}
	
	public static void clearScreen() {
		System.out.println("\033[H\033[2J");
		System.out.flush();
	}
	
	public static void printPiece(CheckersPiece piece, boolean background) {
		if(background)
			System.out.print(ANSI_BLUE_BACKGROUND);
		if(piece == null) 
			System.out.print("-" + ANSI_RESET);
		else {
			if(piece.getColor() == Color.WHITE)
				System.out.print(ANSI_WHITE + piece + ANSI_RESET);
			else
				System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
			
		}
		System.out.print(" ");
	}
	
	public static void printCapturedPieces(List<CheckersPiece> list) {
		List<CheckersPiece> white = list.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
		List<CheckersPiece> black = list.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
		
		System.out.println("Captured pieces: ");
		System.out.println();
		System.out.print("White: ");
		System.out.print(ANSI_WHITE);
		System.out.print(Arrays.toString(white.toArray()));
		System.out.println(ANSI_RESET);
		System.out.println();
		System.out.println();
		System.out.print(ANSI_YELLOW);
		System.out.print("Black: ");
		System.out.print(Arrays.toString(black.toArray()));
		System.out.println(ANSI_RESET);
		System.out.println();
	}
}
