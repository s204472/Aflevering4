import java.util.Random;
import java.util.Arrays; 

public class GameOfLife {
	private int[][] grid;
	private Random rand = new Random();
	private int size; 
	
	
	// Constructor setting random values
	public GameOfLife(int size) {
		this.size = size;
		grid = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				grid[i][j] = rand.nextInt(2);
			}
		}
	}
	// Constructor setting given values
	public GameOfLife(int[][] initialState) {
		this.size = initialState.length;
		this.grid = initialState;
	}
	
	// Method for drawing current state
	public void drawState() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (grid[i][j] == 1) {
					StdDraw.filledCircle(i + 0.5, j + 0.5, 0.5);	
				}
			}
		}
	}
	// Method for calculating next state
	public void nextState() {
		int[][] newGrid = new int[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				newGrid[i][j] = grid[i][j];
			}
		}
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int neighbours = getAliveNeighbours(i, j);
				if(neighbours < 2 && grid[i][j] == 1) {
					newGrid[i][j] = 0;
				} else if(neighbours > 3 && grid[i][j] == 1) {
					newGrid[i][j] = 0;
				} else if (neighbours == 3 && grid[i][j] == 0) {
					newGrid[i][j] = 1;
				}
				
			}
		}
		grid = newGrid;
	}
	
	// Method for calculating alive neighbours.
	public int getAliveNeighbours(int x, int y) {
		int counter = 0;
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (!(i == 0 && j == 0) && (x + i >= 0 && x + i < size && y + j >= 0 && y + j < size)){
					counter += grid[x + i][y + j] == 1 ? 1 : 0;
				}
				
			}
		}
		return counter;		
	}
	
	
}
