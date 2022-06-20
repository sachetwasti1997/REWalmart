package sliding_window;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, maxArea = 0;
        while (i <= j){
            maxArea = Integer.max(maxArea, (j-i) * Integer.min(height[i], height[j]));
            if (height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int [] arr = {1,1};
        ContainerWithMostWater c = new ContainerWithMostWater();
        System.out.println(c.maxArea(arr));
    }

}
