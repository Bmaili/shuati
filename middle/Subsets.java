package middle;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/subsets/
//78. 子集
// 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
class Subsets {

    // 位运算
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }
        List<List<Integer>> res  = new ArrayList<>();
        int n =nums.length;
        for(int i =0;i<(1<<n);i++){
            List<Integer> li = new ArrayList<>();
            for(int j =0;j<n;j++){
                if((i&(1<<j))!=0){
                    li.add(nums[j]);
                }
            }
            res.add(li);
        }
        return res;
    }

    // 回溯
    List<List<Integer>> res2  = new ArrayList<>();
    List<Integer>temp = new ArrayList<>();
    public List<List<Integer>> subsets2(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }
        dfs(0,nums);

        return res2;
    }
    void dfs(int n,int nums[]){
        if(n== nums.length){
            res2.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[n]);
        dfs(n+1,nums);
        temp.remove(temp.size()-1);
        dfs(n+1,nums);
    }


    public static void main(String[] args) {
        List<List<Integer>> list = new Subsets().subsets2(new int[]{1, 2, 3});
        System.out.println(list);

    }
}
