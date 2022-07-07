package chess.pieces;

import java.util.function.Consumer;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public abstract class ChessPieceMoveOnePosition extends ChessPiece{

	public ChessPieceMoveOnePosition(Board board, Color color) {
		super(board, color);
	}
	
	protected boolean[][] getMoves(boolean[][] moves, Consumer<Position> consumer) {
		Position auxPosition = new Position(position.getRow(), position.getColumn());
		consumer.accept(auxPosition);
		if(canMove(auxPosition)) {
			moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}
		return moves;
	}
	
}
