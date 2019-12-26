package com.sxw.algorithms.tree;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 苏雄伟 [suxiongwei@kaoshixing.com]
 * @description
 * @date 2019/12/26 4:10 下午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Node {
    private int value;
    private Node left;
    private Node right;
}
