package com.sxw.algorithms.link;

import lombok.Data;

/**
 * @author 苏雄伟 [suxiongwei@kaoshixing.com]
 * @description
 * @date 2019-11-01 16:40
 */
@Data
public class DoubleNode {
    public int value;
    public DoubleNode last;
    public DoubleNode next;
    public DoubleNode(int data){
        this.value = data;
    }
}
