package 递归;
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * TODO 在此添加类型注释
 * 
 * @author x00418543
 * @since 2020年1月9日
 */
public class ReachingPoints {

    public static void main(String[] args) {
        ReachingPoints r = new ReachingPoints();
        int sx = 35, sy = 13, tx = 455955547, ty = 420098884;
        System.out.println(r.reachingPoints(sx, sy, tx, ty));
    }

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (tx < sx || ty < sy) {
            return false;
        }
        if (tx > ty) {
            return reachingPoints(sx, sy, tx % ty, ty);
        } else if (tx < ty) {
            return reachingPoints(sx, sy, tx, ty % tx);
        } else {
            return tx == sx && ty == sy;
        }
    }

}
