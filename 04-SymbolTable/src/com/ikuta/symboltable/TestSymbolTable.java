package com.ikuta.symboltable;

public class TestSymbolTable {
    public static void main(String[] args) {
        //创建符号表对象
        SymbolTable<Integer, String> st = new SymbolTable<>();
        //测试put()方法[插入/替换]
        st.put(1, "张三");
        st.put(2, "李四");
        st.put(3, "王五");
        st.put(1, "赵六");
        System.out.println("测试添加方法后的元素个数 : " + st.size());
        //测试delete()方法
        st.delete(3);
        System.out.println("测试删除方法后的元素个数 : " + st.size());
        //测试get()方法
        String getResult = st.get(1);
        System.out.println("测试获取方法的结果 : " + getResult);
    }
}
