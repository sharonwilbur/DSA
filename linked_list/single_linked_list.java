class node{
    int data;
    node next;

    node(int data){
        this.data=data;
        this.next=null;
    }
}

class single_linked_list{
    node head;

    void insertion_at_beginning(int data)
    {
        node newNode=new node(data);
        newNode.next=head;
        head=newNode;
    }

    void insertion_at_end(int data)
    {
        node newNode=new node(data);
        if(head==null)
        {
            head=newNode;
        }
        node current=head;
        while(current.next!=null)
        {
            current=current.next;
        }
        current.next=newNode;
    }

    void deleteByValue(int data){
        if(data==head.data)
        {
            System.out.println(head.data);
            return;
        }
        node current=head;
        node prev=null;
        while(current!=null&&current.data!=data)
        {
            prev=current;
            current=current.next;
        }

        if(current==null)
        {
            return;
        }
        prev.next=current.next;
    }

    boolean search(int data){
        node current=head;
        while(current!=null)
        {
            if(current.data==data)
            {
                return true;
            }
            current=current.next;
        }
        return false;
    }

    void reverse(){
        node previous=null;
        node current=head;
        node next=null;
        while(current!=null)
        {
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }

        head=previous;
    } 
    
    boolean hasCycle(){
        node hare=head;
        node tortoise=head;

        while(hare!=null&&hare.next!=null)
        {
            hare=hare.next.next;
            tortoise=tortoise.next;
            if(hare==tortoise)
            {
                return true;
            }
            
        }
        return false;
    }
    public static void main(String [] args)
    {
        single_linked_list list= new single_linked_list();
        list.head=new node(1);
        node second=new node(2);
        node third=new node(3);
        node fourth=new node(4);

        list.head.next=second;
        second.next=third;
        third.next=fourth;
        list.print();

        list.insertion_at_beginning(0);
        list.print();

        list.insertion_at_end(5);
        list.print();

        System.out.println("is 3 present : "+list.search(3));

        list.deleteByValue(3);
        list.print();

        System.out.println("is 3 present : "+list.search(3));;

        list.reverse();
        list.print();

        System.out.println(list.hasCycle());
    }

    void print(){
        node current=head;

        while(current!=null)
        {
            System.out.println(current.data);
            current=current.next;
        }
        System.out.println("--------------------------");//to seperate each operation
    }
}