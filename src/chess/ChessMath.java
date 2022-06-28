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
		board.placePiece(new Rook(board, Color.WHITE), new Position(1, 1));
		board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
		board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
		
	}
	
}
