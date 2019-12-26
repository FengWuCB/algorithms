package com.sxw.algorithms.link;

import lombok.Data;

/**
 * @author 苏雄伟 [suxiongwei@kaoshixing.com]
 * @description
 * @date 2019-11-01 16:18
 */
@Data
public class Node {
    public int value;
    public Node next;
    public Node(int data){
        this.value = data;
    }
}
