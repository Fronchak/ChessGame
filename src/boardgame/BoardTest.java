package boardgame;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.rules.ExpectedException;

import exceptions.BoardException;

public class BoardTest {
	
	
	@Test(expected = BoardException.class)
	public void initializeBoardWithInvalidRows() {
		new Board(-1, 4);
	}
	
	@Test
	public void testInitilizeBoardWithInvalidColumn() {
		Assert.assertThrows(BoardException.class, () -> new Board(1, 0));
	}
	


}
