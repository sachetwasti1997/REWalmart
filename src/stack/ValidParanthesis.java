package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {
    public static boolean isValid(String s) {
        Map<Character, Character> paranthesis = new HashMap<>(3);
        paranthesis.put(')', '(');
        paranthesis.put('}', '{');
        paranthesis.put(']', '[');
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(!paranthesis.containsKey(s.charAt(i))){
                stk.add(s.charAt(i));
            }else if(!stk.isEmpty()){
                char temp = stk.pop();
                if(temp != paranthesis.get(s.charAt(i))){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isValid(")[]{}"));
    }
}
