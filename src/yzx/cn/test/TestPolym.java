package yzx.cn.test;

/**
 * @author YZX
 * @date 2019��9��19��
 * @time ����7:59:37
 */

public class TestPolym {
	public static void main(String[] args) {
		Animal animal = new Dog(); // ���Ͽ����Զ�ת��
		System.out.println(animal.age); // ���Ե���ʱ����Ȼ�ǻ������ �ԡ�����û�ж�̬��
// animal.shout();
		animalCry(new Dog());
//���ľ�������һ����͵�����һ����ķ������������˳���Ŀ���չ�ԡ� //���û�ж�̬������������Ҫд�ܶ����صķ������������һ�ֶ������Ҫ����һ�ֶ���ĺ��з������ǳ��鷳�� 
		// ���˶�̬��ֻ��Ҫ���������̳�Animal����Ϳ����ˡ�
		animalCry(new Cat());
		Dog dog = (Dog) animal;
//��д����ʱ��������������ʱ���͵ķ�����ֻ�ܽ�������ת������Ȼͨ�����������ļ�顣 dog.gnawBone();
		System.out.println(dog instanceof Animal);
		System.out.println(animal instanceof Cat);
		System.out.println(animal instanceof Dog);
	}

	static void animalCry(Animal a) {
		a.shout();
	}
}

class Animal {
	int age = 10;

	public void shout() {
		System.out.println("����һ����");
	}
}

class Dog extends Animal {
	int age = 28;

	public void shout() {
		System.out.println("��������");
	}

public void gnawBone(){ 
 System.out.println("���ڿй�ͷ");
}
}

class Cat extends Animal {
	int age = 18;

	public void shout() {
		System.out.println("����������");
	}
}