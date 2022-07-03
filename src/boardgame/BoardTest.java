package boardgame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import chess.Color;
import chess.pieces.Rook;
import exceptions.BoardException;

public class BoardTest {
	
	
	@Test
	public void initializeBoardWithInvalidRows() {
		assertThrows(BoardException.class, () ->  new Board(-1, 4));
	}
	
	@Test
	public void testInitilizeBoardWithInvalidColumn() {
		assertThrows(BoardException.class, () -> new Board(1, 0));
	}
	
	@Test
	public void shoudThrowBoardExceptionByRemovingPieceForInvalidPosition() {
		Board board = new Board(8, 8);
		Throwable exception = assertThrows(BoardException.class, () -> board.removePiece(new Position(9, 9)));
		assertEquals("Invalid Board's Position!", exception.getMessage());
	}
	
	@Test
	public void shoudReturnNullIfPositionIsEmpty() {
		Board board = new Board(8, 8);
		assertNull(board.removePiece(new Position(1,1)));
	}
	
	@Test
	public void positionFromPieceRemovesShoudBeNull() {
		Board board = new Board(8, 8);
		Position position = new Position(1, 1);
		board.placePiece(new Rook(board, Color.WHITE), position);
		Piece piece = board.removePiece(position);
		assertNull(piece.getPosition());
	}
	
	@Test
	public void positionOnBoardShoudBeEmptyAfterRemovePiece() {
		Board board = new Board(8, 8);
		Position position = new Position(1, 1);
		board.placePiece(new Rook(board, Color.WHITE), position);
		board.removePiece(position);
		assertNull(board.getPieceAt(position));
	}

	@Test
	public void shoudThrowBoardExceptionForNullPosition() {
		Board board = new Board(8, 8);
		Throwable exception = assertThrows(BoardException.class, () -> board.removePiece(null));
		assertEquals("Position cannot be null!", exception.getMessage());
	}
}
