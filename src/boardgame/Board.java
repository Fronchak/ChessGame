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
		checkBoardSize(rows, columns);
		this.rows = rows;
		this.columns = columns;
		this.pieces = new Piece[rows][columns];
	}
	
	private void checkBoardSize(int rows, int columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error creating board, invalid size!");
		}
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece getPieceAt(int row, int column) {
		checkDimensions(row, column);
		return this.pieces[row][column];
	}
	
	public Piece getPieceAt(Position position) {
		if(position == null) {
			throw new BoardException("Position cannot be null!");
		}
		return getPieceAt(position.getRow(), position.getColumn());
	}
	
	private void checkDimensions(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Invalid Board's Position!");
		}
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public Piece removePiece(Position position) {
		Piece removedPiece = this.getPieceAt(position);
		if(removedPiece == null) {
			return null;
		}
		removedPiece.setPosition(null);
		pieces[position.getRow()][position.getColumn()] = null;
		return removedPiece;
	}

	private void checkIfPositionIsEmpty(int row, int column) {
		checkDimensions(row, column);
		if(thereIsAPiece(row, column)) {
			throw new BoardException("There is already a piece on position " + row  + ", " + column);
		}
	}
	
	public boolean thereIsAPiece(Position position) {
		return this.thereIsAPiece(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(int row, int column) {
		return getPieceAt(row, column) != null;
	}
	
	public void placePiece(Piece piece, Position position) {
		checkIfPositionIsEmpty(position.getRow(), position.getColumn()); 
		this.pieces[position.getRow()][position.getColumn()] = piece;
		piece.setPosition(position);
	}
	
}
