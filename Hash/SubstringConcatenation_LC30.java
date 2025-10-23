package Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringConcatenation_LC30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result=new ArrayList<>();
        int wordLength=words[0].length();
        int wordCount=words.length;
        int subStringLength=wordCount*wordLength;
        Map<String, Integer> wordFrequency=new HashMap<>();
        for(String word:words)
        {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0)+1);
        }
        for(int i=0;i<wordLength;i++)
        {
            int left=i;
            int count=0;
            Map<String,Integer> currentFrequency=new HashMap<>();
            for(int right=left;right+wordLength<=s.length();right=right+wordLength)
            {
                String word=s.substring(right, right+wordLength);
                if(wordFrequency.containsKey(word))
                {
                    currentFrequency.put(word, currentFrequency.getOrDefault(word, 0)+1);
                    count++;
                    while(currentFrequency.get(word)>wordFrequency.get(word))
                    {
                        String leftWord=s.substring(left, left+wordLength);
                        count--;
                        currentFrequency.put(leftWord, currentFrequency.getOrDefault(leftWord, 0)-1);
                        left=left+wordLength;
                    }
                    if(count==wordCount)
                    {
                        result.add(left);
                        String leftWord=s.substring(left, left+wordLength);
                        count--;
                        currentFrequency.put(leftWord, currentFrequency.getOrDefault(leftWord, 0)-1);
                        left=left+wordLength;
                    }
                }
                else{
                    currentFrequency.clear();
                    count=0;
                    left=right+wordLength;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SubstringConcatenation_LC30 solution = new SubstringConcatenation_LC30();
        
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        
        List<Integer> indices = solution.findSubstring(s, words);
        System.out.println(indices);  // Output: [0, 9]
    }
}
