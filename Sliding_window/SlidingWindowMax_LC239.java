package Sliding_window;

import java.util.*;

public class SlidingWindowMax_LC239 {

    // Method to find the maximum in each sliding window of size k
    public int[] maxSlidingWindow(int[] nums, int k) {
        // If the input array is null or k is non-positive, return an empty array
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;  // Length of the input array
        int[] result = new int[n - k + 1];  // Array to store the results (max of each window)
        Deque<Integer> deque = new ArrayDeque<>();  // Double-ended queue to store indices of potential maximums

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();  // Remove the front element if it's out of the window
            }

            // Remove indices of elements smaller than the current element from the back of the deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();  // Remove smaller elements
            }

            // Add the current index to the deque
            deque.offerLast(i);

            // If we have filled a window, record the maximum value from the deque
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];  // The element at the front of the deque is the maximum
            }
        }

        // Return the result array containing the maximums of each window
        return result;
    }

    // Main method to test the maxSlidingWindow method
    public static void main(String[] args) {
        SlidingWindowMax_LC239 solution = new SlidingWindowMax_LC239();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        
        // Calling the method and storing the result
        int[] result = solution.maxSlidingWindow(nums, k);
        
        // Printing the result array
        System.out.println(Arrays.toString(result));
    }
}
