package intervie_prob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeSortedIntervals {

    static class Intr{
        int i;
        int j;
        Intr(int i, int j){
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Intr{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

    public static int[][] merge(int[][] intervals) {
        Intr[] intrs = new Intr[intervals.length];
        int k = 0;
        for (int[] i : intervals){
            intrs[k] = new Intr(i[0], i[1]);
            k++;
        }
        Arrays.sort(intrs, (a,b) -> a.i - b.i);
        System.out.println(Arrays.toString(intrs));
        return new int[][]{};
    }

    public static void mergeIntervals(Intr[] intrs){
        Arrays.sort(intrs, Comparator.comparingInt(a -> a.i));
        var res = intrs[0];
        var result = new ArrayList<Intr>();
        for (int i = 1; i <intrs.length; i++){
            if (res.j >= intrs[i].i && res.j <= intrs[i].j){
                res.i = Integer.min(intrs[i].i, res.i);
                res.j = Integer.max(intrs[i].j, res.j);
            }else{
                result.add(res);
                res = intrs[i];
            }
        }
        result.add(res);
        System.out.println(result);
    }

    public static void main(String[] args) {
        int[][] intrs = {{2,6},{1,3},{8,10},{15,18}};
        merge(intrs);
    }

}
