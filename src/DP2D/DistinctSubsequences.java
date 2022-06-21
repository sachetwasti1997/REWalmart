package DP2D;

public class DistinctSubsequences {
    public int findDistinctSeq(String s, String t, int i, int j){
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;
        if (s.charAt(i) == t.charAt(j)){
            return findDistinctSeq(s, t, i+1, j) + findDistinctSeq(s, t, i+1, j+1);
        }else{
            return findDistinctSeq(s, t, i+1, j);
        }
    }
    public int numDistinct(String s, String t) {
        System.out.println(findDistinctSeq(s, t, 0, 0));
        return findDistinctSeq(s, t, 0, 0);
    }

    public static void main(String[] args) {
        DistinctSubsequences d = new DistinctSubsequences();
        System.out.println(d.numDistinct("babgbag", "bag"));
    }
}
