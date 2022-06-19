package application;

import chess.ChessPiece;

public class UI {

	public static void printBoard(ChessPiece[][] pieces) {
		for(int row = pieces.length - 1; row >= 0; row--) {
			printRow(pieces, row);
		}
		printLastRow(pieces);
	}
	
	private static void printRow(ChessPiece[][] pieces, int row) {
		System.out.print(row + 1);
		for(ChessPiece piece : pieces[row]) {
			System.out.print(" " + getStringPiece(piece));
		}
		System.out.println();	
	}

	private static String getStringPiece(ChessPiece chessPiece) {
		return chessPiece == null ? "-" : chessPiece.toString();
	}
	
	private static void printLastRow(ChessPiece[][] pieces) {
		System.out.print(" ");
		for(int column = 0; column < pieces.length; column++) {
			System.out.print(" " + getChar(column));
		}
	}
	
	private static char getChar(int offset) {
		return ((char) ('a' + offset));
	}
	
	
}
