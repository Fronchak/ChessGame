package chess;

import java.util.Objects;

import boardgame.Position;
import exceptions.ChessException;
import util.Constants;

public class ChessPosition {

	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		verifyInputParameters(column, row);
		this.column = column;
		this.row = row;
	}
	
	private void verifyInputParameters(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instatiating ChessPosition. Valid values are from a1 to h8");
		}
	}	
	
	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	protected Position toPosition() {
		return new Position(getRowPositionFromChessPosition(), getColumnPositionFromChessColumnPosition());
	}
	
	private int getColumnPositionFromChessColumnPosition() {
		int initialColumnValue = (int) 'a';
		return ((int) column) - initialColumnValue;
	}
	
	private int getRowPositionFromChessPosition() {
		return Constants.ROWS_CHESS_BOARD - row;
	}
	
	protected static ChessPosition fromPosition(Position position) {
		char column = ((char) ('a' + position.getColumn()));
		return new ChessPosition(column, Constants.ROWS_CHESS_BOARD - position.getRow());
	}

	@Override
	public int hashCode() {
		return Objects.hash(column, row);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChessPosition other = (ChessPosition) obj;
		return column == other.column && row == other.row;
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
	
	
}
