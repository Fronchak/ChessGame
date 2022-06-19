package boardgame;

import exceptions.BoardException;
import util.Constants;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board() {
		this(Constants.ROWS_CHESS_BOARD, Constants.COLUMNS_CHESS_BOARD);
	}
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece getPiece(int row, int column) {
		checkPosition(row, column);
		return this.pieces[row][column];
	}
	
	public Piece getPiece(Position position) {
		checkPosition(position.getRow(), position.getColumn());
		return this.pieces[position.getRow()][position.getColumn()];
	}
	
	private void checkPosition(int row, int column) {
		if(row >= this.rows || column >= this.columns || row < 0 || column < 0) {
			throw new BoardException("Invalid Board's Position!");
		}
	}
	
}
