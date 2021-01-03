package com.ikuta.complexity;

//空间复杂度分析
//需求：对指定的数组元素进行反转，并返回反转的内容
//结论：从空间占用角度来看，第一种算法要优于第二种算法
public class ComplexityDemo16 {
	public static void main(String[] args) {
	}

	/**
	 * 第一种算法 空间复杂度为O(1)
	 * 不管传入的数组大小为多少，始终额外申请4+4=8个字节 
	 */
	public static int[] reverse1(int[] arr) {
		int n = arr.length;// 申请4个字节
		int temp;// 申请4个字节
		for (int start = 0, end = n - 1; start <= end; start++, end--) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
		}
		return arr;
	}

	/**
	 * 第二张算法 空间复杂度为O(n)
	 * 不管传入的数组大小为多少，始终额外申请28+n*4个字节 
	 */
	public static int[] reverse2(int[] arr) {
		int n = arr.length;// 申请4个字节
		int[] temp = new int[n];// 申请24+n*4个字节
		for (int i = n - 1; i >= 0; i--) {
			temp[n - 1 - i] = arr[i];
		}
		return temp;
	}
}
