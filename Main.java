
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        helper(0, new ArrayList<Integer>(), nums);
        return output;
    }

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

        Main solution = new Main();

        List<List<Integer>> result = solution.subsets(nums);

        System.out.println("All possible subsets:");

        for (List<Integer> subset : result) {
            System.out.println(subset);
        }

        scanner.close();
    }
}
