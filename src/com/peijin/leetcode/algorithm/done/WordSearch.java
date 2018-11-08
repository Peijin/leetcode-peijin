/**
 *
 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically
 neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */
package com.peijin.leetcode.algorithm.done;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (exist(board, w, x, y, 0)) return true;
            }
        }
        return false;
    }

    /**
     *
     * @param board
     * @param word
     * @param x 当前位置x
     * @param y 当前位置y
     * @param i 当前第i个字符
     * @return
     */
    public boolean exist(char[][] board, char[] word, int x, int y, int i){
        if(i == word.length) return true;
        if(x < 0 || y < 0 || y == board.length || x == board[y].length) return false;

        if(board[y][x] != word[i]) return false;

        board[y][x] ^= 256;
        boolean exist = exist(board, word, x + 1, y ,i + 1)
                || exist(board, word, x - 1, y ,i + 1)
                || exist(board, word, x, y + 1 ,i + 1)
                || exist(board, word, x, y - 1 ,i + 1);

        board[y][x] ^= 256;
        return exist;
    }

    public static void main(String args[] ){
        char a = 'a';
        a ^= 256;
        System.out.println(a);
        a ^= 256;
        System.out.println(a);
    }
}
