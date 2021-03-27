package com.algorithms.graph;

/*

In MS-Paint, when we take the brush to a pixel and click, the color of the region of that pixel is
 replaced with a new selected color. Following is the problem statement to do this task.
Given a 2D screen, location of a pixel in the screen and a color, replace color of the given pixel
and all adjacent same colored pixels with the given color.

Ex.
screen[M][N] ={{1, 1, 1, 1, 1, 1, 1, 2},
               {1, 1, 1, 1, 1, 1, 0, 0},
               {1, 0, 0, 1, 1, 0, 1, 1},
               {1, 2, 2, 2, 2, 0, 1, 0},
               {1, 1, 1, 2, 2, 0, 1, 0},
               {1, 1, 1, 2, 2, 2, 2, 0},
               {1, 1, 1, 1, 1, 2, 1, 1},
               {1, 1, 1, 1, 1, 2, 2, 1},
               };
    x = 4, y = 4, newColor = 3

output:
screen[M][N] ={{1, 1, 1, 1, 1, 1, 1, 2},
               {1, 1, 1, 1, 1, 1, 0, 0},
               {1, 0, 0, 1, 1, 0, 1, 1},
               {1, 3, 3, 3, 3, 0, 1, 0},
               {1, 1, 1, 3, 3, 0, 1, 0},
               {1, 1, 1, 3, 3, 3, 3, 0},
               {1, 1, 1, 1, 1, 3, 1, 1},
               {1, 1, 1, 1, 1, 3, 3, 1},
               };
 */

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    private class Cell{
        Cell(int x,int y){
            this.x=x;
            this.y=y;
        }
        int x,y;
    }
    public int[][] floodFill(int screen[][], int x, int y, int newColor){
        Queue<Cell> queue = new LinkedList<>();
        int prevColor = screen[x][y];
        queue.offer(new Cell(x,y));

        screen[x][y]=newColor;
        while(!queue.isEmpty()){
            Cell cell = queue.poll();

            if(isValid(screen.length,screen[0].length,cell.x+1,cell.y) && screen[cell.x+1][cell.y]==prevColor){
                queue.offer(new Cell(cell.x+1,cell.y));
                screen[cell.x+1][cell.y]=newColor;
            }

            if(isValid(screen.length,screen[0].length,cell.x-1,cell.y) && screen[cell.x-1][cell.y]==prevColor){
                queue.offer(new Cell(cell.x-1,cell.y));
                screen[cell.x-1][cell.y]=newColor;
            }

            if(isValid(screen.length,screen[0].length,cell.x,cell.y+1) && screen[cell.x][cell.y+1]==prevColor){
                queue.offer(new Cell(cell.x,cell.y+1));
                screen[cell.x][cell.y+1]=newColor;
            }

            if(isValid(screen.length,screen[0].length,cell.x,cell.y-1) && screen[cell.x][cell.y-1]==prevColor){
                queue.offer(new Cell(cell.x,cell.y-1));
                screen[cell.x][cell.y-1]=newColor;
            }
        }
        return screen;
    }

    private boolean isValid(int length, int length1, int x, int y) {
        return (x>=0 && x<length) && (y>=0 && y<length1);
    }

    public static void main(String[] args) {
        int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 2},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };
        int x = 4, y = 4, newC = 3;
        FloodFill floodFill = new FloodFill();
        screen = floodFill.floodFill(screen, x, y, newC);

        System.out.println("Updated screen after call to floodFill: ");
        for (int i = 0; i < screen.length; i++)
        {
            for (int j = 0; j < screen[i].length; j++)
                System.out.print(screen[i][j] + " ");
            System.out.println();
        }
    }
}
