package Arrays;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {

    // Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append("$");
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        int i = 0;
        List<String> resList = new ArrayList<>();
        while (i < s.length()){
            StringBuilder num = new StringBuilder();
            while (s.charAt(i) != '$'){
                num.append(s.charAt(i++));
            }
            int it = Integer.parseInt(num.toString());
            String res = s.substring(i+1, it+i+1);
            resList.add(res);
            i = it + i + 1;
        }
        return resList;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        list.add("");
        //["63/Rc","h","BmI3FS~J9#vmk","7uBZ?7*/","24h+X","O "]
        list.add("63/Rc");
        list.add("h");
        list.add("BmI3FS~J9#vmk");
        list.add("7uBZ?7*/");
        list.add("24h+X");
        list.add("O ");
//        list.add("Hello");
//        list.add("World");
        System.out.println(list);
        String enc = encode(list);
        System.out.println(enc);
        var res = decode(enc);
        System.out.println(res);
    }

}
