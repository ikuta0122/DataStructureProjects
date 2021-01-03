package com.ikuta.complexity;

//案例:ComplexityTest07-ComplexityTest11
//对数阶	T(n)=O(logn)
//如果a^x=N（a>0，且a不等于1），那么x是以a(底数)为底N(真数)的对数，记作x=logaN。
public class ComplexityDemo08 {
	public static void main(String[] args) {
		int i = 1;
		int n = 100;
		while (i < n) {
			i = i * 2;
		}
		System.out.println(i);
	}
}
/*分析:当i >= n时结束循环
 * --->i*2*2... >= n
 * --->2^i >= n
 * --->2^i >= n
 * --->i >= log(2)n
 */
