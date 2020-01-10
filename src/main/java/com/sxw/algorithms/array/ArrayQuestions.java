package com.sxw.algorithms.array;

/**
 * @author 苏雄伟 [suxiongwei@kaoshixing.com]
 * @description
 * @date 2020/1/10 3:40 下午
 */
public class ArrayQuestions {
    /**
     * 题目一
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
     * 判断数组中是否含有该整数。
     */

    /**
     * 暴力法
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * @param target
     * @param array
     * @return
     */
    public boolean find1(int target, int [][] array) {
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                if (array[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 从左下找
     * 时间复杂度：O(行高+列宽)
     * 空间复杂度：O(1)
     * @param target
     * @param array
     * @return
     */
    public boolean find2(int target, int [][] array) {
        int rows = array.length;
        if (rows == 0){
            return false;
        }
        int cols = array[0].length;
        if (cols == 0){
            return false;
        }

        // 左下
        int row = rows -1;
        int col = 0;

        while (target != array[row][col]){
            if (array[row][col] < target){
                col ++;
            }else if (array[row][col] > target){
                row --;
            }

            if (row < 0 || col >= cols){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        int[][] array = new int[3][2];
        array[0][0] = 1;
        array[0][1] = 2;
        array[1][0] = 3;
        array[1][1] = 4;
        array[2][0] = 5;
        array[2][1] = 6;

        System.out.println(array.length);
        System.out.println(array[0].length);

    }
}
