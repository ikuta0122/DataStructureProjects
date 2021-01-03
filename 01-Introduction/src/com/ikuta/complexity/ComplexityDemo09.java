package com.ikuta.complexity;

//案例:ComplexityTest07-ComplexityTest11
//线性阶	T(n)=O(n)
public class ComplexityDemo09 {
	public static void main(String[] args) {
		int sum = 0;
		int n = 100;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println("sum=" + sum);
	}
}