package Recursion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nikoo28 on 7/20/19 1:57 PM
 * Modified to include main() method for execution
 */

public class Subsets {

  // Method to generate all subsets
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> resultList = new ArrayList<>();

    // Start backtracking from the beginning
    backtrack(resultList, new ArrayList<>(), nums, 0);
    return resultList;
  }

  // Helper method for backtracking
  private void backtrack(List<List<Integer>> resultSets, List<Integer> tempSet,
                         int[] nums, int start) {
    // Add the current subset to the results
    resultSets.add(new ArrayList<>(tempSet));

    for (int i = start; i < nums.length; i++) {
      // Include the number
      tempSet.add(nums[i]);

      // Explore further
      backtrack(resultSets, tempSet, nums, i + 1);

      // Exclude the number (backtrack)
      tempSet.remove(tempSet.size() - 1);
    }
  }

  // Main method to test the code
  public static void main(String[] args) {
    Subsets subsetsGenerator = new Subsets();

    int[] nums = {1, 2, 3};
    List<List<Integer>> result = subsetsGenerator.subsets(nums);

    System.out.println("Subsets of " + Arrays.toString(nums) + " are:");
    for (List<Integer> subset : result) {
      System.out.println(subset);
    }
  }
}

