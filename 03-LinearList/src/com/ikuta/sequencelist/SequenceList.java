package com.ikuta.sequencelist;

import java.util.Iterator;

public class SequenceList<T> implements Iterable<T> {
    //存储元素的数组
    private T[] eles;
    //记录当前顺序表中的元素个数
    private int N;

    //构造方法
    public SequenceList(int capacity) {
        //初始化数组
        this.eles = (T[]) new Object[capacity];
        //初始化长度
        this.N = 0;
    }

    //顺序表的容量可变:根据参数newSize重置eles的大小
    public void resize(int newSize) {
        //1.定义临时数组指向原数组
        T[] temp = eles;
        //2.创建新数组
        eles = (T[]) new Object[newSize];
        //3.原数组数据拷贝到新数组
        for (int index = 0; index < N; index++) {
            eles[index] = temp[index];
        }
    }

    //方法:将顺序表置空
    public void clear() {
        this.N = 0;
    }

    //方法:判断顺序表是否为空表
    public boolean isEmpty() {
        return N == 0;
    }

    //方法:获取顺序表的长度
    public int length() {
        return N;
    }

    //方法:获取指定位置的元素
    public T get(int i) {
        return eles[i];
    }

    //方法:向顺序表中添加元素t
    public void insert(T t) {
        //0.容量检验
        if (N == eles.length) {
            resize(eles.length * 2);
        }
        //1.将元素t放到数组尾部
        eles[N++] = t;
    }

    //方法:向顺序表中指定位置添加元素t
    public void insert(int i, T t) {
        //0.容量检验
        if (N == eles.length) {
            resize(eles.length * 2);
        }
        //1.索引i处后面的元素向后移动一位
        for (int index = N; index > i; index--) {
            eles[index] = eles[index - 1];
        }
        //2.将元素t放到i索引处
        eles[i] = t;
        //3.数组长度加1
        N++;
    }

    //方法:删除指定位置i处的元素,并返回该元素
    public T remove(int i) {
        //1.记录索引i处的值
        T current = eles[i];
        //2.索引i处后面的元素向前移动一位
        for (int index = i; index < N - 1; index++) {
            eles[index] = eles[index + 1];
        }
        //3.数组长度减1
        N--;
        //4.容量检验
        if (N < eles.length / 4) {
            resize(eles.length / 2);
        }
        return current;
    }

    //方法:查找元素t第一次出现的位置
    public int indexOf(T t) {
        for (int i = 0; i < N; i++) {
            if (eles[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    //顺序表的遍历
    @Override
    public Iterator<T> iterator() {
        return new SIterator();

    }

    private class SIterator implements Iterator {
        private int cusor;

        public SIterator() {
            this.cusor = 0;
        }

        @Override
        public Object next() {
            return eles[cusor++];
        }

        @Override
        public boolean hasNext() {
            return cusor < N;
        }
    }
}
