class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class OddEvenLinkedList_LC328 {
    // Odd-Even reorder function
    public static ListNode oddEvenList(ListNode head) {
        if(head==null) return head;
        ListNode evenhead=head.next;
        ListNode odd=head;
        ListNode even=head.next;
        while(odd!=null && even!=null )
        {
            odd.next=odd.next.next;
            odd=odd.next;
            even.next=even.next.next;
            even=even.next;
        }
        odd.next=evenhead;
        return head;


    }

    // Helper: Print linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Build sample list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        head = oddEvenList(head);

        System.out.print("Odd Even List: ");
        printList(head);
    }
}
