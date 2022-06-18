package Heap;

import java.util.PriorityQueue;

public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.add(stone);
        }
        while(!pq.isEmpty() && pq.size() >= 2){
            int m1 = pq.remove();
            int m2 = pq.remove();
            if(m1 != m2){
                pq.add(m1 - m2);
            }
        }
        return pq.isEmpty()? 0: pq.peek();
    }

    public static void main(String[] args){
        int[] arr = {1};
        System.out.println(lastStoneWeight(arr));
    }

}
