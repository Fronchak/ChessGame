package chess;

import boardgame.Board;
import boardgame.Piece;
import util.Constants;

public abstract class ChessPiece extends Piece{

	protected Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public String getPrintColor() {
		return getColor().getPrintColor();
	}
	
	@Override
	public String toString() {
		return "-";
	}
	
	public String toStringWithColor() {
		return color.getPrintColor() + toString() + Constants.ANSI_RESET;
 	}
	
	
}
