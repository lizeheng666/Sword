package com.lzh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
/**
 *
 */
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      public TreeNode(int x) { val = x; }
}