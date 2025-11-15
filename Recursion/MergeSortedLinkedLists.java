package Recursion;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MergeSortedLinkedLists {
    // Recursive merge function
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Base cases: any list is null
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // Recursively merge and assign next pointers
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // Helper to print list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        // First sorted list: 1 → 2 → 4
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(22);

        // Second sorted list: 1 → 3 → 4
        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(11);
        l2.next.next = new ListNode(16);

        MergeSortedLinkedLists merger = new MergeSortedLinkedLists();
        ListNode merged = merger.mergeTwoLists(l1, l2);

        System.out.print("Merged List: ");
        merger.printList(merged);
        // Output: Merged List: 1 1 2 3 4 4
    }
}

