package intervie_prob;

import java.util.Stack;

public class QueToStack {
    static Stack<Integer> stk;

    static void add(int data){
        if (stk.isEmpty()){
            stk.add(data);
            return;
        }
        var temp = new Stack<Integer>();
        while (!stk.isEmpty()){
            var t = stk.pop();
            temp.add(t);
        }
        stk.add(data);
        while (!temp.isEmpty()){
            var t = temp.pop();
            stk.add(t);
        }
    }

    public static int pop(){
        if (stk.isEmpty())return -1;
        return stk.pop();
    }

    public static void main(String[] args) {
        stk = new Stack<>();
        add(1);
        add(2);
        add(3);
        add(4);
        System.out.println(pop());
        System.out.println(stk);
    }
}
