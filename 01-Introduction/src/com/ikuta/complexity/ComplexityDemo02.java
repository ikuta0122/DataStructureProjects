package com.ikuta.complexity;

//案例:ComplexityTest01+ComplexityTest02+ComplexityTest03
//需求：计算1到100的和
//结论:第一种算法和第二种算法的执行时间相差n-1
public class ComplexityDemo02 {
	// 第二种算法
	public static void main(String[] args) {
		int sum = 0;// 执行了1次
		int n = 100;// 执行了1次
		sum = (n + 1) * n / 2;// 执行了1次
		System.out.println("sum=" + sum);
	}
}
/*
 * 如果输入量n为1时,则需要计算1次 
 * 如果输入量n为1亿时,则需要计算1次 
 * 因此,当输入规模为n时,程序需要执行3次
 */