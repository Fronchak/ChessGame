package chess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import boardgame.Position;
import exceptions.ChessException;

public class ChessMatchTest {

	private ChessMatch chessMatch;
	
	@BeforeEach
	public void setup() {
		chessMatch = new ChessMatch();
	}
	
	@Test
	public void shoudThrowChessExceptionIfSourcePositionIsEmpty() {
		ChessPosition sourcePosition = new ChessPosition('c', 4);
		Throwable exception = Assertions.assertThrows(ChessException.class , 
				() -> chessMatch.performChessMove(sourcePosition, new ChessPosition('a', 7)));
		assertEquals("There is no piece at target position!", exception.getMessage());
	}
	
	@Test 
	public void sourcePositionShoudBeEmptyAfterPerformMove() {
		ChessPosition sourcePosition = new ChessPosition('a', 1);
		ChessPosition targetPosition = new ChessPosition('a', 2);
		chessMatch.performChessMove(sourcePosition, targetPosition);
		Assertions.assertNull(chessMatch.board.getPieceAt(sourcePosition.toPosition()));
	}
	
	@Test
	public void pieceAtSourcePositionShoudBeAtTargetPositionAfterPerformMove() {
		ChessPosition sourcePosition = new ChessPosition('a', 1);
		ChessPosition targetPosition = new ChessPosition('a', 2);
		ChessPiece sourcePiece = (ChessPiece) chessMatch.board.getPieceAt(sourcePosition.toPosition());
		chessMatch.performChessMove(sourcePosition, targetPosition);
		ChessPiece targetPieceAfterMove = (ChessPiece) chessMatch.board.getPieceAt(targetPosition.toPosition());
		assertEquals(sourcePiece, targetPieceAfterMove);
	}
	
	@Test
	public void shoudReturnNullIfTargetPositionIsEmpty() {
		ChessPosition sourcePosition = new ChessPosition('a', 1);
		ChessPosition targetPosition = new ChessPosition('a', 4);
		Assertions.assertNull(chessMatch.performChessMove(sourcePosition, targetPosition));
	}
	
	@Test
	public void shoudReturnPieceAtTargetPosition() {
		ChessPosition sourcePosition = new ChessPosition('a', 1);
		ChessPosition targetPosition = new ChessPosition('a', 8);
		ChessPiece removedPiece = (ChessPiece) chessMatch.board.getPieceAt(targetPosition.toPosition());
		assertEquals(removedPiece, chessMatch.performChessMove(sourcePosition, targetPosition));
	}
	
	@Test
	public void shoudThrowChessExceptionIfThereIsNoPieceAtTargetPosition() {
		Throwable exception = Assertions.assertThrows(ChessException.class, () -> chessMatch.validateSourcePosition(new Position(4, 4)));
	}
	
	@Test
	public void initialRoudShoudBe1() {
		assertEquals(1, chessMatch.getTurn());
	}
	
	@Test
	public void initialPlayerShoudBeWhite() {
		assertEquals(Color.WHITE, chessMatch.getCurrentPlayer());
	}
	
	@Test
	public void shoudIncrementRoundAfterExecuteAPlay() {
		chessMatch.turnRound();
		assertEquals(2, chessMatch.getTurn());
	}
	
	@Test
	public void shourSwapColorAfterExecuteAPlay() {
		chessMatch.turnRound();
		assertEquals(Color.BLACK, chessMatch.getCurrentPlayer());
	}
	
	
	@Test
	public void shoudIncrementRoundAfterExecuteAPlay2() {
		chessMatch.turnRound();
		chessMatch.turnRound();
		assertEquals(3, chessMatch.getTurn());
	}
	
	@Test
	public void shourSwapColorAfterExecuteAPlay2() {
		chessMatch.turnRound();
		chessMatch.turnRound();
		assertEquals(Color.WHITE, chessMatch.getCurrentPlayer());
	}
	
	@Test
	public void shoudThrowChessExceptionIfPlayerTryToMoveOpponentPieces() {
		Throwable exception = assertThrows(ChessException.class, () -> chessMatch.validateSourcePosition(new ChessPosition('a', 8).toPosition()));
		assertEquals("That's not your piece, you can just moves the pieces " + chessMatch.getCurrentPlayer().toString(), exception.getMessage());
	}
}
