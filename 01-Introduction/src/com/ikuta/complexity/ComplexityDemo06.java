package com.ikuta.complexity;

//案例:ComplexityTest04+ComplexityTest05+ComplexityTest06
//需求:求100个1+100个2+...+100个100的和
//结论:该算法执行n^2+2次,时间复杂度T(n)=O(n^2)
public class ComplexityDemo06 {
	public static void main(String[] args) {
		int sum = 0;// 执行1次
		int n = 100;// 执行1次
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sum += i;// 执行n^2次
			}
		}
		System.out.println(sum);
	}
}
