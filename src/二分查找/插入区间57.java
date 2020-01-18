package 二分查找;
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * 插入区间
 * 
 * @author x00418543
 * @since 2020年1月16日
 */
public class 插入区间57 {

    public static void main(String[] args) {
        插入区间57 c = new 插入区间57();
        int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval = { 4, 8 };
        int[][] a = c.insert(intervals, newInterval);
        System.out.println(a);
    }

    public int midSearch(int[][] intervals, int[] newInterval) {
        int start = 0;
        int end = intervals.length;
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (intervals[mid][0] < newInterval[0])
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int count = 1;
        int[] buffer = new int[2];
        buffer[0] = newInterval[0];
        buffer[1] = newInterval[1];
        int place = midSearch(intervals, newInterval);// 找到插入位置
        // 向后合并
        int temp;
        for (temp = place; temp < intervals.length; temp++) {
            if (buffer[1] < intervals[temp][0])
                break;
        }
        if (temp != place) {
            buffer[1] = Math.max(intervals[temp - 1][1], buffer[1]);
            count -= temp - place;
        }
        // 向前合并
        if (place != 0) {
            if (intervals[place - 1][1] >= buffer[0]) {
                buffer[0] = intervals[place - 1][0];
                buffer[1] = Math.max(intervals[place - 1][1], buffer[1]);
                place--;
                count--;
            }
        }
        // 储存结果
        int target;
        int[][] result = new int[intervals.length + count][2];
        for (target = 0; target < place; target++) {
            result[target][0] = intervals[target][0];
            result[target][1] = intervals[target][1];
        }
        result[target][0] = buffer[0];
        result[target][1] = buffer[1];
        target++;
        for (; temp < intervals.length; temp++, target++) {
            result[target][0] = intervals[temp][0];
            result[target][1] = intervals[temp][1];
        }
        return result;
    }

}
