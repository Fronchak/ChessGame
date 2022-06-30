package chess;

import org.junit.Assert;
import org.junit.Test;

import boardgame.Position;
import exceptions.ChessException;

public class ChessPositionTest {

	@Test
	public void testConversaoDeChessPositionToPosition() {
		
		Assert.assertEquals(new Position(7, 0), new ChessPosition('a', 1).toPosition());
		Assert.assertEquals(new Position(6, 1), new ChessPosition('b', 2).toPosition());
		Assert.assertEquals(new Position(0, 7), new ChessPosition('h', 8).toPosition());
		Assert.assertEquals(new Position(0, 0), new ChessPosition('a', 8).toPosition());
	}
	
	@Test(expected = ChessException.class)
	public void testInstanciarChessPositionComLinhaInvalida() {
		new ChessPosition('c', 10);
	}
	
	@Test(expected = ChessException.class)
	public void testInstanciarChessPositionComColunaInvalida() {
		new ChessPosition('j', 1);
	}
	
	@Test
	public void testConversaoDePositionToChessPosition() {
		Assert.assertEquals(new ChessPosition('a', 1), ChessPosition.fromPosition(new Position(7, 0)));
		Assert.assertEquals(new ChessPosition('a', 2), ChessPosition.fromPosition(new Position(6, 0)));
		Assert.assertEquals(new ChessPosition('a', 8), ChessPosition.fromPosition(new Position(0, 0)));
		Assert.assertEquals(new ChessPosition('h', 1), ChessPosition.fromPosition(new Position(7, 7)));
	}
	
}
