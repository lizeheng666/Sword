package com.lzh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
