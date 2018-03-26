package ourck.notes.userclass;

public class StaticVarient {
	private static int staticInt = 2;
	private int random = 2;

	public StaticVarient() {
		staticInt++;
		random++;
	}

	public static void main(String[] args) {
		//1.类变量（静态变量）与对象变量的值变化
		StaticVarient test = new StaticVarient();
		System.out.println("  实例1的staticInt:" + test.staticInt + "----random:" + test.random);
		StaticVarient test2 = new StaticVarient();
		System.out.println("  实例2的staticInt:" + test.staticInt + "----random:" + test.random);
		
		//2.静态变量赋值
		System.out.println("  静态语句块起作用:" + A.staticA);
		A a = new A();
		System.out.println("  构造器起作用:" + a.staticA);
		a.toChange();
		System.out.println("  静态方法1起作用:" + A.staticA);
		a.toChange2();
		System.out.println("  静态方法2起作用:" + A.staticA);
			/*
			 * 给静态变量赋值有三种办法：
			 * 1.静态语句（块）；
			 * 2.构造方法（又称类的构造器）；
			 * 3.静态方法；
			 */
		
		//3.常量赋值
		System.out.println("  静态语句赋值:" + B.staticB);
			/*
			 * 给（静态）常量赋值有一种办法：
			 * 1.静态方法；
			 */
	}
}

class A { 
	public static  String  staticA ="A" ;  
	
	//通过静态语句块修改值 
	static{  staticA ="A1"; } 
	
	//通过构造器修改值
	public A (){  staticA ="A2"; } 
	
	//通过静态方法
	public static void toChange(){  staticA ="A3"; } 
	public static void toChange2(){  staticA ="A4"; }  
}

class B { 
	public static final String  staticB ;  // 声明与赋值分离 
	static{  staticB ="B"; }
}

