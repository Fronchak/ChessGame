package application;

import static application.UI.getStringToPrintPieceAtTable;
import static application.UI.getStringWithoutSpaces;
import static application.UI.readChessPosition;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static util.Constants.EMPTY_PIECE;

import org.junit.jupiter.api.Test;

import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;
import chess.pieces.King;
import exceptions.ChessException;
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
	
	@Test
	public void shoudReturnChessPositionForACorrectInputArgument() {
		String input = "a1";
		ChessPosition expected = new ChessPosition('a', 1);
		assertEquals(expected, readChessPosition(input));
	}
	
	@Test
	public void shoudThrowIllegalArgumentExceptionForInvalidInput() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> readChessPosition("a"));
		assertEquals("Invalid position, try type the column and row the wanted position!", exception.getMessage());
	}
	
	@Test
	public void shoudThrowChessExceptionForInvalidRow() {
		Throwable exception = assertThrows(ChessException.class, () -> readChessPosition("a9"));
		assertEquals("Error instatiating ChessPosition. Valid values are from a1 to h8", exception.getMessage());
	}
	
	@Test
	public void shoudThrowChessExceptionForInvalidColumn() {
		Throwable exception = assertThrows(ChessException.class, () -> readChessPosition("k5"));
		assertEquals("Error instatiating ChessPosition. Valid values are from a1 to h8", exception.getMessage());
	}
	
	@Test
	public void shoudThrowIllegalArgumentExceptionForEmptyInput() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> readChessPosition(""));
		assertEquals("Invalid position, try type the column and row the wanted position!", exception.getMessage());
	}
	
	@Test
	public void shoudThrowIllegalArgumentExceptionForNullInput() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> readChessPosition(null));
		assertEquals("Invalid position, try type the column and row the wanted position!", exception.getMessage());
	}
	
	@Test
	public void shoudGetRightChessPositionForStringWithEmptySpacesBetweenColumnAndRow() {
		ChessPosition expected = new ChessPosition('b', 2);
		assertEquals(expected, readChessPosition(" b  2 "));
	}
	

	@Test
	public void getStringWithoutSpacesShoudRemoveAllSpacesFromInputArgument() {
		assertEquals("a5", getStringWithoutSpaces("  a   5 "));
		assertEquals("", getStringWithoutSpaces("   "));
		assertEquals("b7", getStringWithoutSpaces("b    7"));
		assertEquals("a", getStringWithoutSpaces("  a    "));
	}
	
	@Test
	public void shoudThrowIllegalArgumentExceptionIfArgumentIsNull() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> getStringWithoutSpaces(null));
		assertEquals("Invalid position, try type the column and row the wanted position!", exception.getMessage());
	}
	
}
