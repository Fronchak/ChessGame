package chess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import boardgame.Position;
import exceptions.ChessException;

public class ChessPositionTest {

	@Test
	public void testConversaoDeChessPositionToPosition() {
		
		Assertions.assertEquals(new Position(7, 0), new ChessPosition('a', 1).toPosition());
		Assertions.assertEquals(new Position(6, 1), new ChessPosition('b', 2).toPosition());
		Assertions.assertEquals(new Position(0, 7), new ChessPosition('h', 8).toPosition());
		Assertions.assertEquals(new Position(0, 0), new ChessPosition('a', 8).toPosition());
		
	}
	
	@Test
	public void testInstanciarChessPositionComLinhaInvalida() {
		Assertions.assertThrows(ChessException.class, () -> new ChessPosition('c', 10));
	}
	
	@Test
	public void testInstanciarChessPositionComColunaInvalida() {
		Assertions.assertThrows(ChessException.class, () -> new ChessPosition('j', 1));
	}
	
	@Test
	public void testConversaoDePositionToChessPosition() {
		Assertions.assertEquals(new ChessPosition('a', 1), ChessPosition.fromPosition(new Position(7, 0)));
		Assertions.assertEquals(new ChessPosition('a', 2), ChessPosition.fromPosition(new Position(6, 0)));
		Assertions.assertEquals(new ChessPosition('a', 8), ChessPosition.fromPosition(new Position(0, 0)));
		Assertions.assertEquals(new ChessPosition('h', 1), ChessPosition.fromPosition(new Position(7, 7)));
	}
	
}
