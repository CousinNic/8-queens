/*
 * Author: Nic Drummey
 * Date: 4-13-2022
 * a program to find all possible solutions of the 8 queens problem
 */
public class term_project {
	
	static char[][] board = new char[9][9];
	
	/*
	 * main method to find all possible solutions of the 8 queens problem
	 */
	public static void main(String[] args) {
		int totalSolutions = 0;
		initalizeBoard();
		for(int i = 0; i < 16434824; i++) {
			//moves a queen to the next position changing the enviorment
		moveQueen(0);
		//checks the current enviorment if it is a valid solution
		if(ifSolution()) {
			totalSolutions++;
			printboard();
		}

		}
		System.out.println(totalSolutions + " total solutions were found");
		
	}
	/*
	 * this method checks for any conflict between queens on the current state of the board
	 * returns true if no conflict is found
	 */
	public static boolean ifSolution() {
		for(int h = 0; h < 8; h++) {
			for(int w = 0; w < 8; w++) {
				if(board[h][w] == 'Q') {
					if(!checkQ(h,w))
						return false;
				}
			}
		}
		return true;
	}
	/*arguments: int h, int w
	 * using height and width this method checks the board for any 
	 * queens that threaten the position on the board being pointed to
	 * and returntrue if there is no threat
	 */
	public static boolean checkQ(int h, int w){
		int tempW = w;
		int tempH = h;
		//check for vertical
		for(int i = 0; i < 8; i++) {
			if(board[i][w] == 'Q' && i != h)
				return false;
		}
		//check for right angle
		for(int i = 0; tempH >= 0 && tempW <= 8; i++) {
			if(board[tempH][tempW] == 'Q' && (tempH != h && tempW != w)) 
				return false;
			tempW++;
			tempH--;
		}
		//check for left angle
		 tempW = w;
		 tempH = h;
		for(int i = 0; tempH >= 0 && tempW >= 0; i++) {
			if(board[tempH][tempW] == 'Q' && (tempH != h && tempW != w)) 
				return false;
			tempW--;
			tempH--;
		}
		
		return true;
	}
	/*
	 * this method recursively updates one line of the chest board by moving the queen one space to the right, 
	 * if the queen is allready at the end of the current line, the queen will be 
	 * placed at the begining, and the method will be recursively called on the line below,
	 * and so on...
	 */
	public static void moveQueen(int row){
		for(int w = 0; w < 8; w++) {
			if(board[row][w] == 'Q') {
				if(board[row][w+1] != '-') {
				board[row][w] = '-';
				board[row][0] = 'Q';
				moveQueen(row+1);
				return;
				}
			board[row][w] = '-';
			board[row][w+1] = 'Q';
			return;
			}
		}
	}
	
	/*
	 * builds the chest board and places 8 queens
	 */
	public static void initalizeBoard() {		
		int temp = 7;
		for (int q = 0; q < 8; q++) {
			for(int i = 0; i < 8; i++) {
				if(i == temp) {
					board[q][i] = 'Q';
				}else {
				board[q][i] = '-';
				}
			}
			temp--;
		}
	}
	
	/*
	 * method to print the current state of the chess board when called
	 */
	public static void printboard() {
		for (int q = 0; q < 8; q++) {
			for(int i = 0; i < 8; i++) {
				System.out.print(board[q][i]+" ");
			}
			System.out.println("");
		}
		System.out.println();
	}

}
