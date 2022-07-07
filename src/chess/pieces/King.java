package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPieceMoveOnePosition {

	public King(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K"; 
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] moves = new boolean[getBoard().getRows()][getBoard().getColumns()];
		moves = getMoves(moves, position -> position.offset(1, 0));
		moves = getMoves(moves, position -> position.offset(-1, 0));
		moves = getMoves(moves, position -> position.offset(0, 1));
		moves = getMoves(moves, position -> position.offset(0, -1));
		moves = getMoves(moves, position -> position.offset(1, 1));
		moves = getMoves(moves, position -> position.offset(-1, -1));
		moves = getMoves(moves, position -> position.offset(1, -1));
		moves = getMoves(moves, position -> position.offset(-1, 1));
		return moves;
	}
}
