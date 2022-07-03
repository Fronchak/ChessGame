package chess.pieces;

import java.util.function.Consumer;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public abstract class ChessPieceMoveVariousPositions extends ChessPiece{

	public ChessPieceMoveVariousPositions(Board board, Color color) {
		super(board, color);
	}
	
	protected boolean[][] getMoves(boolean[][] moves, Consumer<Position> consumer) {
		Position auxPosition = new Position(position.getRow(), position.getColumn());
		consumer.accept(auxPosition);
		while(getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
			moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
			consumer.accept(auxPosition);
		}
		if(getBoard().positionExists(auxPosition) && isThereAnEnenyPiece(auxPosition.getRow(), auxPosition.getColumn())) {
			moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}
		return moves;
	}
}
