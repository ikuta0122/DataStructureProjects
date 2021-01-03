package com.ikuta.complexity;

//案例:ComplexityTest07-ComplexityTest11
//平方阶	T(n)=O(n^2)
public class ComplexityDemo10 {
	public static void main(String[] args) {
		int sum = 0;
		int n = 100;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
}