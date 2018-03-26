package ourck.notes.userclass;

public class VarientInClass {

	public static void main(String[] args) {
		//1.可访问性测试
		int a = Consts.i;
//!		int b = Consts.j;
		
		//2.静态变量属于类 不需要生产对象即可直接通过类名引用
		int c = Consts.h;
//!		int d = Consts.k;
			/* 然而 非静态变（常）量可以通过 类的实例化对象 来访问 */
		Consts d1 = new Consts();
		int e = d1.k;
		
		
	}

}

class Consts{
	//1.可访问性测试
	public static int i = 100;
	private static int j = 101;
	
	//2.静态变量属于类 不需要生产对象即可直接通过类名引用
	public static final int h = 100;
	public final int k = 100;
	
	//3.实例变量1 & 静态变（常）量2、3
	public int object1;
	public static int object2;
	public static final int object3 = 6;
		/* 无论一个类创建了多少个对象，类只拥有静态变（常）量的一份拷贝。 */
		/* 实例变量属于某个对象的属性，必须创建了实例对象，
		 * 其中的实例变量才会被分配空间，才能使用这个实例变量。
		 * 不过当然实例变量能直接在类内部被访问。 */
		/* 静态变量不属于某个实例对象，而是属于类，所以也称为类变量，
		 * 只要程序加载了类的字节码，不用创建任何实例对象，
		 * 静态变量就会被分配空间，静态变量就可以被使用了。 */
	
}
