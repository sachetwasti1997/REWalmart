package intervie_prob;

import java.util.Arrays;

public class TurnToZero {
    static int[][] mat;

    static void conv(){
        int r = mat.length, c = mat[0].length;
        int[] row = new int[r];
        int[] col = new int[c];
        Arrays.fill(row, -1);
        Arrays.fill(col, -1);
        for (int i=0; i<r; i++){
            for (int j = 0; j < c; j++){
                if (mat[i][j] == 0){
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (row[i] == 0 || col[j] == 0){
                    mat[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        mat = new int[][]{
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 0},
                {0, 0, 0, 1}
        };
        conv();
        Arrays.stream(mat).forEach(ar -> System.out.println(Arrays.toString(ar)));
    }
}
