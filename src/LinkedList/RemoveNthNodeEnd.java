package LinkedList;

public class RemoveNthNodeEnd {
    static class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 1 && head.next == null){
            return null;
        }
        var temp = head;
        int count = 0;
        while (temp != null){
            temp = temp.next;
            count ++;
        }
        if (count == n){
            head = head.next;
            return head;
        }
        var fNode = head;
        for (int i= 0; i < n; i++){
            fNode = fNode.next;
        }
        ListNode ele = null;
        while (fNode != null){
            if (ele == null){
                ele = head;
            }else{
                ele = ele.next;
            }
            fNode = fNode.next;
        }
        ele.next = ele.next.next;
        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeEnd r = new RemoveNthNodeEnd();
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 2; i++){
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        System.out.println(head);
        System.out.println(r.removeNthFromEnd(head, 2));
    }
}
