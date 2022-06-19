package graph;

import java.util.*;

public class NumberIslands {

    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public void doDfs(char[][] grid, int i, int j){
        int R = grid.length, C = grid[0].length;
        if(i < 0 || j < 0 || i >= R || j >= C || grid[i][j] != '1')return;
        grid[i][j] = '0';
        for(int[] d: dir){
            doDfs(grid, i+d[0], j+d[1]);
        }
    }

    public int numIslands(char[][] grid) {
        int noOfIslands = 0;
        for(int i=0; i<grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    noOfIslands++;
                    doDfs(grid, i, j);
                }
            }
        }
        Arrays.stream(grid).forEach(ar -> System.out.println(Arrays.toString(ar)));
        return noOfIslands;
    }

    public static void main(String[] args){
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        NumberIslands n = new NumberIslands();
        System.out.println(n.numIslands(grid));
    }

}
