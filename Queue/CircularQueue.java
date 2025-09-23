package Queue;

import java.util.NoSuchElementException;

public class CircularQueue {
    int front, rear;
    int [] nums;

    CircularQueue(int size)
    {
        this.front=this.rear=size;
        this.nums=new int[size];
    }

    public void enqueue(int value){
        if(isFull()) resize();
        else if(isEmpty()) front++;
        rear=(rear+1)%nums.length;
        nums[rear]=value;
    }

    public int dequeue(){
        if(isEmpty()) throw new NoSuchElementException();
        int temp = front;
        if(front==rear) front=rear=-1;
        else front++;
        return temp;
    }

    public int peek(){
        return nums[front];
    }

    public boolean isEmpty(){
        return front==-1;
    }

    public boolean isFull(){
        return (rear+1)%nums.length==front;
    }

    public void resize(){
        int[] tempArr=new int[nums.length*2];
        int i=0;
        int j=front;
        do {
            tempArr[i]=nums[j];
            i++;
            j=(j+1)%nums.length;
        } while (j!=front);

        front=0;
        rear=(rear+1)%nums.length;
        nums= tempArr;
    }
}
