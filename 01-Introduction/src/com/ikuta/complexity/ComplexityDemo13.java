package com.ikuta.complexity;

//方法调用的时间复杂度分析
//案例:ComplexityTest12+ComplexityTest13+ComplexityTest14
/*
在main方法中，有一个for循环，循环调用show方法，
由于show方法内部有一个for循环，
所以show方法的时间复杂度为O(n),
那么,main方法的时间复杂度为O(n^2) 
 */
public class ComplexityDemo13 {
	public static void main(String[] args) {
		int n = 100;
		for (int i = 0; i < n; i++) {
			show(i);
		}
	}

	private static void show(int i) {
		for (int j = 0; j < i; j++) {
			System.out.println(i);
		}
	}
}
