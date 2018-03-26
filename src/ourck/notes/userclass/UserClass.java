package ourck.notes.userclass;

/* 当尝试用内部类声明对象时
 * 需要一个其外部类的实例化对象
 */

public class UserClass {
	
	public class Man{
		int age = 0;
	}
	
	public static void main(String[] args) {
		/*
		 * Error e.g.
		 * 
		Man man1;
		man1.age = 16;	
		System.out.println(man1.age);
		
		  * 'man1' : Data space unallocated.
		  */
		
		UserClass Class1 = new UserClass();
		Man man2 = Class1.new Man();
		//Instead of : 'Man man2 = new Man();'
		
		man2.age = 16;
		System.out.println(man2.age);
	}

}
