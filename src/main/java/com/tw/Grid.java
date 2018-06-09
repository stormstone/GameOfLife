package com.tw;

import java.util.Random;

public class Grid {
    public Cell[][] gridCell;
    private int height;
    private int width;

    public Grid(int h, int w) {
        this.height = h;
        this.width = w;
        initGrid();
    }

    public Grid(Cell[][] gridCell) {

        if(gridCell == null || gridCell.length == 0){
            throw new InputInvalidException("input is null or length == 0 !");
        }
        this.height = gridCell.length;
        this.width = gridCell[0].length;
        this.gridCell = gridCell;
    }

    public Cell[][] getGridCell() {
        return gridCell;
    }

    public void setGridCell(Cell[][] gridCell) {
        this.gridCell = gridCell;
    }

    private void initGrid() {
        Random random = new Random();
        gridCell = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                gridCell[i][j] = new Cell(random.nextInt(10) % 2);
            }
        }
    }

    public void nextGenerator() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                int liveNumbers = getLiveNumber(i, j);
                gridCell[i][j].setLiveNeighborCount(liveNumbers);
            }
        }
        updateStatus();
    }

    private void updateStatus() {
        for (int i = 0; i < gridCell.length; i++) {
            for (int j = 0; j < gridCell[0].length; j++) {
                int liveNumbers = gridCell[i][j].getLiveNeighborCount();
                if (liveNumbers < 2 || liveNumbers > 3) {
                    gridCell[i][j].setStatus(0);
                } else if (liveNumbers == 3) {
                    gridCell[i][j].setStatus(1);
                }
            }
        }
    }

    public int getLiveNumber(int x, int y) {
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (x + i < 0 || y + j < 0 || x + i > height - 1 || y + j > width - 1 || (i == 0 && j == 0)) {
                    continue;
                }
                if (gridCell[x + i][y + j].getStatus() == 1) {
                    count++;
                }
            }
        }
        return count;
    }


    public String print(Cell[][] input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                result.append(input[i][j].toString() + " ");
            }
            result.append("\n");
        }
        return result.toString();
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.gridCell.length; i++) {
            for (int j = 0; j < this.gridCell[0].length; j++) {

                result.append(this.gridCell[i][j].toString() + " ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
