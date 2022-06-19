package DP2D;

public class LongestCommonSubSequence {
    public static int findLCS(String a, String b, int i, int j){
        if(i == a.length() || j == b.length()){
            return 0;
        }
        if(a.charAt(i) == b.charAt(j)){
            return 1 + findLCS(a, b, i+1, j+1);
        }
        return Integer.max(findLCS(a, b, i+1, j), findLCS(a, b, i, j+1));
    }
    public static int longestCommonSubsequence() {
        return findLCS("abcde", "ace", 0, 0);
    }
    public static void main(String[] ags){
        System.out.println(longestCommonSubsequence());
    }
}
