package com.tw;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class GridTest {
    int height = 0;
    int width = 0;
    private Grid grid = new Grid(height, width);


    @Test
    public void live_number_less_than_2() {
        Cell input[][] = {
                {new Cell(0), new Cell(0), new Cell(0)},
                {new Cell(0), new Cell(1), new Cell(0)},
                {new Cell(0), new Cell(1), new Cell(0)}};
        Grid grid = new Grid(input);
        Cell output[][] = {
                {new Cell(0), new Cell(0), new Cell(0)},
                {new Cell(0), new Cell(0), new Cell(0)},
                {new Cell(0), new Cell(0), new Cell(0)}};
        grid.nextGenerator();
        assertArrayEquals(output, grid.getGridCell());
    }


    @Test
    public void shoule_return_center_live_numbers_successfully() {
        Cell input[][] = {
                {new Cell(0), new Cell(0), new Cell(0)},
                {new Cell(0), new Cell(1), new Cell(0)},
                {new Cell(0), new Cell(1), new Cell(0)}};
        Grid grid = new Grid(input);
        int expectedResult = 1;
        assertEquals(grid.getLiveNumber(1, 1), expectedResult);
    }


    @Test
    public void shoule_return_left_top_live_numbers_successfully() {
        Cell input[][] = {
                {new Cell(0), new Cell(0), new Cell(0)},
                {new Cell(0), new Cell(1), new Cell(0)},
                {new Cell(0), new Cell(1), new Cell(0)}};
        Grid grid = new Grid(input);
        int expectedResult = 1;
        assertEquals(grid.getLiveNumber( 0, 0), expectedResult);
    }


    @Test
    public void shoule_return_right_bottom_live_numbers_successfully() {
        Cell input[][] = {
                {new Cell(0), new Cell(0), new Cell(0)},
                {new Cell(0), new Cell(1), new Cell(0)},
                {new Cell(0), new Cell(1), new Cell(0)}};
        Grid grid = new Grid(input);
        int expectedResult = 2;
        assertEquals(grid.getLiveNumber(2, 2), expectedResult);
    }


    @Test
    public void shoule_return_right_top_live_numbers_successfully() {
        Cell input[][] = {
                {new Cell(0), new Cell(0), new Cell(0)},
                {new Cell(0), new Cell(1), new Cell(0)},
                {new Cell(0), new Cell(1), new Cell(0)}};
        Grid grid = new Grid(input);
        int expectedResult = 1;
        assertEquals(grid.getLiveNumber(0, 2), expectedResult);
    }


    @Test
    public void should_update_bigger_grid_successfully() {
        Cell input[][] = {
                {new Cell(0), new Cell(1), new Cell(1), new Cell(0)},
                {new Cell(1), new Cell(1), new Cell(0), new Cell(0)},
                {new Cell(0), new Cell(0), new Cell(1), new Cell(1)}};
        Grid grid = new Grid(input);
        Cell output[][] = {
                {new Cell(1), new Cell(1), new Cell(1), new Cell(0)},
                {new Cell(1), new Cell(0), new Cell(0), new Cell(1)},
                {new Cell(0), new Cell(1), new Cell(1), new Cell(0)}};
        grid.nextGenerator();
        assertArrayEquals(output, grid.getGridCell());
    }


    @Test
    public void init_grid_and_cell_test() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(grid.gridCell[i][j].getStatus() +" ");
            }
            System.out.println();
        }
    }

    @Test
    public void grid_iterator_test(){
        for (int i = 0; i < 3; i++) {
            grid.nextGenerator();
            init_grid_and_cell_test();
            System.out.println("========================================");
        }
    }
}