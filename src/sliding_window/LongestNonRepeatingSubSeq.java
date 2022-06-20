package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingSubSeq {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>(s.length());
        int start = 0, end = 0, maxLength = 1;
        while(start < s.length() && end < s.length()){
            if (!map.containsKey(s.charAt(end))){
                map.put(s.charAt(end), end);
            }else{
                if(start <= map.get(s.charAt(end))) start = map.get(s.charAt(end)) + 1;
                map.put(s.charAt(end), end);
            }
            maxLength = Integer.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestNonRepeatingSubSeq l = new LongestNonRepeatingSubSeq();
        System.out.println(l.lengthOfLongestSubstring("bbbb"));
    }
}
