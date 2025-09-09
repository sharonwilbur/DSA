
// ***************************************

// this works in online compiler

// ****************************************


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Main {

    // Main sort function
    public static ListNode sortList(ListNode head) {
        // Base case
        if (head == null || head.next == null) return head;

        // Step 1: Split the list into two halves
        ListNode mid = getMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null; // Break the list

        // Step 2: Sort recursively
        ListNode leftSorted = sortList(left);
        ListNode rightSorted = sortList(right);

        // Step 3: Merge sorted halves
        return merge(leftSorted, rightSorted);
    }

    // Helper to find midpoint (slow-fast pointers)
    private static ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper to merge two sorted lists
    private static ListNode merge(ListNode left, ListNode right) {
        ListNode merged=new ListNode(0);
        ListNode current_node=merged;

        while(left!=null && right!=null)
        {
            if(left.val<right.val)
            {
                current_node.next=left;
                left=left.next;
            }
            else
            {
                current_node.next=right;
                right=right.next;
            }
            current_node=current_node.next;
        }
        if(left!=null) current_node.next=left;
        else current_node.next=right;

        return merged.next;
    }

    // Utility to print a list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Sample list: 9 -> 8 -> 5 -> 2
        ListNode head = new ListNode(9);
        head.next = new ListNode(8);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(2);

        System.out.print("Original List: ");
        printList(head);

        head = sortList(head);

        System.out.print("Sorted List: ");
        printList(head);
    }
}
