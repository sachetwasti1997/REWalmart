package intervie_prob;

import java.util.LinkedList;
import java.util.Queue;

public class StakToQue {

    static Queue<Integer> que;

    public void add(int data){
        que.add(data);
        if (que.size() == 1){
            return;
        }
        while (que.peek() != data){
            var t = que.remove();
            que.add(t);
        }
    }

    public int pop(){
        if (que.isEmpty())return -1;
        return que.remove();
    }

    public static void main(String[] args) {
        que = new LinkedList<>();
        StakToQue s = new StakToQue();
        s.add(1);
        s.add(2);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(que);
    }

}
