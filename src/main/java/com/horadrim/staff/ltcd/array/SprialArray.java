package com.horadrim.staff.ltcd.array;

public class SprialArray {
    /*
     * 通过路径来打印螺旋数组
     */
    int [] solution(int [][] arrays) {
        if (arrays == null || arrays.length == 0 || arrays[0].length == 0) {
            return new int[0];
        }
        int rows = arrays.length, columns = arrays[0].length;
        // 用于记录二维数组中的元素是否被遍历过
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int[] order = new int[total];
        // 二维索引
        int row = 0, column = 0;

        // 定义directions表示4个方向并且指定了二维数组中遍历的顺序，右 -> 下 -> 左 -> 上
        // directionIndex为当前遍历的方向，初始为向右
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order[i] = arrays[row][column];
            visited[row][column] = true;
            // 计算二维数组中下一个遍历的目标
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            // 到达边界或者目标已经被遍历过则转换方向
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }

    /*
     * 通过遍历二维数组的层(圈)
     */
    public int[] solutionII(int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return new int[0];
        }
        int rows = array.length, columns = array[0].length;
        int[] order = new int[rows * columns];
        // 数组的索引
        int index = 0;
        // 4个顶点来确定二维数组的最外层
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;

        // 退出条件，当最内层为[{x}], [{x, y}, {x1, x2}]的时候left > right, top > bottom
        while (left <= right && top <= bottom) {
            // 由左向右遍历
            for (int column = left; column <= right; column++) {
                order[index++] = array[top][column];
            }

            // 由上向下遍历，row = top + 1因为array[top][column]已经遍历过
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = array[row][right];
            }

            // 此时需要遍历当前层的底部和左边的元素
            // left == right 或者 top == bottom的时候，说明已经遍历到最后一圈了
            if (left < right && top < bottom) {
                // 由右往左遍历底部的元素，同样column = right - 1因为array[row][right]已经遍历过
                for (int column = right - 1; column > left; column--) {
                    order[index++] = array[bottom][column];
                }
                // 由下往上遍历左边的元素
                for (int row = bottom; row > top; row--) {
                    order[index++] = array[row][left];
                }
            }

            // 一层遍历结束，进入内部一层
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
