package com.mololovecode.practice.game.algorithm.bubble.test;

import com.mololovecode.practice.game.algorithm.bubble.BubbleBoardLogic;

public class TestBubbleBoardLogic {

	/**
	 * 首行缩进
	 */
	public static final int PRINT_BOARD_FORMAT_1 = 1;
	
	/**
	 * 第二行缩进
	 */
	public static final int PRINT_BOARD_FORMAT_2 = 2;
	
	public static void main(String[] args) {
		
		TestBubbleBoardLogic testAlgorithm = new TestBubbleBoardLogic();
		testAlgorithm.testBubbleBoardLogic();
	}
	
	private void testBubbleBoardLogic() {
		printBoard(testBubbleBoard1, TestBubbleBoardLogic.PRINT_BOARD_FORMAT_1);
		System.out.println("==========["+23+"]==========");
		int[] result = BubbleBoardLogic.addBubble(23, 1, testBubbleBoard1, true);
		printBoard(result, TestBubbleBoardLogic.PRINT_BOARD_FORMAT_1);
	}
	
	private static void printBoard(int[] board, int format) {
		
		
		for(int i=0;i<board.length;i++) {
			boolean lineRetract = format==PRINT_BOARD_FORMAT_1?true:false;
			if( !((i/BubbleBoardLogic.BOARD_X_NUMBER)%2 == 0) ) {
				lineRetract = !lineRetract;
			}
			String buffer;
			if(lineRetract) {
				buffer = i%10==0?" "+board[i]:" "+board[i];
			}else {
				buffer = i%10==0?""+board[i]:" "+board[i];
			}
			
			
			if( i%BubbleBoardLogic.BOARD_X_NUMBER == (BubbleBoardLogic.BOARD_X_NUMBER-1) ) {
				System.out.println(buffer);				
			}else {
				System.out.print(buffer);
			}
		}
		
	}
	
	/**
	 * 检查两个棋盘是否相同。
	 * @param board1
	 * @param board2
	 * @return
	 */
	public static boolean boardIsSame(int[] board1, int[] board2) {
		if(board1 == null || board2 == null) {
			return false;
		}
		if(board1.length != board2.length) {
			return false;
		}
		for(int i=0;i<board1.length;i++) {
			if(board1[i] != board2[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public static int[] testBubbleBoard1 =  {
			0, 0, 0, 0, 0, 0, 0, 0, 1, 0,
			1, 1, 1, 1, 1, 1, 1, 0, 1, 1,
			0, 0, 0, 0, 0, 0, 0, 0, 1, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 1, 0,
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			0, 0, 0, 0, 0, 0, 0, 1, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 1, 0, 0,
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			0, 0, 1, 0, 0, 0, 0, 0, 0, 0,
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1
	};

}
