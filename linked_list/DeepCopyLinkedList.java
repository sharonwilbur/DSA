

class Node {
    int val;
    Node next;
    Node random;
    Node(int val) { this.val = val; }
}

public class DeepCopyLinkedList
 {
    // Function to deep copy the list
    public static Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Interlink copied nodes
        Node curr=head;
        while(curr!=null)
        {
            Node newNode=new Node(curr.val);
            newNode.next=curr.next;
            curr.next=newNode;
            curr=newNode.next;
        }


        // Step 2: Set random pointers for copied nodes
        curr=head;
        while(curr!=null)
        {
            if(curr.random!=null)
            {
                curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }

        // Step 3: Separate copied list
        curr= head;
        Node copiedList=head.next;
        Node newCurr=copiedList;
        while(curr!=null)
        {
            curr.next=newCurr.next;
            curr=curr.next;
            if(curr!=null)
            {
                newCurr.next=curr.next;
                newCurr=newCurr.next;
            }
        }
        return copiedList;
    }

    // Helper function to print the list with random pointers
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            int randomVal = curr.random != null ? curr.random.val : -1;
            System.out.println("Node " + curr.val + " | Random -> " + randomVal);
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create nodes
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        // Setup next pointers
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        // Setup random pointers
        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;
        

// [7]   -> [13] -> [11] -> [10] -> [1] -> null
//  |        |       |       |      |
// null      7       1      11      7

        System.out.println("Original list:");
        printList(n1);

        Node copied = copyRandomList(n1);

        System.out.println("Copied list:");
        printList(copied);
    }
}
