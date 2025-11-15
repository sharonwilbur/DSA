class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class PalindromeLinkedList_LC234 {
    // Main palindrome check
    public static boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        ListNode left=head;
        ListNode mid=getMid(head);
        ListNode right=mid.next;
        mid.next=null;
        ListNode left1=reverse(right);
        while(left!=null&&left1!=null)
        {
            if(left.val!=left1.val) return false;
            left=left.next;
            left1=left1.next;
        }
        return true;
    }

    public static ListNode getMid(ListNode head)
    {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head)
    {
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null)
        {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    

    // Helper: Print list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Helper: Build list from array
    public static ListNode buildList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode curr = head;
        for (int i = 1; i < values.length; i++) {
            curr.next = new ListNode(values[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] vals1 = {1, 2, 2, 1};
        int[] vals2 = {1, 2, 3, 2, 1};
        int[] vals3 = {1, 2, 3, 4};

        ListNode head1 = buildList(vals1);
        ListNode head2 = buildList(vals2);
        ListNode head3 = buildList(vals3);

        System.out.print("List 1: ");
        printList(head1);
        System.out.println("Is palindrome: " + isPalindrome(head1));

        System.out.print("List 2: ");
        printList(head2);
        System.out.println("Is palindrome: " + isPalindrome(head2));

        System.out.print("List 3: ");
        printList(head3);
        System.out.println("Is palindrome: " + isPalindrome(head3));
    }
}
