package boardgame;

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
	
}
