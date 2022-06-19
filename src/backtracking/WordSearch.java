package backtracking;

public class WordSearch {

    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public boolean dfsExist(char[][] board, String word, int index, int i, int j){
        int R = board.length, C = board[0].length;
        if(index >= word.length()){
            return true;
        }
        if(i < 0 || j < 0 || i >= R || j >= C || board[i][j] != word.charAt(index)){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = false;
        for(int[] d: dir){
            found = found || dfsExist(board, word, index+1, i+d[0], j+d[1]);
        }
        board[i][j] = temp;
        return found;
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0) && dfsExist(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[]args){
        char[][] grid = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        WordSearch w = new WordSearch();
        System.out.println(w.exist(grid, "SEE"));
    }
}
