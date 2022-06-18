package Arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TOpKElements {

    class CountStore{
        int num;
        int count;
        CountStore(int num, int count){
            this.num = num;
            this.count = count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<CountStore> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i: nums){
            if (!map.containsKey(i)){
                map.put(i, 1);
            }else{
                map.put(i, map.get(i) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> res: map.entrySet()){
            pq.add(new CountStore(res.getKey(), res.getValue()));
        }
        int[] res = new int[k];
        for (int i=0; i<k; i++){
            res[i] = pq.poll().num;
        }
        return res;
    }

}
