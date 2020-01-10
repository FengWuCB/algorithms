package com.sxw.algorithms.string;

import org.springframework.util.StringUtils;

/**
 * @author 苏雄伟 [suxiongwei@kaoshixing.com]
 * @description
 * @date 2019-11-12 17:13
 */
public class StringQuestions {
    /**
     * 判断两个字符串是否互为变形词
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isDeformation(String str1, String str2){
        if (StringUtils.isEmpty(str1) || StringUtils.isEmpty(str2) || str1.length() != str2.length()){
            return false;
        }
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < char1.length; i++){
            map[char1[i]] ++;
        }
        for (int i = 0; i < char2.length; i++){
            int tmp = map[char2[i]]--;
            if (tmp == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        StringBuffer result = new StringBuffer();
        char[] chars = str.toString().toCharArray();
        for (char aChar : chars) {
            if (aChar == ' '){
                result.append("%20");
            }else {
                result.append(aChar);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(isDeformation("abcc","acbc"));
    }
}
