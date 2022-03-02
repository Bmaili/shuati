package middle;

//https://leetcode-cn.com/problems/3sum-closest/
// 16. 最接近的三数之和
//         给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
//
//         返回这三个数的和。
//
//         假定每组输入只存在恰好一个解。


import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int best = 99999999;

        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = len - 1;
            int sum = 0;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    do {
                        k--;
                    } while (nums[k] == nums[k + 1] && j < k);
                } else {
                    do {
                        j++;
                    } while (nums[j] == nums[j - 1] && j < k);
                }
            }
        }
        return best;
    }
}
