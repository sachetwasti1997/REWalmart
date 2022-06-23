package intervie_prob;

public class ReorderList {
     static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

         @Override
         public String toString() {
             return "ListNode{" +
                     "val=" + val +
                     ", next=" + next +
                     '}';
         }
     }

  public static ListNode reverse(ListNode head){
         if (head.next == null)return head;
     ListNode prev = null, current = head, next = head.next;
     while (next != null){
         current.next = prev;
         prev = current;
         current = next;
         next = next.next;
     }
     current.next = prev;
     return current;
  }

  public static void reorderList(ListNode head) {
         if (head == null || head.next == null){
             return;
         }
         ListNode prev = null;
         ListNode fast = head;
         ListNode slow = head;

         while (fast != null && fast.next != null){
             prev = slow;
             slow = slow.next;
             fast = fast.next.next;
         }

         prev.next = null;
         slow = reverse(slow);
         ListNode tail = head;
         ListNode l1 = head.next;
         ListNode l2 = slow;
         boolean isHead = false;
         while (l1 != null && l2 != null){
             if (isHead){
                 isHead = false;
                 tail.next = l1;
                 l1 = l1.next;
                 tail = tail.next;
             }else{
                 isHead = true;
                 tail.next = l2;
                 l2 = l2.next;
                 tail = tail.next;
             }
         }
         while (l1 != null){
             tail.next = l1;
             tail = tail.next;
             l1 = l1.next;
         }
         while (l2 != null){
             tail.next = l2;
             tail = tail.next;
             l2 = l2.next;
         }
     }

    public static void main(String[] args) {
         ListNode l1 = new ListNode(1);
         ListNode l2 = new ListNode(2);
         ListNode l3 = new ListNode(3);
         ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

         l1.next = l2;
         l2.next = l3;
         l3.next = l4;
         l4.next = l5;

        reorderList(l1);
    }

}
