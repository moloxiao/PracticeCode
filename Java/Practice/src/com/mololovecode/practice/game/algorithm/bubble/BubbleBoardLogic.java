package com.mololovecode.practice.game.algorithm.bubble;

/**
 * 
 * 
 * @author molo.xiao@gmail.com
 * 
 *
 */
public class BubbleBoardLogic {
	
	public static final int BOARD_X_NUMBER = 10;
	public static final int BOARD_Y_NUMBER = 10;
	public static final int BOARD_NUMBER = 100;

	private static int[] zeroBoard;
	private static int zeroCount;
	
	/**
	 * 等待实现
	 * 计算添加泡泡后的棋盘变化。
	 * @param newPosition 添加泡泡的位置。
	 * @param newType 新元素的类型
	 * @param board 棋盘信息。
	 * @return
	 */
	public static int[] addBubble(int newPosition, int newType, int[] board) {
		zeroBoard = BubbleBoardLogic.getZeroBoard();
		zeroCount = 0;
		board[newPosition] = newType;
		
		checkLine(newPosition, board);
		if(zeroCount >= 3) {
			for(int i=0;i<BOARD_NUMBER;i++) {
				if(zeroBoard[i] == 1) {
					board[i] = 0;
				}
			}
		}
		
		return board;
	}
	
	public static void checkLine(int position, int[] board) {
		if(!inBoard(position)) {
			return;
		}else {
			zeroBoard[position] = 1;
			zeroCount++;
		}
		
		int x = BubbleBoardLogic.getXByPosition(position);
		int y = BubbleBoardLogic.getYByPosition(position);
		
		// step1 : checkLeft
		if(x > 0) {
			int leftPosition = BubbleBoardLogic.getPositionByXAndY(x-1, y);
			if(board[leftPosition] == board[position] &&
					zeroBoard[leftPosition] == 0) {
				checkLine( leftPosition, board );
			}
		}
		
		// step2 : checkRight
		if( x < BubbleBoardLogic.BOARD_X_NUMBER-1 ) {
			int rightPosition = BubbleBoardLogic.getPositionByXAndY(x+1, y);
			if(board[rightPosition] == board[position] &&
					zeroBoard[rightPosition] == 0) {
				checkLine( rightPosition, board );
			}
		}
		
		// step3 : checkTop
		if(y > 0) {
			int topPosition = BubbleBoardLogic.getPositionByXAndY(x, y-1);
			if(board[topPosition] == board[position] &&
					zeroBoard[topPosition] == 0) {
				checkLine( topPosition, board );
			}
		}
		
		// step4 : checkTopNext
		if(y > 0 && x < BubbleBoardLogic.BOARD_X_NUMBER-1) {
			int topNextPosition = BubbleBoardLogic.getPositionByXAndY(x+1, y-1);
			if(board[topNextPosition] == board[position] &&
					zeroBoard[topNextPosition] == 0) {
				checkLine( topNextPosition, board );
			}
		}
		
		// step5 : checkBottom
		if(y < BubbleBoardLogic.BOARD_Y_NUMBER-1) {
			int bottomPosition = BubbleBoardLogic.getPositionByXAndY(x, y+1);
			if(board[bottomPosition] == board[position] &&
					zeroBoard[bottomPosition] == 0) {
				checkLine( bottomPosition, board );
			}
		}
		
		// step6 : checkBottomNext
		if(y < BubbleBoardLogic.BOARD_Y_NUMBER-1 && x < BubbleBoardLogic.BOARD_X_NUMBER-1) {
			int bottomNextPosition = BubbleBoardLogic.getPositionByXAndY(x+1, y+1);
			if(board[bottomNextPosition] == board[position] &&
					zeroBoard[bottomNextPosition] == 0) {
				checkLine( bottomNextPosition, board );
			}
		}
	}
	
	public static int getPositionByXAndY(int x, int y) {
		return x + y*BOARD_X_NUMBER;
	}
	
	public static int getXByPosition(int position) {
		return position%BOARD_X_NUMBER;
	}
	
	public static int getYByPosition(int position) {
		return position/BOARD_X_NUMBER;
	}
	
	public static boolean inBoard(int position) {
		if(position < 0) {
			return false;
		}
		if(position >= BOARD_NUMBER) {
			return false;
		}
		return true;
		
	}
	
	private static int[] getZeroBoard() {
		int[] zeroBoard = {
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0
		};
		return zeroBoard;
	}
}
