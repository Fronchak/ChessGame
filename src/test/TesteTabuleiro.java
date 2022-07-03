package test;

import application.UI;
import chess.ChessMatch;

public class TesteTabuleiro {

	public static void main(String[] args) {
		
		ChessMatch chessMath = new ChessMatch();
		UI.printBoard(chessMath.getPieces());

	}

}
