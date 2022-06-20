package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharRep {
    public int characterReplacement(String s, int k) {
        int start = 0, end = 0, maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> count = new HashMap<>(s.length());
        while(start < s.length() && end < s.length()){
            if (!count.containsKey(s.charAt(end))){
                count.put(s.charAt(end), 1);
            }else{
                count.put(s.charAt(end), count.get(s.charAt(end)) + 1);
            }
            int max = 0;
            for (Map.Entry<Character, Integer>mp: count.entrySet()){
                max = Integer.max(max, mp.getValue());
            }
            if (end - start + 1 - max > k){
                count.put(s.charAt(start), count.get(s.charAt(start)) - 1);
                start++;
            }
            maxLength = Integer.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }
    public static void main(String[] args) {
        LongestRepeatingCharRep l = new LongestRepeatingCharRep();
        System.out.println(l.characterReplacement("AABABBA", 1));
    }
}
