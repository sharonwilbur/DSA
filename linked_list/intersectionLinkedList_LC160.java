class ListNode
{
    int value;
    ListNode next;
    ListNode(int x)
    {
        value=x;
        next=null;
    }
}

public class intersectionLinkedList_LC160
{

    public static ListNode getIntersection(ListNode headA, ListNode headB)
    {
        if (headA==null||headB==null) return null;

        ListNode A=headA;
        ListNode B=headB;
        while(A!=B)
        {
            if(A!=null) A=A.next;
            else A=headB;

            if(B!=null) B=B.next;
            else B=headA;

        }
        return A;
    }
    public static void main(String[] args)
    {
        ListNode headA=new ListNode(1);
        headA.next=new ListNode(2);
        headA.next.next=new ListNode(3);
        headA.next.next.next=new ListNode(4);
        headA.next.next.next.next=new ListNode(5);

        ListNode headB=new ListNode(9);
        headB.next=headA.next.next.next;

        ListNode intersection=getIntersection(headA, headB);
        System.out.println("intersecting node : "+intersection.value);

    }
}