package intervie_prob;

public class OptimalGameStrategy {

    public static int findOptimalStrategy(int[] arr, int i, int j, int sum){
        if (i+1 == j)return Integer.max(arr[i], arr[j]);
        return Integer.max(sum - findOptimalStrategy(arr, i+1, j, sum-arr[i]),
                sum - findOptimalStrategy(arr, i, j-1, sum - arr[j]));
    }

    public static void main(String[] args) {
        int[] arr = {20, 5, 4, 6};
        int sum = 0;
        for (int i: arr)sum += i;
        System.out.println(findOptimalStrategy(arr, 0, arr.length - 1, sum));
    }

}
