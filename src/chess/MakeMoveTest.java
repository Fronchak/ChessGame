package chess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import boardgame.Position;

public class MakeMoveTest {

	private ChessMatch chessMatch;
	private Position sourcePosition;
	private Position targetPosition;
	
	@BeforeEach
	public void setup() {
		chessMatch = new ChessMatch();
		sourcePosition = new ChessPosition('a', 1).toPosition();
		targetPosition = new ChessPosition('a', 4).toPosition();
	}
	
	@Test
	public void sourcePositionShoudBeEmptyAfterMakeMove() {
		chessMatch.makeMove(sourcePosition, targetPosition);
		Assertions.assertNull(chessMatch.board.getPieceAt(sourcePosition));
	}
	
	@Test
	public void MovedPieceShoudBeAtTargetPositionAfterMakeMove() {
		ChessPiece movedPiece = (ChessPiece) chessMatch.board.getPieceAt(sourcePosition);
		chessMatch.makeMove(sourcePosition, targetPosition);
		ChessPiece pieceAtTargetPosition = (ChessPiece) chessMatch.board.getPieceAt(targetPosition);
		Assertions.assertEquals(movedPiece, pieceAtTargetPosition);
	}
	
	@Test
	public void shoudReturnPieceAtTargetPosition() {
		targetPosition = new ChessPosition('a', 8).toPosition();
		ChessPiece removedPiece = (ChessPiece) chessMatch.board.getPieceAt(targetPosition);
		ChessPiece result = chessMatch.makeMove(sourcePosition, targetPosition);
		Assertions.assertEquals(removedPiece, result);
	}
	
	@Test
	public void positionFromMovedPieceShoudBeTargetPosition() {
		ChessPiece movedPiece = (ChessPiece) chessMatch.board.getPieceAt(sourcePosition);
		chessMatch.makeMove(sourcePosition, targetPosition);
		Assertions.assertEquals(targetPosition, movedPiece.getPosition());
	}
	
}
