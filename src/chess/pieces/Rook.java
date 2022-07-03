package chess.pieces;

import boardgame.Board;
import chess.Color;

public class Rook extends ChessPieceMoveVariousPositions {

	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] moves = new boolean[getBoard().getRows()][getBoard().getColumns()];
		moves = getMoves(moves, position -> position.setRow(position.getRow() - 1));
		moves = getMoves(moves, position -> position.setRow(position.getRow() + 1));
		moves = getMoves(moves, position -> position.setColumn(position.getColumn() - 1));
		moves = getMoves(moves, position -> position.setColumn(position.getColumn() + 1));
		return moves;
	}


}
