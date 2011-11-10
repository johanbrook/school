package lab1;

import java.awt.*;
import java.util.LinkedList;
import java.awt.event.KeyEvent;

public class SnakeModel extends GameModel {
	
	
	public enum Directions {
		EAST(1, 0),
		WEST(-1, 0),
		NORTH(0, -1),
		SOUTH(0, 1),
		NONE(0, 0);

		private final int xDelta;
		private final int yDelta;

		Directions(final int xDelta, final int yDelta) {
			this.xDelta = xDelta;
			this.yDelta = yDelta;
		}

		public int getXDelta() {
			return this.xDelta;
		}

		public int getYDelta() {
			return this.yDelta;
		}
	}
	
	
	/** The position of the snake. */
	private Position snakePos;

	/** The direction of the snake. */
	private Directions direction = Directions.NORTH;
	
	/** Initial length of the snake */
	private static final int SNAKE_LENGTH = 3;

	/** The number of fruits found. */
	private int score;
	
	/** A list of snake tiles (the growing tail) */
	private LinkedList<Position> snakeTiles = new LinkedList<Position>();
	
	/** The fruit tile */
	private static final GameTile FRUIT_TILE = new RoundTile(Color.BLACK,
			Color.RED, 2.0);

	/** The snake tile */
	private static final GameTile SNAKE_TILE = new RectangularTile(Color.BLACK);

	/** Blank tile */
	private static final GameTile BLANK_TILE = new GameTile();
		
	/** Sound clip */
	private Sound successSound;
	
	
	/**
	 * Creates a new Snake game
	 */
	public SnakeModel(){
		this.successSound = new Sound("sounds/pop.wav");
		this.score = 0;
		
		Dimension size = getGameboardSize();
		
		for (int i = 0; i < size.width; i++) {
			for (int j = 0; j < size.height; j++) {
				setGameboardState(i, j, BLANK_TILE);
			}
		}
		
		// Center snake
		this.snakePos = new Position(size.width / 2, size.height / 2);
		this.snakeTiles.add(this.snakePos);
		
		
		/* Set an initial length of the snake */
		
		for(int i = 0; i < SNAKE_LENGTH; i++){
			int prevX = this.snakePos.getX() - this.direction.getXDelta();
			int prevY = this.snakePos.getY() - this.direction.getYDelta() - i;
			
			this.snakeTiles.add(new Position(prevX, prevY));
		}
		
		/* Add a single fruit to begin with */
		addFruit();
	}
	
	
	/**
	 * Adds a new fruit to the game board at a random position.
	 * 
	 */
	private void addFruit(){
		Position newFruitPos;
		Dimension size = getGameboardSize();
		
		do {
			newFruitPos = new Position((int) (Math.random() * size.width),
										(int) (Math.random() * size.height));
		} while (!isPositionEmpty(newFruitPos));


		setGameboardState(newFruitPos, FRUIT_TILE);
	}
	

	
	
	/**
	 * Update the direction of the collector
	 * according to the user's keypress.
	 */
	private void updateDirection(final int key) {
		switch (key) {
			case KeyEvent.VK_LEFT:
				this.direction = Directions.WEST;
				break;
			case KeyEvent.VK_UP:
				this.direction = Directions.NORTH;
				break;
			case KeyEvent.VK_RIGHT:
				this.direction = Directions.EAST;
				break;
			case KeyEvent.VK_DOWN:
				this.direction = Directions.SOUTH;
				break;
			default:
				// Don't change direction if another key is pressed
				break;
		}
	}

	/**
	 * Get next position of the collector.
	 */
	private Position getNextSnakePos() {
		return new Position(
				this.snakePos.getX() + this.direction.getXDelta(),
				this.snakePos.getY() + this.direction.getYDelta());
	}
	
	/**
	 * Return whether the specified position is empty.
	 * 
	 * @param pos
	 *            The position to test.
	 * @return true if position is empty.
	 */
	private boolean isPositionEmpty(final Position pos) {
		return (getGameboardState(pos) == BLANK_TILE);
	}
	
	
	
	/**
	 * Tests if a given position is outside the game board.
	 * 
	 * @param pos The position to test.
	 * @return <code>false</code> if the position is outside the playing field, <code>true</code> otherwise.
	 */
	private boolean isOutOfBounds(Position pos) {
		return (pos.getX() < 0 || pos.getX() >= getGameboardSize().width
				|| pos.getY() < 0 || pos.getY() >= getGameboardSize().height);
	}
	
	
	/**
	 * Tests if a given position collided with a forbidden
	 * object (the wall or the snake itself).
	 * 
	 * @param pos The position to test.
	 * @return <code>false</code> is the position collided with an object, else
	 * <code>true</code>.
	 */
	private boolean didCollide(Position pos){
		return isOutOfBounds(pos) || getGameboardState(pos) == SNAKE_TILE;
	}
	
	
	/**
	 * Returns the player's current score.
	 * 
	 * @return The score
	 */
	@Override
	public int getScore(){
		return this.score;
	}
	
	
	@Override
	public void gameUpdate(int lastKey) throws GameOverException {
		updateDirection(lastKey);
		
		setGameboardState(this.snakePos, BLANK_TILE);
		
		this.snakePos = getNextSnakePos();

		if (didCollide(this.snakePos)) {
			throw new GameOverException(this.score);
		}
		
		/* If we ate a fruit */
		if(getGameboardState(this.snakePos) == FRUIT_TILE){
			this.score++;
			addFruit();
			
			// This makes the game lag the first time you eat a fruit .. :/
			successSound.play();
			
			/* Grow with one position */
			this.snakeTiles.push(this.snakePos);
		}
		
		/* Draw the snake body */
		for(Position part : this.snakeTiles){
			setGameboardState(part, SNAKE_TILE);
		}
				
		/* Give the impression of moving the snake body */
		this.snakeTiles.push(this.snakePos);
		Position tail = this.snakeTiles.removeLast();
		
		setGameboardState(tail, BLANK_TILE);
		setGameboardState(this.snakePos, SNAKE_TILE);

	}

}
