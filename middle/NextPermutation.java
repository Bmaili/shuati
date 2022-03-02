package middle;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

//31. 下一个排列
// 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
//
// 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
// 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
public class NextPermutation {
    public int[] nextPermutation(int[] nums) {
        if (nums == null || nums.length==1) {
            return nums;
        }
        int len = nums.length;
        for (int i = len-1; i >=0 ; i--) {
            if (i==len-1||nums[i]>=nums[i+1]){
                continue;
            }
            int mark = nums[i];
            int j = len-1;
            for (; j > i ; j--) {
                if(nums[j]>nums[i])
                    break;
            }
            nums[i]=nums[j];
            nums[j]=mark;
            Arrays.sort(nums,i+1,len);
            return nums;
        }
        Arrays.sort(nums,0,len);
        return nums;



    }

    public static void main(String[] args) {
        new NextPermutation().nextPermutation(new int[]{1,3,2});
    }
}
