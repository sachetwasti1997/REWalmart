package LinkedList;

public class ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
        if (head == null)return null;
        if (head.next == null)return head;
        ListNode prev = null, curr = head, next = head.next;
        while (next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode head = l1;
        head.next = l2;
        l2.next = l3;
        ReverseLinkedList l = new ReverseLinkedList();
        head = l.reverseList(head);
        while (head!= null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
