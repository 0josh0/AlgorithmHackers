package com.xpx.demo;

public class WordSearch {
	char[][] board ={
		{'A','B','C','E'},
	  	{'S','F','E','S'},
		{'A','D','E','E'}
	};
	/**
	 * @param board
	 * @param word
	 * @return
	 * @author xpxstar@gmail.com
	 * Given a 2D board and a word, find if the word exists in the grid.
	 * The word can be constructed from letters of sequentially adjacent cell, 
	 * where "adjacent" cells are those horizontally or vertically neighboring. 
	 * The same letter cell may not be used more than once.
	 * For example,
	 * Given board =
	 * [
	 *   ['A','B','C','E'],
	 *   ['S','F','C','S'],
	 *   ['A','D','E','E']
	 * ]
	 * word = "ABCCED", -> returns true,
	 * word = "SEE", -> returns true,
	 * word = "ABCB", -> returns false.
	 */
	public boolean exist(char[][] board,String word) {
	/*˼· ����Ҫ�ҵ���ʼ�㣬����ʼ�㿪ʼ����
	 * ��Ǹýڵ�Ϊ��ƥ�䣬���η�����������ߵĵ��Ƿ��б������ʵ���һ���ַ�
	 * ����Ǽ����Ըýڵ�Ϊ��ʼ����ʣ�µĽڵ�
	 * ������ǣ��򷵻�false�������ýڵ���ʱ��Ĩ����
	 * ��������û���ҵ���Ӧ�ʣ���ôѰ����һ����㣬ֱ���ҵ��ʣ�����true���߱�����������㡣
	 */
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j]== word.charAt(0)) {
					boolean[][] mark = new boolean[board.length][board[0].length];
						int tmp_x = i,tmp_y = j;
						boolean r0 = visit(board, mark, tmp_x, tmp_y,0, word, 1);
						boolean r1 = visit(board, mark, tmp_x, tmp_y,1, word, 1);
						boolean r2 = visit(board, mark, tmp_x, tmp_y,2, word, 1);
						boolean r3 = visit(board, mark, tmp_x, tmp_y,3, word, 1);
						if (r0||r1||r2||r3) {
							return true;
						}	
				}
			}
		}
	return false;
	}
	/**
	 * @param board �ʱ�
	 * @param mark ��ƥ��ʱ��
	 * @param x �����ʽڵ�������
	 * @param y �����ʽڵ������
	 * @param direction ����0-�ϣ�1-�ң�2-�£�3-��
	 * @param word Ŀ���
	 * @param index ��ǰƥ�����
	 * @return �÷����Ƿ�ƥ�����
	 * @author xpxstar@gmail.com
	 */
	private boolean visit(char[][] board,boolean[][] mark,int x,int y,int direction,String word,int index){
		/*˼·�����ȱ�ǵ�ǰ�ʱ�����
		 * �ж��Ƿ�ƥ�����
		 * ע���ж��Ƿ�Խ��
		 * �����ǰ��ƥ��ɹ�������ƥ�䣬���򷵻�false��������ʱ��
		 */
		mark[x][y] = true;
		if (index == word.length()) {
			return true;
		}
		int next_x =0,next_y = 0;
		boolean result = false;
		boolean inarea = false;
		switch (direction) {
		case 0:
			next_x = x-1;
			next_y = y;
			inarea = (next_x >= 0);
			break;
		case 1:
			next_x = x;
			next_y = y+1;
			inarea = (next_y < board[x].length);
			break;
		case 2:
			next_x = x+1;
			next_y = y;
			inarea = (next_x < board.length);
			break;
		case 3:
			next_x = x;
			next_y = y-1;
			inarea = (next_y >= 0);
			break;
		default:
			break;
		}
		if (inarea) {
			if(!mark[next_x][next_y] && board[next_x][next_y]==word.charAt(index)) {
				boolean r0 = visit(board, mark, next_x, next_y,0, word, index+1);
				boolean r1 = visit(board, mark, next_x, next_y,1, word, index+1);
				boolean r2 = visit(board, mark, next_x, next_y,2, word, index+1);
				boolean r3 = visit(board, mark, next_x, next_y,3, word, index+1);
				if (r0||r1||r2||r3) {
					return true;
				}else{
					mark[next_x][next_y]=false;
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
				// TODO Auto-generated method stub
		WordSearch ws = new WordSearch();
		System.out.println(ws.exist(ws.board,"ABCEFSADEESE"));
	}
}
