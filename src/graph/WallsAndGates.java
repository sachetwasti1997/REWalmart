package graph;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    class Pos{
        int i;
        int j;
        Pos(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public void wallsAndGates(int[][] rooms) {
        Queue<Pos> q = new LinkedList<>();
        int R = rooms.length, C = rooms[0].length;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(rooms[i][j] == 0){
                    q.add(new Pos(i, j));
                }
            }
        }
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while(!q.isEmpty()){
            var t = q.poll();
            for(int[] d: dir){
                int r = t.i + d[0], c = t.j + d[1];
                if(r >= 0 && c >= 0 && r < R && c < C && rooms[r][c] > 1 + rooms[t.i][t.j]){
                    rooms[r][c] = 1 + rooms[t.i][t.j];
                    q.add(new Pos(r, c));
                }
            }
        }
    }
}
