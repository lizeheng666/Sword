package com.lzh;

import com.lzh.pojo.ListNode;
import com.lzh.pojo.TreeNode;
import com.lzh.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
    }

    @Test
    void test17(){
        TestUtils.printNumbers(2);
    }

    @Test
    void test18(){
        String a = "a";
        String a1 = new String("a");
        System.out.println(a==a1);
    }

    @Test
    void test19(){
        int num[]={1,2,3,4};
        TestUtils.exchagne(num);
    }

    @Test
    void test20(){
        boolean number = TestUtils.isNumber("  .123");
//        System.out.println(number);
        boolean number1 = TestUtils.isNumber("123");
        System.out.println(number1);
        boolean number2 = TestUtils.isNumber("5e2");
        System.out.println(number2);
        boolean number3 = TestUtils.isNumber("-123");
        System.out.println(number3);
        boolean number4 = TestUtils.isNumber("3.1416");
        System.out.println(number4);
        boolean number5 = TestUtils.isNumber("-1E-16");
        System.out.println(number5);

        //false
        boolean number6 = TestUtils.isNumber(".");
        System.out.println(number6);
        boolean number7 = TestUtils.isNumber("e");
        System.out.println(number7);
        boolean number8 = TestUtils.isNumber("1.2.3");
        System.out.println(number8);
        boolean number9 = TestUtils.isNumber("12e");
        System.out.println(number9);
        boolean number10 = TestUtils.isNumber("1a3.14");
        System.out.println(number10);
        boolean number11 = TestUtils.isNumber("12e+5.4");
        System.out.println(number11);
        boolean number12 = TestUtils.isNumber("+-5");
        System.out.println(number12);
    }
}
