package com.ikuta.complexity;

//案例:ComplexityTest07-ComplexityTest11
//立方阶	T(n)=O(n^3)
public class ComplexityDemo11 {
	public static void main(String[] args) {
		int sum = 0;
		int n = 100;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 0; k <= n; k++) {
					sum += i;
				}
			}
		}
		System.out.println(sum);
	}
}
