public class stackArrays
{
    private int maxSize;
    private int[] stackArray;
    private int top;

    public stackArrays(int size)
    {
        maxSize=size;
        stackArray=new int[maxSize];
        top=-1;
    }

    public void push(int val)
    {
        if(isFull()) 
        {
            System.out.println("stack is full");
            return;
        }
        stackArray[++top]=val;
    }

    public int pop(){
        if(isEmpty())
        {
            System.out.println("its is empty");
            return -1;
        }
        return stackArray[top--];
    }
    public boolean isFull(){
        return (top==maxSize-1);
    }
    public boolean isEmpty(){
        return(top==-1);
    }

    public static void main(String [] args)
    {
        stackArrays stack=new stackArrays(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
                System.out.println(stack.pop()); // prints 5
        System.out.println(stack.pop()); // prints 4
        System.out.println(stack.pop()); // prints 3
        System.out.println(stack.pop()); // prints 2
        System.out.println(stack.pop()); // prints 1

        // Try one more pop to show "its is empty"
        System.out.println(stack.pop()); // prints message and -1
    }

}