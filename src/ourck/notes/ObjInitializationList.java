package ourck.notes;
/*---------------------------------
 *	OURCK - 对象 & 成员的初始化语句块
 *	2018年2月4日 下午10:19:46
 *---------------------------------

/* 
 * 1.介绍静态 / 非静态类成员的初始化方法，及其初始化语句块语法；
 * 2.介绍数组型自定义类对象的初始化方法
 */

class SampleClassForAry{
	String str;
	SampleClassForAry(String str) {
		this.str = str;
	}
	void show(){
		System.out.println(str);
	}
}

class ClassWithMembers{
	String str1;
	String str2;
	//非静态成员初始化语句块：
	{
		str1 = "Some text here.";
		str2 = "Some text here.";
	}
	
	static String str3;
	static String str4;
	//静态成员初始化语句块：
	static {
		str3 = "Some text here.";
		str4 = "Some text here.";
	}	
}

public class ObjInitializationList {
	public static void main(String[] args) {
		//数组类对象初始化长这样：
		SampleClassForAry[] objs = new SampleClassForAry[] {
			new SampleClassForAry("txt1"),
			new SampleClassForAry("txt12221211"),
		};
		
		for(SampleClassForAry obj : objs) {
			obj.show();
		}
	}
}