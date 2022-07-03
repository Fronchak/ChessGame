package chess;

import util.Constants;

public enum Color {

	WHITE(Constants.ANSI_WHITE),
	BLACK(Constants.ANSI_YELLOW);
	
	private String printColor;
	
	Color(String printColor) {
		this.printColor = printColor;
	}
	
	public String getPrintColor() {
		return this.printColor;
	}
}
