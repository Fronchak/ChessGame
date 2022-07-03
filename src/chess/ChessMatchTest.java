package chess;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		assertEquals("There is no piece to be move at position: " + sourcePosition.toString(), exception.getMessage());
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
		ChessPosition targetPosition = new ChessPosition('c', 4);
		Assertions.assertNull(chessMatch.performChessMove(sourcePosition, targetPosition));
	}
	
	@Test
	public void shoudReturnPieceAtTargetPosition() {
		ChessPosition sourcePosition = new ChessPosition('a', 1);
		ChessPosition targetPosition = new ChessPosition('c', 4);
		ChessPiece removedPiece = (ChessPiece) chessMatch.board.getPieceAt(targetPosition.toPosition());
		assertEquals(removedPiece, chessMatch.performChessMove(sourcePosition, targetPosition));
	}
}
