package com.ikuta.stack;

//逆波兰表达式求值问题
public class TestReversePolishNotation {
    public static void main(String[] args) {
        //中缀表达式 3*（17-15）+18/6 的逆波兰表达式如下
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int result = caculate(notation);
        System.out.println("逆波兰表达式的结果为：" + result);
    }

    /**
     * @param notaion 逆波兰表达式的数组表示方式
     * @return 逆波兰表达式的计算结果
     */
    public static int caculate(String[] notaion) {
        //1.创建一个栈对象oprands存储操作数
        Stack<Integer> oprands = new Stack<>();
        //2.从左往右遍历逆波兰表达式，得到每一个字符串
        for (int i = 0; i < notaion.length; i++) {
            String curr = notaion[i];
            //3.判断该字符串属于操作数还是运算符
            Integer o1;
            Integer o2;
            Integer result;
            switch (curr) {
                //3.1如果是运算符,则从oprands栈中弹出两个操作数o1,o2进行运算并将结果作为新的操作数压栈
                case "+":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o2 + o1;
                    oprands.push(result);
                    break;
                case "-":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o2 - o1;
                    oprands.push(result);
                    break;
                case "*":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o2 * o1;
                    oprands.push(result);
                    break;
                case "/":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    result = o2 / o1;
                    oprands.push(result);
                    break;
                default:
                    //3.2如果是操作数,则将该操作数压栈
                    oprands.push(Integer.parseInt(curr));
                    break;
            }
        }
        //4.遍历结束后,将栈中最后一个操作数弹出
        int result = oprands.pop();
        return result;
    }
}
