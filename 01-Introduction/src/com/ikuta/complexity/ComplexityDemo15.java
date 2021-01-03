package com.ikuta.complexity;

import java.util.Scanner;

//最好情况:查找的第一个数字就是期望数字，那么算法的时间复杂度为O(1)
//最坏情况:查找的最后一个数字才是期望数字,那么算法的时间复杂度为O(n)
//平均情况:( 1 + n ) / 2 = n / 2 + 1 / 2 = n / 2 --->O( n / 2)
//结论:把最坏情况下的时间复杂度视为算法的时间复杂度
public class ComplexityDemo15 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		s.close();
		System.out.println(num);
	}

	public int search(int num) {
		int[] arr = { 11, 10, 8, 9, 7, 22, 23, 0 };
		for (int i = 0; i < arr.length; i++) {
			if (num == arr[i]) {
				return i;
			}
		}
		return -1;
	}
}
