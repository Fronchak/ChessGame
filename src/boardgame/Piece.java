package boardgame;

public abstract class Piece {

	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
	}
	
	protected Board getBoard() {
		return board;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public abstract boolean[][] possibleMoves();
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] moves = possibleMoves();
		for(boolean[] linhaMoves : moves) {
			for(boolean posicao : linhaMoves) {
				if(posicao) { 
					return true; 
				}
			}
		}
		return false;
	}
	
	public boolean isPositionValidToMove(Position position) {
		boolean[][] moves = possibleMoves();
		return moves[position.getRow()][position.getColumn()];
	}
	
	
}
