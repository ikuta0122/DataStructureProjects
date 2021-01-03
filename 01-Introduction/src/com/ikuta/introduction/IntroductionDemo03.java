package com.ikuta.introduction;

//IntroductionTest03 + IntroductionTest04
//需求2：计算10的阶乘
//结论：第二种算法完成需求，占用的内存空间更小
public class IntroductionDemo03 {
	public static void main(String[] args) {
		long result = fun1(10);
		System.out.println(result);
	}

	public static long fun1(long n) {
		if (n == 1) {
			return 1;
		}
		return n * fun1(--n);
	}
}

/*
 * 第一种解法使用递归完成需求：
 * 1.fun1方法会执行10次， 并且第一次方法未执行完毕就调用了第二次方法...
 * 2.需要在堆内存中同时开辟10块内存分别执行10个fun1方法。
 */
