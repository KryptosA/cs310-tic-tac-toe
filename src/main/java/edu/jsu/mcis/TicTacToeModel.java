package edu.jsu.mcis;

public class TicTacToeModel {
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
     public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */
		
		grid = new Mark[width][width];
		
		/* Initialize grid by filling every square with empty marks */
		
		for (int row = 0; row < width; row++) {		/*rows*/
			for (int col = 0; col < width; col++) {	/*columns*/
				grid[row][col] = Mark.EMPTY;
			}
		}
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
        
		for (row = 0; row < width; row++) {		/*rows*/
			for (col = 0; col < width; col++) {	/*columns*/
					if (grid[row][col] == Mark.EMPTY && xTurn == true) {
					grid[row][col] = Mark.X;
				}
				else {
					grid[row][col] = Mark.O;
				}
			}
		}
		
		
		return true;
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        
        if (row < width && col < width) {
			grid[row][col] = Mark.O;
		}
		
		for (row = 0; row < width; row++) {		/*rows*/
			for (col = 0; col < width; col++) {	/*columns*/
				if (row < width && col < width) {
					grid[row][col] = Mark.X;
				}
				else {
					grid[row][col] = Mark.O;
				}
			}
		}
		
        return true;
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        
        if(grid[row][col] != Mark.EMPTY) {
			grid[row][col] = Mark.O;
		}

        return true;
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        
        return grid[row][col];
            
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        /* INSERT YOUR CODE HERE */

        return null; /* remove this line! */

    }
	
    private boolean isMarkWin(Mark mark, int col, int row) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
		/*row*/
		for (int i=0; i<width; i++){
			if (grid[i][col] != Mark.EMPTY) {
				return true;
			}
		}
		/*col*/
		for (int j=0; j<width; j++){
			if (grid[row][j] != Mark.EMPTY) {
				return true;
			}
		}
		
		/*diagonal*/
		if(col == row){
			for(int d=0; d<width; d++){
				if(grid[d][d] != Mark.EMPTY){
					return true;
				}
			}
		}
		
		/*reverse diagonal*/
		if(col+row == width -1){
			for(int rd=0; rd<width; rd++){
				if(grid[rd][(width-1)-rd] != Mark.EMPTY){
					return true;
				}
			}
		}

		return true;

    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        for (int row = 0; row < width; row++) {		/*rows*/
			for (int col = 0; col < width; col++) {	/*columns*/
				if (grid[row][col] == Mark.X && grid[row][col] == Mark.O) {
					return true;
				}
			}
		}  
		return true;
    }

    public boolean isGameover() {
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
}