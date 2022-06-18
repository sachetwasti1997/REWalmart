package stack;

import java.util.Stack;

public class MinStack {

    class Node{
        int min;
        int val;
        Node(int min, int val){
            this.min = min;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "min=" + min +
                    ", val=" + val +
                    '}';
        }
    }

    Stack<Node> stk;

    public MinStack() {
        stk = new Stack<>();
    }

    public void push(int val) {
        if(stk.isEmpty()){
            stk.add(new Node(val, val));
        }else{
            int min = Integer.min(val, stk.peek().min);
            stk.add(new Node(min, val));
        }
    }

    public void pop() {
        stk.pop();
    }

    public int top() {
        if(stk.isEmpty()){
            return -1;
        }
        return stk.peek().val;
    }

    public int getMin() {
        if(stk.isEmpty()){
            return -1;
        }
        return stk.peek().min;
    }

    public static void main(String[] args){
        MinStack m = new MinStack();
        m.push(-2);
        m.push(0);
        m.push(-3);
        System.out.println(m.stk);
    }

}
