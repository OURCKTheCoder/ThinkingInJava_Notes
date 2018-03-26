package ourck.notes.userclass;

/* 
 * 抽象类就是专门用来被继承的
 * 因此在本段代码中 尝试在抽象类中统一使用protected关键字修饰
 */

public class AbstractClass {

	public static void main(String[] args) {
		WoodenDoors wd1 = new WoodenDoors();
		PrisonDoors pd1 = new PrisonDoors();	
		
		wd1.open();
		wd1.isDoorOpen();
		wd1.close();
		wd1.isDoorOpen();
		
		System.out.println("-------------");
		pd1.open();
		pd1.isDoorOpen();
		pd1.close();
		pd1.isDoorOpen();

	}

}

abstract class Doors{
	protected boolean openFlag = false;
	/* protected enum locks{ ironLock , WoodenLock , noLock };
	 * protected locks defaultLock = locks.noLock;
	 * 尝试在子类中继承枚举类时失败：枚举类的构造器私有（？）
	 */
	
	//抽象方法是一种没有任何实现的方法，该方法的的具体实现由子类提供。
	//任何继承抽象类的子类必须实现父类的所有抽象方法，除非该子类也是抽象类。 
	abstract void open();
	abstract void close();
	//抽象类内允许有非抽象方法；反之有抽象方法的类必定为抽象类
	protected boolean isDoorOpen() {
		if(openFlag == true) return true;
		else return false;
	}

}

class WoodenDoors extends Doors{	
	void open() {
		openFlag = true;
	};
	void close() {
		openFlag = false;
	};
}

class PrisonDoors extends Doors{
	void open() {
		openFlag = false;
		System.out.println("Keys needed!");
	}
	void close() {
		openFlag = false;
	}
}

