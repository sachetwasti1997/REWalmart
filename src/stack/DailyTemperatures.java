package stack;

import java.util.Stack;
import java.util.Arrays;

public class DailyTemperatures {

    static class Node{
        int val;
        int index;
        Node(int val, int index){
            this.val = val;
            this.index = index;
        }
    }
    

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Node> temp = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i=0; i<temperatures.length; i++){
            if(temp.isEmpty()){
                temp.add(new Node(temperatures[i], i));
            }else{
                while(!temp.isEmpty() && temp.peek().val < temperatures[i]){
                    var t = temp.pop();
                    res[t.index] = i - t.index;
                }
                temp.add(new Node(temperatures[i], i));
            }
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30,60,90})));
    }

}
