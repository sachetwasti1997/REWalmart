package Arrays;

public class FindPivotRotatedSortedArr {
    int findPivot(int[] arr){
        int l = 0, r = arr.length-1;
        int res = Integer.MAX_VALUE;
        while (l < r){
            if (arr[l] < arr[r]){
                res = Integer.min(res, arr[l]);
                break;
            }
            int mid = (l+r)/2;
            res = Integer.min(res, arr[mid]);
            if (arr[mid] >= arr[l]){
                l = mid+1;
            }else{
                r = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindPivotRotatedSortedArr f = new FindPivotRotatedSortedArr();
        System.out.println(f.findPivot(new int[]{3, 4, 1, 2}));
    }
}
