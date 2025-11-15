package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_LC39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> result= new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int [] candidates, int target, int start, List<Integer> tempList, List<List<Integer>> result)
    {
        if(target<0)
        {
            return;
        }
        else if(target==0)
        {
            result.add(new ArrayList<>(tempList));
            return;
        }
        else{
            for(int i =start; i<candidates.length;i++)
            {
                tempList.add(candidates[i]);
                backtrack(candidates, target-candidates[i], i, tempList, result);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    // Example to test
    public static void main(String[] args) {
        CombinationSum_LC39 sol = new CombinationSum_LC39();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinations = sol.combinationSum(candidates, target);

        System.out.println("Combinations for target " + target + ":");
        for (List<Integer> comb : combinations) {
            System.out.println(comb);
        }
    }
}
