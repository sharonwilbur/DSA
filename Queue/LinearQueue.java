package Queue;

import java.util.NoSuchElementException;

public class LinearQueue {
    private int front, rear;
    private int[] queue;
    public LinearQueue(int size)
    {
        front=rear=-1;
        this.queue=new int[size];
    }

    public void enqueue(int value)
    {
        if(isFull())
            return ;
        if(isEmpty())
            front++;
        queue[++rear]=value;
    }

    public int dequeue(){
        if(isEmpty())
            throw new NoSuchElementException();
        int temp=queue[front];
        front=front+1;
        if(front>rear)
            front=rear=-1;
        return temp;
    }
    public int peek(){
        return queue[front];
    }

    public boolean isFull(){
        return rear==queue.length-1;
    }

    public boolean isEmpty(){
        if(front==-1||front>rear)
            return true;
        else 
            return false;
    }

    // Display the queue
    public void display() 
    {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the queue
    public static void main(String[] args) {
        LinearQueue q = new LinearQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60); // Will not be added
      
        q.display();

        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Front element: " + q.peek());

        q.display();
    }
}
