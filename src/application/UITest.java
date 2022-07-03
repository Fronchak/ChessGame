package application;

import static application.UI.getStringToPrintPieceAtTable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.Constants.EMPTY_PIECE;

import org.junit.jupiter.api.Test;

import chess.ChessPiece;
import chess.Color;
import chess.pieces.King;
import util.Constants;

public class UITest {

	@Test
	public void testStringForPrintPieceWithColor() {
		ChessPiece chessPiece = new King(null, Color.WHITE);
		String expected = Constants.ANSI_WHITE + "K" + Constants.ANSI_RESET;
		assertEquals(expected, getStringToPrintPieceAtTable(chessPiece));
	}
	
	@Test
	public void testPrintBlackPiece() {
		ChessPiece chessPiece = new King(null, Color.BLACK);
		String expected = Constants.ANSI_YELLOW + "K" + Constants.ANSI_RESET;
		assertEquals(expected, getStringToPrintPieceAtTable(chessPiece));
	}
	
	@Test
	public void shoudReturnEmptyPieceIfPieceIsNull() {
		assertEquals(EMPTY_PIECE, getStringToPrintPieceAtTable(null));
	}
	
}
