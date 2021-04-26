package test;

/**
 * @author YZX
 * @date 2019��9��19��
 * @time ����8:39:44
 */

/**
 * ��ȡClass��������ַ�ʽ 1 Object ����> getClass(); 2 �κ��������ͣ����������������ͣ�����һ������̬����class���� 3
 * ͨ��Class��ľ�̬������forName��String className��(����)
 * 
 */
public class TestReflect {
	public static void main(String[] args) {
		// ��һ�ַ�ʽ��ȡClass����
		Student stu1 = new Student();// ��һnew ����һ��Student����һ��Class����
		Class stuClass = stu1.getClass();// ��ȡClass����
		System.out.println(stuClass.getName());
		// �ڶ��ַ�ʽ��ȡClass����
		Class stuClass2 = Student.class;
		System.out.println(stuClass == stuClass2);
		// �����ַ�ʽ��ȡClass����
		try {
			Class stuClass3 = Class.forName("yzx/cn/test.Student");// ע����ַ�����������ʵ·�������Ǵ���������·��������.����
			System.out.println(stuClass3 == stuClass2);// �ж����ַ�ʽ�Ƿ��ȡ����ͬһ��
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
class Student{
	
}
