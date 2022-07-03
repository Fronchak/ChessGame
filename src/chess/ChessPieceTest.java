package chess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.Constants.ANSI_WHITE;
import static util.Constants.ANSI_YELLOW;

import org.junit.jupiter.api.Test;

import boardgame.Board;
import chess.pieces.Rook;

public class ChessPieceTest {

	@Test
	public void printColorShoudBeWhiteForWhitePieces() {
		Board board = new Board(8, 8);
		ChessPiece chessPiece = new Rook(board, Color.WHITE);
		assertEquals(ANSI_WHITE, chessPiece.getPrintColor());
	}
	
	@Test
	public void printColorShoudBeYelloeForBlackPieces() {
		Board board = new Board(8, 8);
		ChessPiece chessPiece = new Rook(board, Color.BLACK);
		assertEquals(ANSI_YELLOW, chessPiece.getPrintColor());
	}
	
}
