package com.ikuta.introduction;

//IntroductionTest03 + IntroductionTest04
//需求2：计算10的阶乘
//结论：第二种算法完成需求，占用的内存空间更小
public class IntroductionDemo04 {
	public static void main(String[] args) {
		long result = fun2(10);
		System.out.println(result);
	}

	public static long fun2(long n) {
		int result = 1;
		for (long i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
}
/*
 * 第二种解法使用for循环完成需求：
 * 1.fun2方法只会执行一次，
 * 2.最终，只需要在栈内存中开辟1块空间执行fun2方法即可。
 */