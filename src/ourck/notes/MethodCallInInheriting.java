package ourck.notes;
/*-------------------------------------
 *	OURCK - 继承技术中的方法调用
 *	2018年2月8日 下午9:35:26
 *-------------------------------------

/* 
 * 在声明对象时，若进行了向上转型，
 * 通过观察那个对象的方法调用语句，能发现 那些在继承中的方法的 实际调用过程。
 * 
 * 先阅读代码：
 */

public class MethodCallInInheriting {	
	
	public static void main(String[] args) {
		Mouse m = new Mouse(); //声明对象时向上转型
		m.eat(); //yummy由Rodent类继承给Mouse类，并在Mouse类中被重写。
	}

}

class Rodent{
	
	public void eat() {
		System.out.println("Rodent.eat()");
	}
	
	public void yummy() {
		eat();
		System.out.println("   -Yummy!");
	}
}

class Mouse extends Rodent{
	
	public void eat() {
		System.out.println("Mouse.eat()");
	}
	
	public void yummy() {
		eat();
		System.out.println("   -Yummy!!!!!!!!!!");
	}
}

/*
 * 提问：如果把Rodent（基类）中的yummy()方法改为private，结果如何？
 * 解答：m.yummy()报错，原因：“Rodent中的yummy()不可视”。
 * 		由此猜测：真正的“通过基类对象执行子类方法”的这一向上转型过程，
 * 		都要走“检查基类的那个被继承方法是否可被访问”这一步。
 */

/*
 * 实际上，如果真把Rodent中的yummy()方法改为private，
 * 这一方法将隐式地成为final的，并且不会继承。
 * 因此子类中的那个叫做“yummy()"的方法，
 * 实际上是一个“全新的方法”。-> TIJ P156
 * 
 * 问题：之前提到，区分方法重载的方法，
 * 		就是看两个方法的特征签名（方法名，返回类型，参数表中参数的顺序，参数的个数）是否一致。
 * 		结果现在，两个同名方法、具有相同返回类型和参数表，照理来说应该是一个方法，
 * 		为什么说子类的那个是一个“全新的方法”？
 * 解决：两个方法在不一样的类中...
 */
