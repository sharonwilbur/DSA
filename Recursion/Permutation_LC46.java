package Recursion;


import java.util.ArrayList;
import java.util.List;

public class Permutation_LC46 {
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> result= new ArrayList<>();
        backtrack(candidates, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int [] candidates, List<Integer> tempList, List<List<Integer>> result)
    {
        if(tempList.size()==candidates.length)
        {
            result.add(new ArrayList<>(tempList));
            return;
        }
        else{
            for(int i =0; i<candidates.length;i++)
            {
                if(tempList.contains(candidates[i])) continue;
                tempList.add(candidates[i]);
                backtrack(candidates, tempList, result);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    // Example to test
    public static void main(String[] args) {
        Permutation_LC46 sol = new Permutation_LC46();
        int[] candidates = {1,0};
        int target = 7;
        List<List<Integer>> combinations = sol.combinationSum(candidates, target);

        System.out.println("Combinations for target " + target + ":");
        for (List<Integer> comb : combinations) {
            System.out.println(comb);
        }
    }
}

