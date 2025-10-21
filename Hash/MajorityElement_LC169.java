package Hash;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_LC169 {
  public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=nums.length/2;
        for(int num:nums)
        {
          map.put(num,map.getOrDefault(num, 0)+1);
          if(map.get(num)>n);{
            return num;
          }
        }
        return -1;
    }

    public int majorityElement_BoyerMooreVotingAlgorithm(int[] nums){
      int count=0;
      int candidate=0;
      for(int num:nums)
      {
        if(count==0) candidate=num;
        if(num==candidate)
        {
          count=count+1;
        }
        else{
          count=count-1;
        }
      }
      return candidate;
    }

    public static void main(String[] args) {
        MajorityElement_LC169 obj = new MajorityElement_LC169();
        int[] nums = {3, 3, 4, 2, 3, 3, 3};
        System.out.println(obj.majorityElement(nums));  // Output: 3
        System.out.println(obj.majorityElement_BoyerMooreVotingAlgorithm(nums));  // Output: 3
    }

}
