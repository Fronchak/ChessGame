package application;

import static util.Constants.ANSI_BLACK_BACKGROUND;
import static util.Constants.ANSI_BLUE_BACKGROUND;
import static util.Constants.EMPTY_STRING;
import static util.Constants.SPACE_STRING;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import util.Constants;

public class UI {

	public static void printMatch(ChessMatch chessMatch) {
		printBoard(chessMatch.getPieces());
		pularLinha();
		pularLinha();
		System.out.println("Turn: " + chessMatch.getTurn());
		System.out.println("Current Player: " + chessMatch.getCurrentPlayer().toString());
	}
	
	public static void printBoard(ChessPiece[][] pieces) {
		printBoard(pieces, new boolean[pieces.length][pieces[0].length]);
	}
	
	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		for(int row = 0; row < pieces[1].length; row++) {
			printRow(pieces, row, possibleMoves);
		}
		printLastRow(pieces);
	}
	
	private static void printRow(ChessPiece[][] pieces, int row, boolean[][] possibleMoves) {
		System.out.print(8 - row);
		
		for(int j = 0; j < pieces.length; j++) {
			System.out.print(" " + getBackGroundColorString(possibleMoves[row][j]) + getStringToPrintPieceAtTable(pieces[row][j]));
		}

		System.out.println();	
	}

	protected static String getStringToPrintPieceAtTable(ChessPiece chessPiece) {
		return chessPiece == null ? Constants.EMPTY_PIECE : chessPiece.toStringWithColor();
	}

	protected static String getBackGroundColorString(boolean validPosition) {
		return validPosition ? ANSI_BLUE_BACKGROUND : ANSI_BLACK_BACKGROUND;
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
	
	public static ChessPosition readChessPosition(String inputString) {
		inputString = getStringWithoutSpaces(inputString);
		if(inputString.length() < 2) {
			throw new IllegalArgumentException("Invalid position, try type the column and row the wanted position!");
		}
		char column = inputString.charAt(0);
		int row = Integer.parseInt(inputString.substring(1));
		return new ChessPosition(column, row);
	}
	
	protected static String getStringWithoutSpaces(String inputString) {
		if(inputString == null) {
			throw new IllegalArgumentException("Invalid position, try type the column and row the wanted position!");
		}
		return inputString.replaceAll(SPACE_STRING, EMPTY_STRING);
	}
	
	public static void pularLinha() {
		System.out.println();
	}
	
	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
