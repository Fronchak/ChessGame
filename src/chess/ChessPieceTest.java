package chess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.Constants.ANSI_WHITE;
import static util.Constants.ANSI_YELLOW;

import org.junit.jupiter.api.Test;

import boardgame.Board;

public class ChessPieceTest {

	@Test
	public void printColorShoudBeWhiteForWhitePieces() {
		Board board = new Board(8, 8);
		ChessPiece chessPiece = new ChessPiece(board, Color.WHITE);
		assertEquals(ANSI_WHITE, chessPiece.getPrintColor());
	}
	
	@Test
	public void printColorShoudBeYelloeForBlackPieces() {
		Board board = new Board(8, 8);
		ChessPiece chessPiece = new ChessPiece(board, Color.BLACK);
		assertEquals(ANSI_YELLOW, chessPiece.getPrintColor());
	}
	
}
