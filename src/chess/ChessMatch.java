package chess;

import boardgame.Board;
import boardgame.Position;
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
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		ChessPiece capturedPiece = makeMove(source, target);
		return capturedPiece;
	}
	
	protected void validateSourcePosition(Position position) {
		ChessPiece piece = (ChessPiece) board.getPieceAt(position);
		if(piece == null) {
			throw new ChessException("There is no piece at target position!");
		}
		if(!piece.isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for chosen piece, try another piece");
		}
	}
	
	protected void validateTargetPosition(Position sourcePosition, Position targetPosition) {
		ChessPiece piece = (ChessPiece) board.getPieceAt(sourcePosition);
		if(!piece.isPositionValidToMove(targetPosition)) {
			throw new ChessException("Invalid target position, try another one");
		}
	}
	
	protected ChessPiece makeMove(Position sourcePosition, Position targetPosition) {
		ChessPiece targetPiece = (ChessPiece) board.removePiece(sourcePosition);
		ChessPiece removedPiece = (ChessPiece) board.removePiece(targetPosition);
		board.placePiece(targetPiece, targetPosition);
		return removedPiece;
	}
}
