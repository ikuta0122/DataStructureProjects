package com.ikuta.comparable;

/*需求2:定义测试类
定义测试方法 Comparable getMax(comparable c1,comparable c2)完成测试
*/
public class TestComparable {
    //创建两个Student对象并调用getMax()方法,完成测试
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setUsername("zhangsan");
        s1.setAge(20);
        Student s2 = new Student();
        s2.setUsername("lisi");
        s2.setAge(18);
        Comparable max = getMax(s1, s2);
        System.out.println(max);
    }

    /**
     * result > 0 表示 c1.age > c2.age
     * result = 0 表示 c1.age = c2.age
     * result < 0 表示 c1.age < c2.age
     */
    public static Comparable getMax(Comparable c1, Comparable c2) {
        int result = c1.compareTo(c2);
        if (result >= 0) {
            return c1;
        } else {
            return c2;
        }
    }
}
