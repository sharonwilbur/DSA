package Recursion;

class Node {
    int val;
    Node next;
    
    Node(int val) { this.val = val; }
}

public class LinkedList_Recursion {

  public static Node reverseList(Node head)
  {
    if(head==null|| head.next==null)
    {
      return head;
    }
    Node p=reverseList(head.next);
    head.next.next=head;
    head.next=null;
    return p;
  }
  public static void main(String [] args)
  {
    Node n1=new Node(1);
    Node n2=new Node(2);
    Node n3=new Node(3);
    Node n4=new Node(4);
    
    n1.next=n2;
    n2.next=n3;
    n3.next=n4;

    
    print(reverseList(n1));

  }
  public static void print(Node head){
        Node current=head;

        while(current!=null)
        {
            System.out.println(current.val);
            current=current.next;
        }
        System.out.println("--------------------------");//to seperate each operation
    }
}
