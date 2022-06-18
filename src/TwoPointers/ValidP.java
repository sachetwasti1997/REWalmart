package TwoPointers;

public class ValidP {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char t = s.charAt(i);
            if((t >= 'a' && t <= 'z') || (t >= '0' && t <= '9')){
                sb.append(t);
            }
        }
        int i = 0, j = sb.length() - 1;
        s = sb.toString();
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
