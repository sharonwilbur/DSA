import java.util.Stack;

public class nextGreaterElementII_LC503 {
    public int[] nextGreaterElements(int[] nums) {
        
        int n=nums.length;
        int[] nums1=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=2*n-1;i>=0;i--)
        {
            int element=nums[i%n];
            while(!stack.isEmpty()&& element>=stack.peek())
            {
                stack.pop();
            }
            if(i<n) 
            {
                nums1[i]=stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(element);
        }
        return nums1;
    }

    public static void main(String[] args) {
        nextGreaterElementII_LC503 solver = new nextGreaterElementII_LC503();
        
        int[] nums = {1, 2, 1};
        int[] res = solver.nextGreaterElements(nums);
        
        for (int val : res) {
            System.out.print(val + " ");   // Expected: 2 -1 2
        }
    }
}
