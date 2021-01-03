package com.ikuta.complexity;

//案例:ComplexityTest01+ComplexityTest02+ComplexityTest03
//需求：计算1到100的和
//结论:第一种算法和第二种算法的执行时间相差n-1
public class ComplexityDemo01 {
	// 第一种算法
	public static void main(String[] args) {
		int sum = 0;// 执行了1次
		int n = 100;// 执行了1次
		for (int i = 1; i <= n; i++) {// 执行了n+1次
			sum += i;// 执行了n次
		}
		System.out.println("sum=" + sum);
	}
}
/*
 * 如果输入量n为1时,则需要计算1次 
 * 如果输入量n为1亿时,则需要计算1亿次 
 * 因此,当输入规模为n时,程序需要执行2n+3次
 * 如果将第一种算法的循环体看作一个整个,从而忽略结束条件的判断
 * 那么,第一种算法的执行次数为n+2
 */