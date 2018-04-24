package ourck.questions;
/* OURCK - 子类对象中是否存在有父类对象？
 * 
 * 阅读代码，观察输出，回答问题。
 */

public class IsAParentObj_ExistsIn_ChildObj{
	public static void main(String[] args) {
		SubClass subObject = new SubClass();
		subObject.fun();
		
//		System.out.println();
//		SuperClass superClass = new SuperClass();
//		superClass.fun();
	}
}

abstract class SuperClass {
	private String className = getClass().getSimpleName();
//	private String className = this.getClass().getSimpleName();
//执行结果一样 → 发现2
	public SuperClass() {
		System.out.println("SuperClass.Constructing!");
	}
	
	public void fun() {
		System.out.println("SuperClass:" + className + " " + toString());
	}
}

class SubClass extends SuperClass {
	public SubClass() {
		System.out.println("SubClass.Constructing!");
	}
	
	public void fun() {
		super.fun();
		System.out.println("SubClass:" + getClass().getSimpleName() + " " + toString());
	}
	
}

/* 结果：从子类的fun()对父类的fun()的调用——通过super.fun()——之中，发现了它访问到了父类中private变量的值。 */

/* 但很奇怪：这也就是说创建子类对象时也创建了一个父类对象？要么依据“private不继承”的原则，
 * 			怎么会存在这样一个private对象呢？
 * 			子类当中并没有显示的声明这样一个private变量，那这个private变量是哪里来的？
 */

/* 问题1：super关键字究竟是什么样一个东西？是指向某个对象的引用吗？
 * 问题2（#重点）：为什么父类的private成员可以在子类中通过super关键字的fun方法获得？
 * 				 子类的对象中存在这一个private成员吗？
 *				 或者：子类对象中存在这样一个“父类子对象”吗？
 */

/* 发现1：调试时，this关键字在“变量”透视图中有值，而super没有；
 * 发现2：虽说从子类对象中通过get方法访问到了private变量，但它的初始化赋值时却不是父类对象的信息而是子类的；
 * 发现3：子类对象调用自己的fun()和父类的fun()时，toString()返回的值一样；
 * 发现4：通过像C++一样的方法，加入构造函数，使其在构造对象时输出信息。
 * 			这么做以后，发现在子类对象构造时，父类的构造函数也被调用了。
 * 			（无论父类是不是抽象类！但抽象类不能创建对象？？）
 * 发现5（#重要）：方法super.equals(this)返回真值！
 */

/* 解答发现2、3：猜测执行toString()时实际上是this.toString()，而this当然就是那个子类对象；
 * 				因此不管是在哪里写toString()，通过子类执行fun()和super.fun()结果都一样；
 * 解答问题1：
 * 解答问题2：应该是没有这样一个“父类子对象”的。（待验证）
 * 			(验证完成：通过javap反编译，看到这个子类.class文件既没有父类子对象，也没有从父类拷贝来任何的private成员)
 * 			一种通用的说法是：
 * 			
 * 			“在生成子类对象时，
 * 			会将父类的 所有[1] 已声明的 数据域[2] 拷贝一份给子类
 * 			与此同时，对于自父类继承而来的访问受限的成员（比如private），
 * 			也只有自父类继承而来的方法能访问。”
 * 				[1]“所有”：包括private。
 * 							是的，“private不继承”是假的，
 * 							逻辑上不继承，在实现上还是偷偷复制了一份。
 * 				[2]"数据域"：强调不包括方法
 */

