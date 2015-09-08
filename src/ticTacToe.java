
public class ticTacToe {
	private char[][] board;
	private char playerMark;
	
	public ticTacToe() {
		board = new char[3][3];
		playerMark = 'x';	//will alternate between x and o
		initializeBoard();
	}
	
	//to initialize the board in terms of set and reset
	public void initializeBoard() {
		for (int i = 0; i<3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '-';
			}
		}
	}
	
	//to print the current board
	public void printBoard() {
		System.out.println("----------");
		for (int i = 0; i < 3; i++) {
			System.out.println("| ");
			for (int j = 0; j < 3; j++) {
				System.out.println(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("----------");
		}
	}
	public boolean isBoardFull() {
		boolean isFull = true;
		for (int i = 0; i <3; i++) {
			for (int j = 0; j <3; j++) {
				if (board[i][j] == '-') {
					isFull = false;
				}
			}
		}
		return isFull;
	}
	
	
	
	//to check to win: 3 possibilities of row, column and diagonal wins
	public boolean checkSameType(char char1, char char2, char char3) {
		return (char1 != '-' && char1 == char2 && char2 == char3); 
	}
	public boolean Win() {
		return (rowWin() || columnWin() || diagonalWin());
	}
	public boolean rowWin() {
		for (int i = 0; i < 3; i++) {
			if (checkSameType (board[i][0], board[i][1], board[i][2]) == true) {
				return true;
			}
		}
		return false;
	}
	public boolean columnWin() {
		for (int i = 0; i < 3; i++) {
			if (checkSameType (board[0][i], board[0][i], board[0][i]) == true) {
				return true;
			}
		}
		return false;
	}
	public boolean diagonalWin() {
		return ((checkSameType(board[1][1], board[2][2], board[3][3]) == true) || (checkSameType(board[1][3], board[2][2], board[3][1]) == true));
	}
	
	
	
	//change player mark alternatively
	public void changePlayer() {
		if (playerMark == 'x') {
			playerMark = 'o';
		}
		else playerMark = 'x';
	}
	
	//to make sure that markers are placed at the right spot without collisions
	public boolean placeMark (int row, int col) {
		if (row >=0 && row < 3) {
			if (col >=0 && col < 3) {
				if (board[row][col] == '-') {
					board[row][col] = playerMark;
					return true;
				}
			}
		}
		return false;
	}
	
	
}
