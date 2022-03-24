package middle;

import java.util.*;

//https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
//剑指 Offer 38. 字符串的排列
// 输入一个字符串，打印出该字符串中字符的所有排列。
public class Permutation {
    boolean[] mark;
    char[] chars;
    StringBuilder sb = new StringBuilder();
    List<String> res = new ArrayList();


    public String[] permutation(String s) {
        if(s==null||s.length()==0){
            return res.toArray(new String[0]);
        }

        chars = s.toCharArray();
        mark = new boolean[chars.length];
        Arrays.sort(chars);
        backtrank(0,s.length());
        return res.toArray(new String[0]);
    }

    public void backtrank(int index,int n){
        if(index==n){
            res.add(new String(sb));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(mark[i]||(i!=0&&!mark[i-1]&&chars[i]==chars[i-1])){
                continue;
            }
            sb.append(chars[i]);
            mark[i]=true;
            backtrank(index+1,n);
            mark[i]=false;
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        String[] abcs = new Permutation().permutation(new String("abccd"));
        for (var s: abcs) {
            System.out.println(s);
        }
    }
}
