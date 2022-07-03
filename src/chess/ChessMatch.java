package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;
import exceptions.ChessException;
import util.Constants;

public class ChessMatch {

	protected Board board;
	
	public ChessMatch() {
		this.board = new Board(Constants.ROWS_CHESS_BOARD, Constants.COLUMNS_CHESS_BOARD);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces() {
		ChessPiece[][] chessPieces = new ChessPiece[board.getRows()][board.getColumns()];
		for(int row = 0; row < board.getRows(); row++) {
			for(int column = 0; column < board.getColumns(); column++) {
				chessPieces[row][column] = (ChessPiece) board.getPieceAt(row, column);
			}
		}
		return chessPieces; 
	}
	
	private void initialSetup() {
		placeNewPiece(new Rook(board, Color.WHITE), new ChessPosition('a', 1));
		placeNewPiece(new Rook(board, Color.WHITE), new ChessPosition('h', 1));
		placeNewPiece(new King(board, Color.WHITE), new ChessPosition('e', 1));
		
		placeNewPiece(new Rook(board, Color.BLACK), new ChessPosition('a', 8));
		placeNewPiece(new Rook(board, Color.BLACK), new ChessPosition('h', 8));
		placeNewPiece(new King(board, Color.BLACK), new ChessPosition('e', 8));

		
	}
	
	private void placeNewPiece(ChessPiece piece, ChessPosition position) {
		board.placePiece(piece, position.toPosition());
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		ChessPiece movedPiece = getMovedPiece(sourcePosition);
		ChessPiece removedPiece = (ChessPiece) board.getPieceAt(targetPosition.toPosition());
		board.placePiece(movedPiece, targetPosition.toPosition());
		return removedPiece;
	}
	
	protected ChessPiece getMovedPiece(ChessPosition sourcePosition) {
		ChessPiece movedPiece = (ChessPiece) board.removePiece(sourcePosition.toPosition());
		if(movedPiece == null) {
			throw new ChessException("There is no piece to be move at position: " + sourcePosition.toString());
		}
		if(!movedPiece.isThereAnyPossibleMove()) {
			throw new ChessException("Target piece cannot be moved, there is no possible moves for chosen piece!");
		}	
		return movedPiece;
	}
}
