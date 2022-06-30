package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;
import util.Constants;

public class ChessMath {

	private Board board;
	
	public ChessMath() {
		this.board = new Board(Constants.ROWS_CHESS_BOARD, Constants.COLUMNS_CHESS_BOARD);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces() {
		ChessPiece[][] chessPieces = new ChessPiece[board.getRows()][board.getColumns()];
		for(int row = 0; row < board.getRows(); row++) {
			for(int column = 0; column < board.getColumns(); column++) {
				chessPieces[row][column] = (ChessPiece) board.getPiece(row, column);
			}
		}
		return chessPieces; 
	}
	
	private void initialSetup() {
		placeNewPiece(new Rook(board, Color.WHITE), new ChessPosition('a', 1));
		placeNewPiece(new Rook(board, Color.WHITE), new ChessPosition('b', 2));
		placeNewPiece(new King(board, Color.BLACK), new ChessPosition('e', 1));
		placeNewPiece(new King(board, Color.WHITE), new ChessPosition('e', 8));
		
	}
	
	private void placeNewPiece(ChessPiece piece, ChessPosition position) {
		board.placePiece(piece, position.toPosition());
	}
	
}
