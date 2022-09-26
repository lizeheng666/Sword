package com.lzh;

import com.lzh.pojo.ListNode;
import com.lzh.pojo.TreeNode;
import com.lzh.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SwoadApplicationTests {
    

    @Test
    void contextLoads() {
        System.out.println(1);
    }

    @Test
    public void test06() {
        ListNode listNode = new ListNode(1,new ListNode(3,new ListNode(2,null)));
        int[] ints = TestUtils.test06(listNode);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    @Test
    void test07(){
        int preorder[] ={ 3,9,20,15,7};
        int inorder[] = {9,3,15,20,7};
        TestUtils testUtils = new TestUtils();
        TreeNode treeNode = testUtils.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    @Test
    void test09(){
        TestUtils testUtils = new TestUtils();
        TestUtils.CQueue q = testUtils.new CQueue();
        q.appendTail(3);
        int param_2 = q.deleteHead();
    }

    @Test
    void test11(){
        int arr[]={2,2,2,0,1};
        int i = TestUtils.test11(arr);
        System.out.println(i);
    }

    @Test
    void test15(){
        String s = Integer.toBinaryString(-3);
        System.out.println(s);
        double d = 1;
    }

    @Test
    void test16(){
        double v = TestUtils.myPow(2.0000, -2);
        System.out.println(v);
        Math.max()
    }
}
