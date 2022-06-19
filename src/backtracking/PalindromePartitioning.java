package backtracking;


import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public boolean isPalindrome(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
    public void doPartition(List<List<String>> partition, List<String> tempPalindrome, int index, String s){
        if(index >= s.length()){
            partition.add(new ArrayList<>(tempPalindrome));
            return;
        }

        for(int j=index; j<s.length(); j++){
            if(isPalindrome(s, index, j)){
                tempPalindrome.add(s.substring(index, j+1));
                doPartition(partition, tempPalindrome, j+1, s);
                tempPalindrome.remove(tempPalindrome.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> resList = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        doPartition(resList, temp, 0, s);
        return resList;
    }

    public static void main(String[] args){
        PalindromePartitioning p = new PalindromePartitioning();
        System.out.println(p.partition("aab"));
    }

}
