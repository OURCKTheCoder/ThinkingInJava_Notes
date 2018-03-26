package ourck.notes;
/*---------------------------------
 *	OURCK - 在JAVA中手动删除对象
 *	2018年2月4日 下午10:15:16
 *---------------------------------

/* 
 * 当不适合使用System.gc()时，就需要手动删除已存在对象。
 * 几点提示：
 * 1.不要使用finalize(),因为他并不总是执行；
 * 2.注意删除的顺序与创建对象的顺序 两者之间的关系
 */
public class ManualFinalize {

	public static void main(String[] args) {
		Stem s = new Stem();
		s.dispose();

	}

}

class Root{
	Component1 cp1 = new Component1();
	Component2 cp2 = new Component2();
	Component3 cp3 = new Component3();
	
	public Root(){
		System.out.println("Root...");
	}
	void dispose() {
		cp3.dispose();
		cp2.dispose();
		cp1.dispose();
		System.out.println("Root...Disposed!");
	}
}

class Stem extends Root{
	Component1 cp1 = new Component1();
	Component2 cp2 = new Component2();
	Component3 cp3 = new Component3();
	
	public Stem() {
		System.out.println("	Stem...");
	}
	void dispose() {
		cp3.dispose();
		cp2.dispose();
		cp1.dispose();
		super.dispose();
		System.out.println("	Stem...Disposed!");
	}
}

class Component1{
	public Component1() {
		System.out.println("-Component1...");
	}
	void dispose() {
		System.out.println("-Component1...Disposed!");
	}
}

class Component2{
	public Component2() {
		System.out.println("-Component2...");
	}
	void dispose() {
		System.out.println("-Component2...Disposed!");
	}
}

class Component3{
	public Component3() {
		System.out.println("-Componen3...");
	}
	void dispose() {
		System.out.println("-Component3...Disposed!");
	}
}
