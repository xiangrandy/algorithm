/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

package 深度优先;

/**
 * min area
 * 
 * @author x00418543
 * @since 2020年1月16日
 */
public class 包含全部黑色像素的最小矩形 {

    private int top, bottom, left, right;

    public static void main(String[] args) {
        包含全部黑色像素的最小矩形 b = new 包含全部黑色像素的最小矩形();
        char[][] image = { { '0', '1', '1', '1', '0' }, { '0', '1', '0', '1', '1' }, { '0', '0', '1', '1', '0' } };
        int x = 1, y = 1;
        System.out.println(b.minArea(image, x, y));
    }

    public int minArea(char[][] image, int x, int y) {
        if (image.length == 0 || image[0].length == 0)
            return 0;
        top = bottom = x;
        left = right = y;
        dfs(image, x, y);
        return (right - left + 1) * (bottom - top + 1);
    }

    private void dfs(char[][] image, int x, int y) {
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] == '0')
            return;
        image[x][y] = '0'; // mark visited black pixel as white
        top = Math.min(top, x);
        bottom = Math.max(bottom, x);
        left = Math.min(left, y);
        right = Math.max(right, y);
        dfs(image, x + 1, y);
        dfs(image, x - 1, y);
        dfs(image, x, y - 1);
        dfs(image, x, y + 1);
    }

}
