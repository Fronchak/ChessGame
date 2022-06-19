package test;

import application.UI;
import chess.ChessMath;

public class TesteTabuleiro {

	public static void main(String[] args) {
		
		ChessMath chessMath = new ChessMath();
		UI.printBoard(chessMath.getPieces());

	}

}
