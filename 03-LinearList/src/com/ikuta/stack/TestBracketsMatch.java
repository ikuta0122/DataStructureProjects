package com.ikuta.stack;

//括号匹配问题
public class TestBracketsMatch {
    public static void main(String[] args) {
        String str = "上海(长安)()";
        boolean match = isMatch(str);
        System.out.println(str + "中的括号是否匹配：" + match);
    }

    /**
     * 判断str中的括号是否匹配
     *
     * @param str 待检验字符串
     * @return 返回true表示括号匹配, 返回false表示括号不匹配
     */
    public static boolean isMatch(String str) {
        //1.创建一个栈用来存储左括号
        Stack<String> chars = new Stack<>();
        //2.从左往右遍历字符串,拿到每一个字符
        for (int i = 0; i < str.length(); i++) {
            String currChar = String.valueOf(str.charAt(i));
            //3.判断当前字符是不是左括号
            if (currChar.equals("(")) {
                chars.push(currChar);
            }
            //4.判断当前字符是不是右括号
            if (currChar.equals(")")) {
                String pop = chars.pop();
                if (pop == null) {
                    return false;
                }
            }
        }
        //5.循环结束后,判断栈中还有没有剩余的左括号[栈中元素个数是否为0]
        return chars.size() == 0;
    }
}
