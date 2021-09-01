package easy;

import java.util.Arrays;

// https://leetcode.com/problems/two-sum/

public class task1 {
    static int[] nums = new int[] {2,7,11,15};
    static int target = 9;

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j)
                    continue;

                if (nums[i] + nums[j] == target) {
                    int[] answer = new int[2];
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
