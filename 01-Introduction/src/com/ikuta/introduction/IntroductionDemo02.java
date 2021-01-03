package com.ikuta.introduction;

//案例：IntroductionTest01 + IntroductionTest02
//需求1：计算1到100的和
//结论：第二种算法完成需求，花费的时间要少
public class IntroductionDemo02 {
	// 第二种解法
	public static void main(String[] args) {
		int sum = 0;
		int n = 100;
		sum = (n + 1) * n / 2;
		System.out.println("sum=" + sum);
	}
}
/*
 * 第二种解法要完成需求，要完成以下动作：
 * 1.定义两个整形变量 
 * 2.执行三次运算:1次加法运算,1次乘法运算,1次除法运算
 * 3.打印结果到控制台
 */