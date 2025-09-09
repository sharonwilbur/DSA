public class LinkedListCycleDetector {

    // Node class representing each node in the linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to detect cycle using Floyd’s algorithm
    public static boolean hasCycle(Node head) {
        Node fast=head;
        Node slow=head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    //method to detect start of linked list
    public static Node startOfLinkedList(Node head){
        Node fast=head;
        Node slow=head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                slow=head;
                while(slow!=fast)
                {
                    slow=slow.next;
                    fast=fast.next;
                    if(slow==fast){
                        return fast;
                    }
                }
            }
        }
        return null;
    }
    // Main method to test the hasCycle method
    public static void main(String[] args) {
        // Create a linked list with a cycle
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next; // Creates a cycle (4 → 2)

        // Test the cycle detection
        if (hasCycle(head)) {
            System.out.println("Cycle detected in the linked list.");
            System.out.println("the start of linked list is at : "+startOfLinkedList(head).data);
        } else {
            System.out.println("No cycle in the linked list.");
            System.out.println("the start of linked list is at : ");
            
        }

        // Create a linked list without a cycle
        Node head2 = new Node(10);
        head2.next = new Node(20);
        head2.next.next = new Node(30);

        // Test again
        if (hasCycle(head2)) {
            System.out.println("Cycle detected in the second linked list.");
        } else {
            System.out.println("No cycle in the second linked list.");
        }
    }
}
