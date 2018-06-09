package com.tw;

import java.util.Objects;

public class Cell {
    private int status;
    private int liveNeighborCount;

    public Cell(int status) {
        this.status = status;
    }

    public int getLiveNeighborCount() {
        return liveNeighborCount;
    }

    public void setLiveNeighborCount(int liveNeighborCount) {
        this.liveNeighborCount = liveNeighborCount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return status == cell.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }

    @Override
    public String toString() {
        if(status == 0){
            return " ";
        }
        return String.valueOf(status);
    }
}
