package graph;

import java.util.*;

public class MaxAreaIsland {
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int maxArea(int[][] grid, int i, int j){
        int R = grid.length, C = grid[0].length;
        if(i < 0 || j < 0 || i >= R || j >= C || grid[i][j] != 1)return 0;
        int max = 1;
        grid[i][j] = 0;
        for(int[] d: dir){
            max += maxArea(grid, i+d[0], j+d[1]);
        }
        return max;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1)max = Integer.max(max, maxArea(grid, i, j));
            }
        }
        return max == Integer.MIN_VALUE?0:max;
    }
    public static void main(String[] args){
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        MaxAreaIsland m = new MaxAreaIsland();

        System.out.println(m.maxAreaOfIsland(grid));
        Arrays.stream(grid).forEach(ar -> System.out.println(Arrays.toString(ar)));
    }
}
