import java.util.Stack;

public class LargestRectangleinHistogram_LC84 {
  public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        // Iterate through the histogram
        for (int i = 0; i <= n; i++) {
            // Set currentHeight to 0 when i is equal to n to finalize the remaining calculations
            int currentHeight = (i == n) ? 0 : heights[i];
            
            // Calculate the area of the rectangle when we encounter a smaller height
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()]; // Get the height of the rectangle
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // Calculate the width
                maxArea = Math.max(maxArea, height * width); // Update the max area if necessary
            }
            // Push the index of the current height to the stack
            stack.push(i);
        }
        
        return maxArea; // Return the largest area found
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        LargestRectangleinHistogram_LC84 solution = new LargestRectangleinHistogram_LC84();
        int[] heights = {2, 1, 5, 6, 2, 3};
        
        // Print the largest rectangle area in the histogram
        System.out.println("Largest Rectangle Area: " + solution.largestRectangleArea(heights)); 
        // Expected Output: 10
    }
}

//  we use :
//              int height=heights[stack.pop()];
//              int width=stack.isEmpty()? i:i-stack.peek()-1;
// instead of :
//             int height=heights[stack.peek()];
//             int width=stack.isEmpty()? i:i-stack.pop();
// because when calculating width we should consider the area behind the height popped by the stack also.