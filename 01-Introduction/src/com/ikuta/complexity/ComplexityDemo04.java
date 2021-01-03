package com.ikuta.complexity;

//案例:ComplexityTest04+ComplexityTest05+ComplexityTest06
//需求:求1+2+...+100的和
//结论:该算法执行3次,时间复杂度T(n)=O(1)
public class ComplexityDemo04 {
	// 第一种算法
	public static void main(String[] args) {
		int sum = 0;// 执行1次
		int n = 100;// 执行1次
		sum = (n + 1) * n / 2;// 执行1次
		System.out.println("sum=" + sum);
	}
}
