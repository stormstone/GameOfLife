package com.tw;

public class Game {
    public static void main(String[] args) throws InterruptedException {
        int h = 10;
        int w = 10;
        int sleeptime = 1000;
        if (args.length == 3) {
            h = Integer.parseInt(args[0]);
            w = Integer.parseInt(args[1]);
            sleeptime = Integer.parseInt(args[2]);
        }
        Grid grid = new Grid(h, w);
        while (true) {
            System.out.print(grid);
            grid.nextGenerator();
            Thread.sleep(sleeptime);
        }
    }
}
