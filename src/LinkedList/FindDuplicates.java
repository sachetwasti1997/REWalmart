package LinkedList;

public class FindDuplicates {

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast)break;
        }
        int slow2 = 0;
        while (slow != slow2){
            slow2 = nums[slow2];
            slow = nums[slow];
            if (slow == slow2)break;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] t = {1,3,4,2,2};
        FindDuplicates f = new FindDuplicates();
        System.out.println(f.findDuplicate(t));
    }

}
