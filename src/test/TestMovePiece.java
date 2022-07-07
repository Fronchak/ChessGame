package test;

import static application.UI.clearScreen;
import static application.UI.printBoard;
import static application.UI.printMatch;
import static application.UI.pularLinha;

import java.util.Scanner;

import application.UI;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import exceptions.ChessException;

public class TestMovePiece {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ChessMatch chessMatch = new ChessMatch();
		while(true) {
			try {
				executeRounds(sc, chessMatch);
			}
			catch(ChessException e) { 
				pularLinha();
				System.out.println("Error: " + e.getMessage());
				System.out.println("Pressione alguma tecla para continuar!");
				sc.nextLine();
			}
			catch(IllegalArgumentException e) {
				pularLinha();
				System.out.println("Error: " + e.getMessage());
				System.out.println("Pressione alguma tecla para continuar!");
				sc.nextLine();
			}
			catch(Exception e) {
				System.out.println("Unexpected error: " + e.getMessage());
				System.out.println("Pressione alguma tecla para continuar!");
				sc.nextLine();
			}

		}
		

		
		//sc.close();
	}
	
	public static void executeRounds(Scanner sc, ChessMatch chessMatch) {
		clearScreen();
		printMatch(chessMatch);
		pularLinha();
		System.out.print("Source position: ");
		ChessPosition sourcePosition = UI.readChessPosition(sc.nextLine());
		boolean[][] possibleMoves = chessMatch.getPossibleMovesFromTargetPositon(sourcePosition);
		clearScreen();
		printBoard(chessMatch.getPieces(), possibleMoves);
		pularLinha();
		System.out.print("Target position: ");
		ChessPosition targetPosition = UI.readChessPosition(sc.nextLine());
		pularLinha();
		ChessPiece removedPiece = chessMatch.performChessMove(sourcePosition, targetPosition);
	}
	
}
