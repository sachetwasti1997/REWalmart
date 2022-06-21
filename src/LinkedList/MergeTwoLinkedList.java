package LinkedList;

public class MergeTwoLinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)return list2;
        if (list2 == null)return list1;
        ListNode head = null, curr = null;
        while (list1 != null && list2 != null){
            if (list1.val > list2.val){
                if (head == null){
                    head = new ListNode(list2.val);
                    list2 = list2.next;
                    curr = head;
                    continue;
                }
                curr.next = new ListNode(list2.val);
                list2 = list2.next;
                curr = curr.next;
            }
            else{
                if (head == null){
                    head = new ListNode(list1.val);
                    list1 = list1.next;
                    curr = head;
                    continue;
                }
                curr.next = new ListNode(list1.val);
                list1 = list1.next;
                curr = curr.next;
            }
        }
        while (list1 != null){
            if (head == null){
                head = new ListNode(list2.val);
                list1 = list1.next;
                curr = head;
                continue;
            }
            curr.next = new ListNode(list1.val);
            list1 = list1.next;
            curr = curr.next;
        }
        while (list2 != null){
            if (head == null){
                head = new ListNode(list2.val);
                list2 = list2.next;
                curr = head;
                continue;
            }
            curr.next = new ListNode(list2.val);
            list2 = list2.next;
            curr = curr.next;
        }
        return head;
    }
}
