import java.util.Stack;

public class minStack_LC155 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** Initialize your data structure here. */
    public minStack_LC155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val){
        stack.push(val);
        if(minStack.isEmpty()||minStack.peek()>val) minStack.push(val);
    }
    public int pop(){
        int poped=stack.pop();
        if(poped==minStack.peek()) minStack.pop();
        return poped;
    }
    public int top(){
        return stack.peek();
    }
    public int getMin(){
        return minStack.peek();
    }

    public static void main(String[] args) {
        minStack_LC155 minStack = new minStack_LC155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Min element: " + minStack.getMin()); // Returns -3
        minStack.pop();
        System.out.println("Top element: " + minStack.top());    // Returns 0
        System.out.println("Min element: " + minStack.getMin()); // Returns -2
    }
}
