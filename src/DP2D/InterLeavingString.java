package DP2D;

public class InterLeavingString {
    public boolean interleavingStrings(String s1, String s2, String s3, int i1, int i2){
        if (i1 == s1.length() && i2 == s2.length() && i1 + i2 == s3.length())return true;
        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i1+i2)
        && interleavingStrings(s1, s2, s3, i1+1, i2))return true;
        if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i1+i2)
        && interleavingStrings(s1, s2, s3, i1, i2 + 1))return true;
        return false;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        return interleavingStrings(s1, s2, s3, 0, 0);
    }

    public static void main(String[] args) {
        InterLeavingString i = new InterLeavingString();
        System.out.println(i.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
