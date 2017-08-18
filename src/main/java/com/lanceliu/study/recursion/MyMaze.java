package com.lanceliu.study.recursion;

/**
 * 回溯法解决，迷宫算法
 *
 * @author MIX
 *
 */
public class MyMaze {

    private static int startPosI; // 入口的i下标
    private static int startPosJ; // 入口的j下标
    private static int endPosI; // 出口的j下标
    private static int endPosJ; // 出口的j下标

    // 设置迷宫入口的坐标
    public void setStart(int startPosI, int startPosJ) {

        MyMaze.startPosI = startPosI;
        MyMaze.startPosJ = startPosJ;
    }

    // 设置迷宫出口的坐标
    public void setEnd(int endPosI, int endPosJ) {

        MyMaze.endPosI = endPosI;
        MyMaze.endPosJ = endPosJ;
    }

    // 迷宫搜索通路的算法
    /**
     *
     * @param cell
     *            迷宫地图
     * @param i
     *            入口的i坐标
     * @param j
     *            入口的j坐标
     */
    public static void visited(int[][] cell, int i, int j) {
        // 表示此路为通
        /*
         * 该标记记为走过该路径，一旦该路径为通路且走到了该路径那么就将该位置置为1
         */
        cell[i][j] = 1;
        String oriention = null;
        if (i == endPosI && j == endPosJ) { // 找到了出口
            System.out.println("找到一条通路");
            for (int m = 0; m < cell.length; m++) {
                for (int n = 0; n < cell[i].length; n++) {
                    if (cell[m][n] == 2) {
//                        System.out.print("2");
                    } else if (cell[m][n] == 1) {
                        System.out.print("("+m+","+n+")");
                    } else {
//                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }

        // 向左边寻找通路
        if (cell[i][j - 1] == 0) {
            oriention = "left";
            System.out.println("left");
            visited(cell, i, j - 1);
        }
        // 向右寻找通路
        if (cell[i][j + 1] == 0) {
            oriention = "right";
            System.out.println("right");
            visited(cell, i, j + 1);
        }
        // 向上寻找通路
        if (cell[i - 1][j] == 0) {
            oriention = "up";
            System.out.println("up");
            visited(cell, i - 1, j);
        }
        // 向下寻找通路
        if (cell[i + 1][j] == 0) {
            oriention = "down";
            System.out.println("down");
            visited(cell, i + 1, j);
        }
        /*
         * 一旦该路径走到了死胡同里，清理走过的路径将当前位置重新标志为1，推出当前递归的迭代堆栈，返回上一次，继续
         * 在当前函数里面的应用主要是清理之前走过的但是被标记为1的位置，将该位置重新置为0，以便下一次的位置可以访问
         */
        oriention = "无知的我";
        System.out.println("撤销");
        cell[i][j] = 0;

    }

    public static void main(String[] args) {
        // 初始化一个迷宫地图
//        int[][] maze = { { 2, 2, 2, 2, 2, 2, 2, 2, 2 },
//                { 2, 0, 0, 0, 0, 0, 0, 0, 2 }, { 2, 0, 2, 2, 0, 2, 2, 0, 2 },
//                { 2, 0, 2, 0, 0, 2, 0, 0, 2 }, { 2, 0, 2, 0, 2, 0, 2, 0, 2 },
//                { 2, 0, 0, 0, 0, 0, 2, 0, 2 }, { 2, 2, 0, 2, 2, 0, 2, 2, 2 },
//                { 2, 0, 0, 0, 0, 0, 0, 0, 2 }, { 2, 2, 2, 2, 2, 2, 2, 2, 2 } };

        // MyMaze cell = new MyMaze();
        // cell.setStart(1, 1);
        // cell.setEnd(7, 7);
        // cell.visited(maze, startPosI, startPosI);
        int[][] maze2 = { { 2, 2, 2, 2 }, { 2, 0, 0, 2 }, { 2, 0, 0, 2 },
                { 2, 2, 2, 2 } };
        MyMaze cell = new MyMaze();
        cell.setStart(1, 1);
        cell.setEnd(2, 2);
        cell.visited(maze2, startPosI, startPosJ);
    }

}