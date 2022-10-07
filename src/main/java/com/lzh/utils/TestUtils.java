package com.lzh.utils;

import com.lzh.pojo.ListNode;
import com.lzh.pojo.TreeNode;

import java.util.*;

public class TestUtils {
    /**
     * 剑指 Offer 06. 从尾到头打印链表
     */
    public static int[] test06(ListNode head) {
        Stack<Integer> ints = new Stack<Integer>();
        while (head != null) {
            ints.push(head.getVal());
            head = head.getNext();
            if (head == null) {
                break;
            }
        }
        int a[] = new int[ints.size()];
        int i = 0;
        while (!ints.isEmpty()) {
            a[i] = ints.pop();
            i++;
        }
        return a;
    }

    /**
     * 剑指 Offer 07. 重建二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     */
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder!=null&&inorder!=null){
            for(int i=0;i<inorder.length;i++){
                map.put(inorder[i],i);
            }
            TreeNode tree = f(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
            return tree;
        }
        return null;
    }

    public TreeNode f(int[] preorder, int[] inorder, int l1, int r1, int l2, int r2) {
        if (l1 > r1 && l2 > r2) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[l1]);
        int i = map.get(preorder[l1]);
        root.setLeft(f(preorder, inorder,l1+1,l1+(i-l2),l2,i-1));
        root.setRight(f(preorder,inorder,l1+(i-l2)+1,r1,i+1,r2));
        return root;
    }

    /* *
    *剑指 Offer 09. 用两个栈实现队列
    *用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
    */
    public class CQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;
        public CQueue() {
            this.s1 = new Stack<>();
            this.s2 = new Stack<>();
        }

        public void appendTail(int value) {
            this.s1.push(value);
        }

        public int deleteHead() {
            if(s1.empty()){
                return -1;
            }
            while (!s1.empty()){
                this.s2.push(s1.pop());
            }
            Integer value = s2.peek();
            s2.pop();
            while(!s2.empty()){
                this.s1.push(s2.pop());
            }
            return value;
        }
    }
    /**
     *剑指 Offer 10- I. 斐波那契数列
     *写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     *
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     */
    int arr[];
    public int fib(int n) {
        arr = new int[n+1];
        for(int i=0;i<n+1;i++){
            arr[i]=-1;
        }
        return f1(n);
    }
    public int f1(int n){
        if(n<=1){
            return n;
        }
        if(arr[n]!=-1){
            return arr[n];
        }else{
            arr[n]=(f1(n-1)+f1(n-2))%1000000007;
            return arr[n];
        }
    }

    /**
     *剑指 Offer 10- II. 青蛙跳台阶问题
     *一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * 递推公式：f(n)=f(n-1)+f(n-2)同斐波拉契序列
     */
    public static int test10(int n){
        int p=1,q=1,r=1;
        if (n<=1){
            return 1;
        }
        for(int i=2;i<=n;i++){
            p=q;
            q=r;
            r=(q+p)%1000000007;
        }
        return r;
    }

    /**
     *剑指 Offer 11. 旋转数组的最小数字
     *把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     *
     * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。  
     *
     * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
     */
    public static int test11(int []numbers){
        int i = 0;
        int j = numbers.length-1;
        int mid = 0;
        if (numbers[i]<numbers[j]){
            return numbers[0];
        }
        while(i!=j){
            if (numbers[i]<numbers[j]){
                return numbers[0];
            }
            mid = (i+j)/2;
            if (numbers[mid]>numbers[i]){
                i = mid+1;
            }else if(numbers[mid]<numbers[i]){
                j=mid;
            }else{
                i+=1;
            }
        }
        return numbers[i];
    }

    /**
     * 剑指 Offer 12. 矩阵中的路径
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     *
     */
    int n,m;
    int length;
    public boolean test12(char[][] board,String word){
        n=board.length;
        m=board[0].length;
        length=word.length();
        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (dsf(board,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dsf(char[][] board,int i,int j,String word,int k){
        if (i<0||i>=n||j<0||j>=m||board[i][j]!=word.charAt(k)){
            return false;
        }
        if (k==length-1){
            return true;
        }
        board[i][j]='*';
        boolean flag = dsf(board,i+1,j,word,k+1)||
                dsf(board,i-1,j,word,k+1)||
                dsf(board,i,j+1,word,k+1)||
                dsf(board,i,j-1,word,k+1);
        board[i][j]=word.charAt(k);
        return flag;
    }

    /**
     * 剑指 Offer 14- I. 剪绳子
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
     * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     */
    public int test14(int n){
        if (n<=2){
            return 1;
        }
        if (n==3){
            return 2;
        }
        int res = n/3;
        int mod = n%3;
        if (mod==0){
            return pow3(res);
        }else if(mod==1){
            return pow3(res-1)*4;
        }else{
            return pow3(res)*2;
        }
    }

    public static int pow3(int n){
        int num=1;
        for(int i=0;i<n;i++){
            num*=3;
        }
        return num;
    }

    /**
     * 剑指 Offer 15. 二进制中1的个数
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式）
     * 返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
     */
    public static int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int count = 0;
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c=='1'){
                count++;
            }
        }
        return count;
    }

    /**
     * 剑指 Offer 16. 幂函数
     */
    public static double myPow(double x,int n) {
        double res = 1;
        long y = n;
        if(n<0){
            y=-y;
            x=1/x;
        }
        while(y>0){
            if (y%2==1){
                res*=x;
            }
            x*=x;
            y/=2;
        }
        return res;
    }

    /**
     * 剑指 Offer 17. 打印从1到最大的n位数
     */
    public static int[] printNumbers(int n) {
        int arr[];
        int num = 1;
        if (n==0){
            arr = new int[1];
            return arr;
        }else{
            for(int i=0;i<n;i++){
                num*=10;;
            }
            num-=1;
            arr=new int[num];
            for (int j=num-1;j>=0;j--){
                arr[j]=j+1;
            }
            return arr;
        }
    }

    /**
     * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分
     */
    public static int[] exchagne(int [] nums){
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if (nums[i]%2!=0){
                arr.add(nums[i]);
            }
        }
        for(int i=0;i<nums.length;i++){
            if (nums[i]%2==0){
                arr.add(nums[i]);
            }
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=arr.get(i);
        }
        return nums;
    }

    public static boolean isNumber(String s) {
        //  去除空格
        s = s.trim();
        char[] strArr = s.toCharArray();
        for(int i=0;i<strArr.length;i++){
            //开头是小数点的情况
            if(strArr[i]=='.'){
                return afterPoint(strArr,i+1);
            }

            //开头是正负号的情况
            if(strArr[i]=='+'||strArr[i]=='-'){
                return afterAddOrMinus(strArr,i+1);
            }

            //开头是纯数字
            if (strArr[i]>=48&&strArr[i]<=57){
                return afterNumber(strArr,i+1);
            }
        }

        return false;
    }

    public static boolean afterNumber(char[] strArr, int index) {
        int num=0;
        for(int i=index;i<strArr.length;i++){
            if (num==0&&strArr[i]=='.'){
                return afterPoint(strArr, i+1);
            }
            if (num==0&&(strArr[i]=='e'||strArr[i]=='E')){
                return afterE(strArr,i+1);
            }
            if (strArr[i]<48||strArr[i]>57){
                return false;
            }
            num++;
        }
        return true;
    }

    public static boolean afterPoint(char strArr[],int index){
        if (index>=strArr.length){
            return false;
        }
        for(int j=index;j<strArr.length;j++){
            if (strArr[j]<48||strArr[j]>57){
                return false;
            }
        }
        return true;
    }

    public static boolean afterAddOrMinus(char strArr[],int index){
        int num=0;
        for(int i=index;i<strArr.length;i++){
            if (num!=0&&strArr[i]=='.'){
                return afterPoint(strArr, i+1);
            }
            if (num!=0&&(strArr[i]=='e'||strArr[i]=='E')){
                return afterEPLUS(strArr,i+1);
            }
            if (strArr[i]<48||strArr[i]>57){
                return false;
            }
            num++;
        }
        return true;
    }

    public static boolean afterE(char strArr[],int index){
        if (index>=strArr.length){
            return false;
        }
        int num=0;
        for(int i=index;i<strArr.length;i++){
            if (num!=0&&(strArr[i]=='+'||strArr[i]=='-')){
                for(int j=i+1;j<strArr.length;j++){
                    if (strArr[j]<48||strArr[j]>57){
                        return false;
                    }
                }
                return true;
            }
            if (strArr[i]<48||strArr[i]>57){
                return false;
            }
            num++;
        }
        return true;
    }

    public static boolean afterEPLUS(char strArr[],int index){
        if (index>=strArr.length){
            return false;
        }
        int num=0;
        for(int i=index;i<strArr.length;i++){
            if (num==0&&(strArr[i]=='+'||strArr[i]=='-')){
                for(int j=i+1;j<strArr.length;j++){
                    if (strArr[j]<48||strArr[j]>57){
                        return false;
                    }
                }
                return true;
            }
            if (strArr[i]<48||strArr[i]>57){
                return false;
            }
            num++;
        }
        return true;
    }


}
