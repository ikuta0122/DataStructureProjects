package com.ikuta.ordersymboltable;

public class TestOrderSymbolTable {
    public static void main(String[] args) {
        //创建有序符号表
        OrderSymbolTable<Integer,String> ost = new OrderSymbolTable<>();
        //测试put()方法[插入/替换][通过debug检验]
        ost.put(1, "张三");
        ost.put(3, "王五");
        ost.put(2, "李四");
        ost.put(1, "姚明");
    }
}
