import java.util.*;
import java.io.*; 

public class GameOfLifeMain {
	public static final int REFRESH_RATE = 100;
	
	
	public static void main(String[] args) throws FileNotFoundException{
	
		StdDraw.setCanvasSize(800, 800);
			
		GameOfLife gameOfLife;
		
		/*
		 * Choose if program should run of a file, or random values with given size.
		 * */
		boolean inputFilepath = getInput();
		if (inputFilepath) {
			File f = getFile();
			int[][] grid = readFile(f);
			gameOfLife = new GameOfLife(grid);
			StdDraw.setXscale(0, grid.length);
			StdDraw.setYscale(0, grid.length);
		} else {
			int size = getSize();
			gameOfLife = new GameOfLife(size);
			StdDraw.setXscale(0, size);
			StdDraw.setYscale(0, size);
		}

		// Simulation loop
		while(true) {
			StdDraw.clear();
			gameOfLife.drawState();
			StdDraw.show(REFRESH_RATE);
			gameOfLife.nextState();

		}	
	}
	
	/*
	 * This method reads a given file containing an int[][]
	 * */
	public static int[][] readFile(File f) throws FileNotFoundException {
		Scanner scanner = new Scanner(f);

		List<String> lines = new ArrayList<String>();
		
		while (scanner.hasNextLine()) {
		    lines.add(scanner.nextLine());
		}
		
		int size = lines.size();
		if(size == 0) {
			System.out.println("File is empty. Try again");
			return readFile(getFile());
		}
		int[][] grid = new int[size][size];
		try {
			for (int i = 0; i < size; i++) {
				Scanner line = new Scanner(lines.get(i));
				for (int j = 0; j < size; j++) {
					grid[i][j] = line.nextInt();
				}
			}
		} catch (NoSuchElementException e) {
			 System.out.println("Matrix is wrong dimensions. Try again.");
			 return readFile(getFile());
		}
		return grid;
	}
	
	/* 
     * This method prompts the user for a Yes or No answer. 
     * The method returns either false or true depending on the input.
     * */
	public static boolean getInput() {
        Scanner input = new Scanner(System.in);
        String s;
        try {
            System.out.print("Do you want to use a file? (Y or N): ");
            s = input.next();
            if (s.equals("Y")) {
            	return true;
            } else if (s.equals("N")) {
            	return false;
            } else {
            	System.out.println("Enter Y or N");
                return getInput();
            }
        } catch (InputMismatchException e) {
            System.out.println("Enter Y or N");
            return getInput();
        }
    }
	
	/* 
     * This method prompts the user for a filepath. 
     * A file-object is returned, if the file could be located.
     * */
	public static File getFile() {
        Scanner input = new Scanner(System.in);
        String fp;
        try {
            System.out.print("Enter filepath: ");
            fp = input.nextLine();
            File f = new File(fp);
            
            if(f.canRead()) {
            	return f;
            } else {
            	System.out.println("Unable to locate file, try again");
            	return getFile();
            }
        } catch (InputMismatchException e) {
            System.out.println("Unable to locate file, try again");
            return getFile();
        }
    }
	
	/* 
     * This method prompts the user for an integer greater than 1. 
     * */
	public static int getSize() {
        Scanner input = new Scanner(System.in);
        int num = 0;
        try {
            System.out.print("Enter size of grid: ");
            num = input.nextInt();
            if (num > 0) {
                return num;
            } else {
                System.out.println("Input an interger greater than 0");
                return getSize();
            }
        } catch (InputMismatchException e) {
        	System.out.println("Input an interger greater than 0");
            return getSize();
        }
    }




}



