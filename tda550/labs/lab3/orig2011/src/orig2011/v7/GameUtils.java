package orig2011.v7;

public enum GameUtils {
	;
	
	
	/**
	 * Fill a board with a type.
	 * 
	 * @param board The game board
	 * @param state The state
	 */
	public static <T> void fillBoard(final T[][] board, final T state){
		
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				board[i][j] = state;
			}
		}
	}
	
	/**
	 * Set the state for a board in a given position.
	 * 
	 * @param board The game board
	 * @param pos The position
	 * @param state The state
	 */
	public static <T> void setGameboardState(final T[][] board, final Position pos, final T state){
		board[pos.getX()][pos.getY()] = state;
	}
	
	
	/**
	 * Set the state for a board in a given position.
	 * 
	 * @param board The game board
	 * @param x The x position
	 * @param y The y position
	 * @param state The state
	 */
	public static <T> void setGameboardState(final T[][] board, final int x, final int y, final T state){
		board[x][y] = state;
	}

}
