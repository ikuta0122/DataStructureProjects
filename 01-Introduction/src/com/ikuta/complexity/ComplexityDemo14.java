package com.ikuta.complexity;

//方法调用的时间复杂度分析
//案例:ComplexityTest12+ComplexityTest13+ComplexityTest14
/*
由于show方法内部有一个for循环，所以show方法的时间复杂度为O(n).
在main方法中，
1.调用show方法，执行n次;
2.for循环中调用show方法,执行n^2次;
3.双层循环,执行n^2次.
那么,main方法的时间复杂度为O(n^2) 
*/
public class ComplexityDemo14 {
	public static void main(String[] args) {
		int n = 100;
		show(n);
		for (int i = 0; i < n; i++) {
			show(i);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println(i);
			}
		}
	}

	private static void show(int i) {
		for (int j = 0; j < i; j++) {
			System.out.println(i);
		}
	}
}
