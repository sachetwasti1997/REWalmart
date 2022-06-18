package binSearch;

/**
 * We have to search in the range of maxSpeed, find optimum speed at which speed is lowest and we are able to finish
 * all the bananas
 */
public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {
        int r = Integer.MIN_VALUE;
        for (int j : piles) {
            r = Integer.max(r, j);
        }
        int l = 0, hi = r, toth = h, res = Integer.MAX_VALUE;
        while(l <= r){
            int mid = (l+r)/2;
            toth = h;
            for (int pile : piles) {
                int hour = pile / mid;
                if (pile % mid != 0) {
                    hour += 1;
                }
                toth -= hour;
            }
            if(toth >= 0){
                res = Integer.min(res, mid);
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] piles = new int[]{3,6,7,11};
        System.out.println(minEatingSpeed(piles, 8));
    }

}
