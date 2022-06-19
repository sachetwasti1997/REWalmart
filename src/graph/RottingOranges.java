package graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    class PosTime{
        int i;
        int j;
        int time;
        PosTime(int i, int j, int time){
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    public int findByBfs(int[][] grid){
        Queue<PosTime> que = new LinkedList<>();
        int R = grid.length, C = grid[0].length, oneCount = 0;
        for(int i=0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(grid[i][j] == 2){
                    que.add(new PosTime(i, j, 0));
                }else if(grid[i][j] == 1){
                    oneCount++;
                }
            }
        }
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int maxTime = Integer.MIN_VALUE;
        while(!que.isEmpty()){
            var t = que.poll();
            for(int[] d: dir){
                int r = t.i + d[0], c = t.j + d[1];
                if(r >= 0 && c >= 0 && r < R && c < C && grid[r][c] == 1){
                    grid[r][c] = 0;
                    maxTime = Integer.max(maxTime, t.time+1);
                    que.add(new PosTime(r, c, t.time + 1));
                    oneCount--;
                }
            }
        }
        return oneCount == 0? maxTime: -1;
    }

    public int orangesRotting(int[][] grid) {
        return findByBfs(grid);
    }

    public static void main(String[] args){
        int[][] grid = {
                {2,1,1},
                {0,1,1},
                {1,0,1}
        };
        RottingOranges r = new RottingOranges();
        int t = r.orangesRotting(grid);
        System.out.println(t);
    }

}
