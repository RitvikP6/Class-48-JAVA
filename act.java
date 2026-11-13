import java.util.*;

public class act {
    // A Set to store the subsets without duplicates
    Set<List<Integer>> output = new HashSet<>();

    // Main method to return subsets of the input array, considering duplicates
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;

        // Sort the array to handle duplicates efficiently
        Arrays.sort(nums);

        // Call the helper function to generate the subsets
        helper(0, new ArrayList<Integer>(), nums);

        // Convert the set of subsets to a list and return it
        List<List<Integer>> ans = new ArrayList<>(output);
        return ans;
    }

    // Helper function to generate subsets using backtracking
    public void helper(int first, ArrayList<Integer> curr, int[] nums) {
        if (first == nums.length) {
            output.add(new ArrayList<>(curr));
            return;
        }
        helper(first + 1, curr, nums);
        curr.add(nums[first]);
        helper(first + 1, curr, nums);
        curr.remove(curr.size() - 1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        act solution = new act();

        List<List<Integer>> result = solution.subsetsWithDup(nums);

        System.out.println("All possible subsets without duplicates:");

        for (List<Integer> subset : result) {
            System.out.println(subset);
        }

        scanner.close();
    }
}