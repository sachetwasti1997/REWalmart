package Arrays;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {

        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        int calculate = 0;

        for (int i=0; i<s.length(); i++){
            if (!charMap.containsKey(s.charAt(i))){
                charMap.put(s.charAt(i), 1);
            }else{
                charMap.put(s.charAt(i), charMap.get(s.charAt(i)) + 1);
            }
            calculate++;
        }

        for(int j = 0; j < t.length(); j++){
            if (charMap.containsKey(t.charAt(j)) && charMap.get(t.charAt(j)) > 0){
                charMap.put(t.charAt(j), charMap.get(t.charAt(j)) - 1);
                calculate --;
            }else{
                return false;
            }
        }
        return calculate == 0;
    }

    public static void main(String[] args) {
        isAnagram("anagram", "nagaram");

    }

}
