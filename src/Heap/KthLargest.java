package Heap;

import java.util.PriorityQueue;

public class KthLargest {

    int k;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>(nums.length);
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }
        while(pq.size() > k){
            pq.remove();
        }
    }

    public int add(int val) {
        pq.add(val);
        while(pq.size() > k){
            pq.remove();
        }
        return pq.peek();
    }

}
