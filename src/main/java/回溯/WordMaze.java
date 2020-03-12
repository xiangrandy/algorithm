package 回溯;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * Word Maze
 * 
 * @author x00418543
 * @since 2020年1月15日
 */
public class WordMaze {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        s.nextLine();
        String word = s.nextLine();
        char[][] maze = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = s.nextLine();
            char[] chars = line.toCharArray();
            maze[i] = chars;
        }
        System.out.println(exist(maze, word) ? "YES" : "NO");
    }

    public static boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        List<Trace> starts = start(board, chars[0]);
        for (Trace start : starts) {
            Stack<Trace> stack = new Stack<>();
            stack.add(new Trace(start.x, start.y));
            boolean exist = existNext(stack, start.x, start.y, board, 1, chars);
            if (exist) {
                return true;
            }
        }
        return false;
    }

    public static boolean existNext(Stack<Trace> stack, int x, int y, char[][] board, int index, char[] chars) {
        if (index == chars.length) {
            return true;
        }
        if ((x - 1 >= 0) && board[x - 1][y] == chars[index] && !stack.contains(new Trace(x - 1, y))) {
            // 上
            stack.push(new Trace(x - 1, y));
            if (existNext(stack, x - 1, y, board, index + 1, chars)) {
                return true;
            } else {
                stack.pop();
            }
        }
        if ((y - 1 >= 0) && board[x][y - 1] == chars[index] && !stack.contains(new Trace(x, y - 1))) {
            // 左
            stack.push(new Trace(x, y - 1));
            if (existNext(stack, x, y - 1, board, index + 1, chars)) {
                return true;
            } else {
                stack.pop();
            }
        }
        if ((x + 1 < board.length) && board[x + 1][y] == chars[index] && !stack.contains(new Trace(x + 1, y))) {
            // 下
            stack.push(new Trace(x + 1, y));
            if (existNext(stack, x + 1, y, board, index + 1, chars)) {
                return true;
            } else {
                stack.pop();
            }
        }
        if ((y + 1 < board[x].length) && board[x][y + 1] == chars[index] && !stack.contains(new Trace(x, y + 1))) {
            // 右
            stack.push(new Trace(x, y + 1));
            if (existNext(stack, x, y + 1, board, index + 1, chars)) {
                return true;
            } else {
                stack.pop();
            }
        }
        return false;
    }

    public static List<Trace> start(char[][] board, char c) {
        List<Trace> traces = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == c) {
                    traces.add(new Trace(i, j));
                }
            }
        }
        return traces;
    }

}

class Trace {
    public int x;
    public int y;

    public Trace(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Trace other = (Trace) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

}
