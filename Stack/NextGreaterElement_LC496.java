import java.util.Stack;

public class NextGreaterElement_LC496 {
    public int[] nextGreaterElements(int[] nums2) {
        int[] nextGreaterElements = new int[nums2.length];
        Stack<Integer> helperStack = new Stack<>();

        // Traverse from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {
            int element = nums2[i];

            // Pop all smaller or equal elements from stack
            while (!helperStack.isEmpty() && helperStack.peek() <= element) {
                helperStack.pop();
            }

            // If empty, no greater element on right
            nextGreaterElements[i] = helperStack.isEmpty() ? -1 : helperStack.peek();

            // Push current element for next iteration's comparison
            helperStack.push(element);
        }

        return nextGreaterElements;
    }

    public static void main(String[] args) {
        NextGreaterElement_LC496 solver = new NextGreaterElement_LC496();
        int[] nums2 = {2, 1, 2, 4, 3};
        int[] result = solver.nextGreaterElements(nums2);

        for (int val : result) {
            System.out.print(val + " ");  // Expected: 4 2 4 -1 -1 
        }
    }
}
