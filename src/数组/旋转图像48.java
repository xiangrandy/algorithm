/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */
package 数组;

/**
 * TODO 在此添加类型注释
 * 
 * @author x00418543
 * @since 2020年2月11日
 */
public class 旋转图像48 {

    public static void main(String[] args) {
        旋转图像48 x = new 旋转图像48();
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        x.rotate(matrix);
        System.out.println(matrix);
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = matrix[(n - 1) - j][i];
                matrix[(n - 1) - j][i] = matrix[(n - 1) - i][(n - 1) - j];
                matrix[(n - 1) - i][(n - 1) - j] = matrix[j][(n - 1) - i];
                matrix[j][(n - 1) - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

}
