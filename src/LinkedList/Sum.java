package LinkedList;

public class Sum {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)return l2;
        if (l2 == null)return l1;
        int carry = 0;
        ListNode head = null, temp = null;
        while (l1 != null && l2 != null){
            int sum = carry + l1.val + l2.val;
            carry = sum / 10;
            int node = sum % 10;
            if (head == null){
                head = new ListNode(node);
                temp = head;
            }else{
                temp.next = new ListNode(node);
                temp = temp.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            int sum = carry + l1.val;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2 != null){
            int sum = carry + l2.val;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            l2 = l2.next;
        }
        return head;
    }

}
