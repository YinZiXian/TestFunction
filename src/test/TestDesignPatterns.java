package test;

/**
 * @author YZX
 * @date 2019��9��9��
 * @time ����8:22:59
 */

public class TestDesignPatterns {

	public TestDesignPatterns() {
		
	}
	
}
//�������ģʽ
//public class Singleton {
//	private Singleton singleton;
//	private Singleton() {}
//	public Singleton getinstance() {
//		if(singleton == null) {
//			singleton = new Singleton();
//		}
//		return singleton;
//	}
//}

//����ʽд�����̰߳�ȫ��
//public class Singleton({
//	private static Singleton singleton;
//	private Singleton () {}
//	puiblic static synchronized Singleton getInstance() {
//		if(singleton == null) {
//			singleton = new Singleton();
//		}
//		return singleton;
//	}
//}

//����ʽд��
//public class Singleton {
//	private static Singleton singleton = new Singleton();
//	private Singleton() {}
//	public static Singleton getInstance() {
//		return singleton;
//	}

//��̬�ڲ���
//public class Singleton{
//	public class SingletonHolder{
//		private static final Singleton INSTANCE = new Singleton();
//		}
//		private Singleton() {};
//		private static final Singleton getInstance() {
//			return SingletonHolder.INSTANCE;
//		}
//}

//ö�ٷ���
//enum Singleton{
//	INSTANCE;
//	public void otherMethods() {
//		System.out.println("Something");
//	}
//}
//public class Hello{
//	public static void main(String[] args) {
//		Singleton.INSTANCE.otherMethods();
//	}
//}

//˫��У������
//public class Singleton{
//	private volatile static Singleton instance;
//	private Singleton() {}
//	private static Singleton getInstance() {
//		if(instance == null) {
//			synchronized (Singleton.class){
//			if(instance == null) {
//				instance = new Singleton();
//				}
//			}
//		}
//		return instance;
//	}
//}

//�۲���ģʽ С��С��С���Ĺ��¡��۲���ʵ�ֽӿڣ����۲��ߵ��ýӿ�

//װ����ģʽ �����ε����� �û�ʹ�õ�ʱ��������װ
//public class Food {
//
//	   private String food_name;
//
//	   public Food() {
//	   }
//
//	   public Food(String food_name) {
//	       this.food_name = food_name;
//	   }
//
//	   public String make() {
//	       return food_name;
//	   };
//	}

//������ģʽ ��ѹ��220V->5V���ֻ����
//public class Test {
//	   public static void main(String[] args) {
//	       Phone phone = new Phone();
//	       VoltageAdapter adapter = new VoltageAdapter();
//	       phone.setAdapter(adapter);
//	       phone.charge();
//	   }
//	}
//
//	// �ֻ���
//	class Phone {
//
//	   public static final int V = 220;// ������ѹ220v����һ������
//
//	   private VoltageAdapter adapter;
//
//	   // ���
//	   public void charge() {
//	       adapter.changeVoltage();
//	   }
//
//	   public void setAdapter(VoltageAdapter adapter) {
//	       this.adapter = adapter;
//	   }
//	}
//
//	// ��ѹ��
//	class VoltageAdapter {
//	   // �ı��ѹ�Ĺ���
//	   public void changeVoltage() {
//	       System.out.println("���ڳ��...");
//	       System.out.println("ԭʼ��ѹ��" + Phone.V + "V");
//	       System.out.println("������ѹ��ת��֮��ĵ�ѹ:" + (Phone.V - 200) + "V");
//	   }
//	}

//����ģʽ
	//�򵥹���ģʽ��һ������Ľӿڣ��������ӿڵ�ʵ���࣬һ�������࣬����ʵ��������Ľӿ�
////�����Ʒ��
//abstract class Car{
//	public void run() ;
//	public void stop() ;
//}
////����ʵ����
//class Benz implements Car {
//	public void run() {
//		System.out.println("Benz555");
//	}
//	public void stop() {
//		System.out.println("Benzyuuuu");
//	}
//}
//class Ford implements Car {
//	public void run() {
//		System.out.println("Ford555");
//	}
//	public void stop() {
//		System.out.println("Fordyuuuu");
//	}
//}
////������
//class Factory{
//	public static Car getCarInstance(String type) {
//		Car c = null;
//		if("Benz".equals(type)) {
//			c = new Benz();
//		}
//		if ("Ford".equals(type)) {
//			c = new Ford();
//		}
//		return c;
//	}
//}
//public class Test{
//	public static void main(String []args) {
//		Car c = Factory.getCarInstance("Benz");
//		if(c != null) {
//			c.run();
//			c.stop();
//		} else {
//			System.out.println("cannot");
//		}
//	}
//}
	//��������ģʽ�����ĸ���ɫ�����󹤳�ģʽ�����幤��ģʽ�������Ʒģʽ�������Ʒģʽ��
		//��������һ��������ȥʵ��������Ĳ�Ʒ�������ɳ��󹤳�������ȥʵ������Ʒ
//�����Ʒ��ɫ
//public interface Moveable {
//void run();
//}
//
////�����Ʒ��ɫ
//public class Plane implements Moveable {
//@Override
//public void run() {
//    System.out.println("plane....");
//}
//}
//
//public class Broom implements Moveable {
//@Override
//public void run() {
//    System.out.println("broom.....");
//}
//}
//
////���󹤳�
//public abstract class VehicleFactory {
//abstract Moveable create();
//}
//
////���幤��
//public class PlaneFactory extends VehicleFactory {
//public Moveable create() {
//    return new Plane();
//}
//}
//
//public class BroomFactory extends VehicleFactory {
//public Moveable create() {
//    return new Broom();
//}
//}
//
////������
//public class Test {
//public static void main(String[] args) {
//    VehicleFactory factory = new BroomFactory();
//    Moveable m = factory.create();
//    m.run();
//}
//}
	//���󹤳�ģʽ �빤������ģʽ��ͬ���ǣ���������ģʽ�еĹ���ֻ������һ�Ĳ�Ʒ��
		//�����󹤳�ģʽ�еĹ������������Ʒ
//���󹤳���
//public abstract class AbstractFactory{
//	public abstract Vehicle createVehicle();
//	public abstract Weapon createWeapon();
//	public abstract Food craeteFood();
//}
////���幤����
//public class DefaultFactory extends AbstractFactory{
//	public Food createFood() {
//		return new Apple();
//	}
//	public Weapon createWeapon() {
//		return new AK47();
//	}
//	public Vehicle createVehicle() {
//		return new Car(); 
//	}
//}
//public class Test{
//	public static void main(String[ args) {
//		AbstractFactory f = new DefaultFactory();
//		Vehicle v = f.createVehicle();
//		v.run();
//		Weapon w = f.createWeapon();
//		w.shoot();
//		Food a = f.craeteFood();
//		a.printName();
//	}
//}

//����ģʽ
//public interface ProxyInterface{
//	void marry();
//}
//public class WeddingCompany implements proxyInterface{
//	private ProxyInterface proxyInterface;
//	public WeddingCompany(ProxyInterface proxyInterface) {
//		this.proxyInterface = proxyInterface;
//	}
//	public void marry() {
//		System.out.println("company working...");
//		System.out.println("company working...");
//		System.out.println("company working...");
//		proxyInterface.marry();
//		System.out.println("company working...");
//		System.out.println("company working...");
//	}
//}
//public class NormalHome implements ProxyInterface{
//	public void marry() {
//		System.out.println("we marry!");
//	}
//}
//public class Test{
//	public static void main(String[] args) {
//		ProxyInterface proxyInterface  = new WeddingCompany(new NormalHome());
//		proxyInterface.marry();
//	}
//}