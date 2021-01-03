package com.ikuta.complexity;

//案例:ComplexityTest01+ComplexityTest02+ComplexityTest03
//需求:计算100个1+100个2+...+100个100的结果
//
//问题:为什么可以忽略ComplexityTest02中的循环判断
//原因:真正参与计算的核心代码是内循环的循环体
//结论:分析算法的运算时间,最重要的就是把核心操作的次数和输入规模关联起来
public class ComplexityDemo03 {
	public static void main(String[] args) {
		int sum = 0;// 执行1次
		int n = 100;// 执行1次
		for (int i = 1; i <= n; i++) {// 执行n次
			for (int j = 1; j <= n; j++) {// 执行n次
				sum += i;// 执行n^2次
			}
		}
		System.out.println(sum);
	}
}
/*
 * 忽略判断条件,程序执行n^2+2次
 */