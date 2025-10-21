package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_LC49 {
  public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0) return new ArrayList<>();
        Map<String, List<String>> groupAnagramMap=new HashMap<>();
        for(String str:strs)
        {
          char[] arr=str.toCharArray();
          Arrays.sort(arr);
          String key=String.valueOf(arr);
          if(!groupAnagramMap.containsKey(key))
          {
            groupAnagramMap.put(key, new ArrayList<>());
          }
          groupAnagramMap.get(key).add(str);
        }

        List<List<String>> resultSet=new ArrayList<>();
        for(Map.Entry<String,List<String>> groupAnagramMapRow: groupAnagramMap.entrySet())
        {
          resultSet.add(groupAnagramMapRow.getValue());
        }
        return resultSet;
    }
    public static void main(String[] args) {
        GroupAnagrams_LC49 solution = new GroupAnagrams_LC49();
        
        // Test case 1: An array with multiple anagrams
        String[] test1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Test Case 1:");
        List<List<String>> result1 = solution.groupAnagrams(test1);
        for (List<String> group : result1) {
            System.out.println(group);
        }
        System.out.println();
      }
}
