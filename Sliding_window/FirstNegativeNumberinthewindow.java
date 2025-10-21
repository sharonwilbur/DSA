package Sliding_window;

import java.util.*;

public class FirstNegativeNumberinthewindow {
    
    public static List<Integer> firstNegativeNumber(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        
        for(int i=0;i<nums.length;i++)
        {
            while(!deque.isEmpty()&&deque.peekFirst()<i-k+1)
            {
                deque.pollFirst();
            }
            if(nums[i]<0)
            {
                deque.offerLast(i);
            }
            
            if(i>=k-1)
            {
                result.add(!deque.isEmpty() ? nums[deque.peekFirst()] : 0 );
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        System.out.println(firstNegativeNumber(nums, k));  // Output: [-1, -1, -7, -15, -15]
    }
}
