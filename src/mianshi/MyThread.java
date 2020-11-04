package mianshi;

/**
 * @author YZX
 * @date 2019��10��18��
 * @time ����9:32:18
 */

public class MyThread implements Runnable{
	public void run() {
		System.out.println("IM RUNNING~~");
	}
	public static void main(String[] args) {
		new Thread(new MyThread()).start();
		new MyThread2().start();
	}
}

class MyThread2 extends Thread{
	public void run() {
		System.out.println("ME TOO");
	}
}
/*
 * java.util.current�����ṩ�˶��߳��Ż�������ĸ��������
 * �ð��ṩ���̵߳����У��̳߳صĴ������߳��������ڵĿ���.
 * Executors�ṩ�ĸ���̬�������������̳߳�
 * newCachedThreadPool 		�ɻ��棺����̳߳س��ȳ���������Ҫ���������տ����̣߳����޿ɻ��գ����½��̡߳�
 * newFixedThreadPool 		�����������߳���󲢷������������̻߳��ڶ����еȴ���
 * newScheduledThreadPool	������֧�ֶ���������������ִ��
 * newSingleThreadExecutor	���̣߳���������ָ�����ȼ�ִ��
 * ���ã�
 * 1���޶��̵߳ĸ��������ᵼ�������̹߳��ർ��ϵͳ���л��������
 * 2���̳߳ز���Ҫÿ�ζ�ȥ���������٣���Լ����Դ��
 * 3���̳߳ز���Ҫÿ�ζ�ȥ��������Ӧʱ����졣
 */