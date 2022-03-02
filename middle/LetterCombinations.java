package middle;

import java.util.*;
//17. 电话号码的字母组合
// 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
public class LetterCombinations {
    class Solution {

        // 数字到号码的映射
        private String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        // 路径
        private StringBuilder sb = new StringBuilder();

        // 结果集
        private List<String> res = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if(digits == null || digits.length() == 0) return res;
            backtrack(digits,0);
            return res;
        }

        // 回溯函数
        private void backtrack(String digits,int index) {
            if(sb.length() == digits.length()) {
                res.add(sb.toString());
                return;
            }
            String val = map[digits.charAt(index)-'2'];
            for(char ch:val.toCharArray()) {
                sb.append(ch);
                backtrack(digits,index+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    // public static void main(String[] args) {
    //     HashMap<Character, String> hashMap = new HashMap<>() {{put('2',"abc");}};
    // }
}
