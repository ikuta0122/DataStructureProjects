package com.ikuta.complexity;

//案例:ComplexityTest04+ComplexityTest05+ComplexityTest06
//需求:求1+2+...+100的和
//结论:该算法执行n+2次,时间复杂度T(n)=O(n)
public class ComplexityDemo05 {
	public static void main(String[] args) {
		int sum = 0;// 执行1次
		int n = 100;// 执行1次
		for (int i = 1; i <= n; i++) {
			sum += i;// 执行n次
		}
		System.out.println("sum=" + sum);
	}
}