package checkers.console;

import checkers.game.CheckersPiece;

public class UI {
	
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
		else
			System.out.print(piece);
		
		System.out.print(" ");
	}
}
