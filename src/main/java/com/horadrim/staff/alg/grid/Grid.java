package com.horadrim.staff.alg.grid;

import lombok.Data;

@Data
public class Grid {
    private static final int DEFAULT_X = 2;

    private static final int DEFAULT_Y = 2;

    private int [][] grid;

    private int x;

    private int y;

    public Grid() {
        x = DEFAULT_X;
        y = DEFAULT_Y;

        grid = new int[y][];
        for (int i = 0; i < y; ++i) {
            int [] x_axis = new int[x];
            grid[i] = x_axis;
        }
    }

    public Grid(int x_val, int y_val) {
        if (x_val <= 0) {
            x = DEFAULT_X;
        } else {
            x = x_val;
        }

        if (y_val <= 0) {
            y = DEFAULT_Y;
        } else {
            y = y_val;
        }

        grid = new int[y][];
        for (int i = 0; i < y; ++i) {
            int [] x_axis = new int[x];
            grid[i] = x_axis;
        }
    }

    public void setGridValue(int x_axis, int y_axis, int value) {
        if (x_axis >= x || x_axis < 0 || y_axis >= y || y < 0) {
            throw new IndexOutOfBoundsException(String.format("invalid input x: %d, y: %d", x_axis, y_axis));
        }

        grid[y_axis][x_axis] = value;
    }

    public int getGridValue(int x_axis, int y_axis) {
        if (x_axis >= x || x_axis < 0 || y_axis >= y || y < 0) {
            throw new IndexOutOfBoundsException(String.format("invalid input x: %d, y: %d", x_axis, y_axis));
        }

        return grid[y_axis][x_axis];
    }
}
