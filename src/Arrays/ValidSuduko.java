package Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSuduko {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> col = new HashMap<>();
        Map<String, Set<Character>> grid = new HashMap<>();
        int R = board.length, C = board[0].length;
        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                if (board[i][j] != '.'){
                    if (!row.containsKey(i)){
                        row.put(i, new HashSet<>());
                    }else if(row.get(i).contains(board[i][j])){
                        return false;
                    }

                    if (!col.containsKey(j)){
                        col.put(j, new HashSet<>());
                    } else if (row.get(j).contains(board[i][j])) {
                        return false;
                    }

                    String index = (i/3)+""+(j/3);
                    if (!grid.containsKey(index)){
                        grid.put(index, new HashSet<>());
                    } else if (grid.get(index).contains(board[i][j])) {
                        return false;
                    }

                    row.get(i).add(board[i][j]);
                    col.get(j).add(board[i][j]);
                    grid.get(index).add(board[i][j]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'}
        };
    }
}
