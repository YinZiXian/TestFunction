package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

	public static void main(String[] args) {
		ExecutorService executor = createExecutorService();
		executor.execute(() -> {
			System.out.println(Thread.currentThread().getName());
			throw new RuntimeException();
		});
	}
	
	public static ExecutorService createExecutorService() {
		
		/**
		 * �����߳�����С����������δ��ʱ�߳��������
		 */
		int corePoolSize = 1;
		
		/**
		 * ����߳�����С�������������Ҽ����������ʱ����ͷ����ȡ�����������߳�ִ�и����񣬸ñ���Ϊ������������ʱ�߳����Ĳ�����
		 */
		int maximumPoolSize = 1;
		
		/**
		 * �����������������߳������������߳������Ҵ������̴߳��ڿ��е������ʱ�䣬��ʱ������
		 */
		long keepAliveTime = 60;
		
		/**
		 * ʱ��ö���࣬�ṩ������-�췶Χ��ö��ֵ�Լ���ͬ������λ֮���ת������
		 */
		TimeUnit timeUnit = TimeUnit.SECONDS;
		
		/**
		 * �����߳���<��ǰ�߳���<����߳���ʱ����������������ö��У�����������ʱ��ȡ����ͷ���񲢴����߳�ִ������
		 * ����BlockingQueue�����ڲ����ݽṹ��
		 *     ArrayBlockingQueue�����飬ʵ����ʱ��Ҫ����capacity���н���У���Ϊcapacity
		 *     LinkedBlockingQueue������ʵ����ʱ��ѡ���Ƿ�ָ��capacity��δָ��Ĭ��Integer.MAX_VALUE���޽����
		 *     PriorityBlockingQueue������ṹ��С����
		 *     DelayQueue�����ȶ��У�����delayʱ����������
		 */
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);
		
		ThreadFactory factory = r -> {
		    Thread thread = new Thread(r);
		    thread.setUncaughtExceptionHandler((t, e) -> System.out.println(t.getName() + e.getMessage()));
		    return thread;
		};
		
		RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, timeUnit, workQueue, factory, handler);
		return executor;
	}
}
