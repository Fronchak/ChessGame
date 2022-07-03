package test;

import static application.UI.printBoard;
import static application.UI.pularLinha;

import java.util.Scanner;

import application.UI;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class TestMovePiece {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ChessMatch chessMatch = new ChessMatch();
		while(true) {
			printBoard(chessMatch.getPieces());
			pularLinha();
			System.out.print("Source position: ");
			ChessPosition sourcePosition = UI.readChessPosition(sc.nextLine());
			pularLinha();
			System.out.print("Target position: ");
			ChessPosition targetPosition = UI.readChessPosition(sc.nextLine());
			pularLinha();
			ChessPiece removedPiece = chessMatch.performChessMove(sourcePosition, targetPosition);
		}
		

		
		//sc.close();
	}
	
}
