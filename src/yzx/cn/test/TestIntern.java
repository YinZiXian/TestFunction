package yzx.cn.test;

/**
 * @author YZX
 * @date 2020��10��8��
 * @time ����8:10:54
 */

public class TestIntern {
	public static void main(String[] args) {
		String s1 = new String("java");
		String s2 = new String("���������");
		String s3 = "java";
		String s4 = "���������";
		System.out.println(s1.intern() == s1);
		System.out.println(s2.intern() == s2);
		System.out.println(s1.intern() == s3);
		System.out.println(s2.intern() == s4);
	}
}
