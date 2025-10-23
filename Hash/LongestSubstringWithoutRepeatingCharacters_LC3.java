package Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_LC3 {
    public int lengthOfLongestSubstring(String s)
    {
        int maxLength=0;
        Set<Character> charSet=new HashSet<>();
        int left=0;
        for(int right=0;right<s.length();right++)
        {
            while(charSet.contains(s.charAt(right)))
            {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maxLength=Math.max(maxLength, right-left+1);
        }
        return maxLength;

    }

    // Main function to test the method
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters_LC3 solution = new LongestSubstringWithoutRepeatingCharacters_LC3();
        
        // Test case
        String s = "abcabcbb";
        System.out.println("Length of the longest substring without repeating characters: " 
                           + solution.lengthOfLongestSubstring(s));
    }
}

