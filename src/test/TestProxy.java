package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * ҵ��ӿ�
 * @author yinzixian
 *
 */

interface ProxyService {
	void service() throws Exception;
}

/**
 * ҵ��ʵ����
 * @author yinzixian
 *
 */

class ProxyServiceImpl implements ProxyService{

	@Override
	public void service() throws Exception {
		System.out.println("Service Implements");
		throw new Exception();
	}
	
}

/**
 * 1.��̬����
 * @author yinzixian
 *
 */

class StaticProxyServiceImplProxy implements ProxyService{

	private ProxyService servicveImpl;
	public StaticProxyServiceImplProxy(ProxyService servicveImpl) {
		this.servicveImpl = servicveImpl;		
	}
	@Override
	public void service() throws Exception {
		before();
		servicveImpl.service();
		after();
	}
	private void before() {
		System.out.println("StaticProxy: Before Service");
	}
	private void after() {
		System.out.println("StaticProxy: After Service");
	}
}

/**
 * 2.��̬����
 * @author yinzixian
 *
 */

class MyProxyHandler implements InvocationHandler {
	private Object target;

	public MyProxyHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		before();
		
		Object obj = method.invoke(target, args);
		
		after();
		
		return obj;
	}
	private void before() {
		System.out.println("DynamicProxy: Before Service");
	}
	private void after() {
		System.out.println("DynamicProxy: After Service");
	}
}


/**
 * 3.��̬����ģ��AOP
 * @author yinzixian
 *
 */

//֪ͨ�ӿ�
interface Advice {
	abstract void before();
	abstract void after();
	abstract void end();
	abstract void arround();
	abstract void exception();
}

//֪ͨĬ��ʵ����
class DefaultAdvice implements Advice {

	@Override
	public void before() {
		
	}

	@Override
	public void after() {
		
	}

	@Override
	public void end() {
		
	}

	@Override
	public void arround() {
		
	}

	@Override
	public void exception() {
		
	}
	
}

//����handler
class ProxyInActionHandler implements InvocationHandler {

	private Object target;
	
	public ProxyInActionHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		List<Advice> adviceChain = TestProxy.AdviceUtil.adviceMap.getOrDefault(target.getClass().getCanonicalName() + "." +method.getName(), new ArrayList<>());
		if(adviceChain.isEmpty())
			method.invoke(target, args);	
		else proceed(target, method, args, adviceChain.iterator());
		return null;
	}
	
	private void proceed(Object target, Method method, Object[] args, Iterator<Advice> adviceChain) throws Throwable{
		if(adviceChain.hasNext()) {
			Advice advice = adviceChain.next();
			try {
				advice.arround();
				advice.before();
				proceed(target, method, args, adviceChain);
				advice.after();
				advice.arround();
			} catch (Throwable t){
				advice.exception();
				throw t;
			} finally {
				advice.end();
			}
		}
		else 
			method.invoke(target, args);	
	}
}


public class TestProxy {
	
	//���Ӻ��Ƴ�֪ͨ������
	static class AdviceUtil {
		public static Map<String, List<Advice>> adviceMap = new HashMap<>();	
		
		static <T> void add(Class<T> clazz, String methodNameReg, Advice advice) {
			String className = clazz.getCanonicalName();
			List<Advice> adviceList;
			for(Method method : clazz.getMethods()) {
				String methodName = method.getName();
				if(!methodName.matches(methodNameReg))
					continue;
				adviceList = adviceMap.get(className +"."+ methodName);
				if(adviceList == null) {
					adviceList = new ArrayList<>();
					adviceMap.put(className +"."+ methodName, adviceList);
				}
				adviceList.add(advice);
			}
		}

		static <T> void remove(Class<T> clazz, String methodNameReg, Advice advice) {
			String className = clazz.getCanonicalName();
			List<Advice> adviceList;
			for(Method method : clazz.getMethods()) {
				String methodName = method.getName();
				if(!methodName.matches(methodNameReg))
					continue;
				adviceList = adviceMap.getOrDefault(className +"."+ methodName, new ArrayList<Advice>());
				adviceList.remove(advice);
			}
		}
	}
	public static void main(String[] args) {
		/**
		 * ��̬�������
		 */
		System.out.println("*************************************");
		
		//��ȡ��ʵ��
		ProxyService staticService = new ProxyServiceImpl();
		
		//��ȡ����ʵ��
		StaticProxyServiceImplProxy staticProxy = new StaticProxyServiceImplProxy(staticService);
		
		//ִ�д�����
		try {
			staticProxy.service();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		
		/**
		 * ��̬�������
		 */
		System.out.println("*************************************");
		
		//��ȡ��ʵ��
		ProxyService dynamicService = new ProxyServiceImpl();
		
		//��ȡӦ�ó����������,�ɸ���˫��ί�ɻ��ƶ�����м���
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		
		//��ȡ����handler
		MyProxyHandler handler = new MyProxyHandler(dynamicService);
		
		//��ȡ�������
		ProxyService dynamicProxy = (ProxyService)Proxy.newProxyInstance(loader, dynamicService.getClass().getInterfaces(), handler);
		
		try {
			dynamicProxy.service();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		
		/**
		 * ��̬����ģ��AOP����
		 */
		System.out.println("*************************************");
		
		//��ȡ��ʵ��
		ProxyService serviceInAction = new ProxyServiceImpl();

		//��ȡӦ�ó����������,�ɸ���˫��ί�ɻ��ƶ�����м���
		ClassLoader loaderInAction = ClassLoader.getSystemClassLoader();
		
		//��ȡ����handler
		ProxyInActionHandler handlerInAction = new ProxyInActionHandler(serviceInAction);
		
		//��ȡ�������
		ProxyService proxyInAction = (ProxyService) Proxy.newProxyInstance(loaderInAction, serviceInAction.getClass().getInterfaces(), handlerInAction);
		
		//��������֪ͨ
		AdviceUtil.add(ProxyServiceImpl.class, "service", new DefaultAdvice() {			
			@Override
			public void before() {
				System.out.println("override before advice111");
			}
			@Override
			public void after() {
				System.out.println("override after advice111");
			}
		});
		AdviceUtil.add(ProxyServiceImpl.class, "service", new Advice() {		
			@Override
			public void before() {
				System.out.println("override before advice222");
			}
			@Override
			public void after() {
				System.out.println("override after advice222");			
			}
			@Override
			public void end() {
				System.out.println("override end advice222");				
			}
			@Override
			public void arround() {
				System.out.println("override arround advice222");				
			}
			@Override
			public void exception() {
				System.out.println("override exception advice222");				
			}			
		});
		try {
			proxyInAction.service();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		
	}

}