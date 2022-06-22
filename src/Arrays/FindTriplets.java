package Arrays;

public class FindTriplets {

    int countLarger(int[] arr, int i){
        int count = 0;
        int t = i+1;
        while (t < arr.length){
            if (arr[i] < arr[t]){
                count ++;
            }
            t++;
        }
        return count;
    }

    int smallerCount(int[] arr, int N){
        int count = 0;
        for (int i=0; i<N; i++){
            if (arr[i] < arr[N])count++;
        }
        return count;
    }

    int countTriplet(int[] arr){
        int n = 0;
        for (int i=1; i< arr.length-1; i++){
            int largerCount = countLarger(arr, i);
            int smallerCount = smallerCount(arr, i);
            n += largerCount * smallerCount;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,3};
        FindTriplets t = new FindTriplets();
        System.out.println(t.countTriplet(arr));
    }

}
