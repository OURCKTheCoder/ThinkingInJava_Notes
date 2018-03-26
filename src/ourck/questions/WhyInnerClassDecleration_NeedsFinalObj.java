package ourck.questions;
/*-------------------------------------
 *	OURCK - 匿名内部类要求引用final外部对象
 *	2018年2月27日 下午4:28:35
 *-------------------------------------

/* 
 * [!] 注意：在JAVA8中已没有这个限制，官方发了语法糖。
 * 			等效final也被允许，因此不必手动强制性添加final关键字。
 * 			因此，以下内容可能不再生效。
 * 匿名内部类在引用外部对象时，必须是final的。
 */

interface B{
	void doSomething();
}

class A{
	final int mustFinal = 7;
	void show() { System.out.println(mustFinal); }
	B retAObj() {
		return new B() { 
			//  ^	这里生成的不是接口类型的对象，而是实现了接口的那个匿名类型的对象。
			public void doSomething() {
				System.out.println(mustFinal);//<-这个mustFinal必须是final类型。
//				mustFinal++;
			}
		};//分号！！
	}
}

/* 
 * Java中，对“闭包”的支持是不完整的。
 * 在上文中，与其说A对doSomething()形成闭包，不如说doSomething()自成闭包。
 * 因为，在Java编译器看来，那段初始化表达式实际上是：
 * 	return new B() { 
		public void doSomething() {
					int COPY_mustFinal = mustFinal //[!]
			System.out.println(COPY_mustFinal);
		}
	};
 * 编译器实际上在构造新匿名类时，
 * 其实是capture-by-value，并没有实现的capture-by-reference。
 * 这个mustFinal外部变量是作为参数传入的。
 * 
 * 而只有后者，才能保证一个变量的值在内外都是同步的，不幸的是，JAVA只做到了前者。
 * （比如，在内部类过某个方法修改了值，在外部是没有改变的，可以试试——结果：在JAVA8中，成功更改了？？？）
 * （这说明JAVA8不再是这种形势初始化匿名类了？？？？）
 * 但Java又不肯明说，只能粗暴地一刀切，就说既然内外不能同步，那就不许大家改外围的局部变量。
 */

public class WhyInnerClassDecleration_NeedsFinalObj{
	
	public static void main(String[] args) {
		A obj = new A();
//		obj.show();
		obj.retAObj().doSomething();
//		obj.show();
	}
	
}