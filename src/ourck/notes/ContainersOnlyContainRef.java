package ourck.notes;
/*-------------------------------------
 *	OURCK - 容器中添加的是引用而非对象本身
 *	2018年3月7日 下午10:24:05
 *-------------------------------------

/* 
 * 阅读代码，观察输出。
 */
import java.util.*;

public class ContainersOnlyContainRef {

	public static void main(String[] args) {
		
		System.out.println();
		
		HashMap<String, ArrayList<String>> nickName2 = new HashMap<String, ArrayList<String>>();
		String nknm2 = "OURCK";
		ArrayList<String> nm2 = new ArrayList<String>();
		nm2.add("CK");
		nickName2.put(nknm2, nm2);
		System.out.println(nickName2);
		
		nm2.add("I'm NOT CK!");
		System.out.println(nickName2);
		/*
		 * 能通过在外部修改列表、并且不将它再次加入Map中，
		 * 就能对Map的输出产生影响。
		 * 因此猜测：“容器嵌套容器”的情形仅仅只是在外层容器中记录了内层容器对象的引用。
		 */
		
		System.out.println();
		
		HashMap<String, MyStr> nickName3 = new HashMap<String, MyStr>();
		String nknm3 = "OURCK";
		MyStr nm3 = new MyStr("CK");
		nickName3.put(nknm3, nm3);
		System.out.println(nickName3);

		nm3.modify("I'm NOT CK!");//new MyStr("I'm NOT CK!");
		System.out.println(nickName3);
		/*
		 * 当然，对于自定义类型也是如此。
		 * 但是这样就不一样了：
		
		nm3 = new MyStr("I'm NOT CK!");
		System.out.println(nickName3);
		
		 * 这一语句只是将nm3指向了一个全新对象的引用，
		 * 原先的nm3仍存在（并且没被gc）
		 * 因此这样不影响输出。
		 */
		
		System.out.println();
		
		HashMap<String, String> nickName = new HashMap<String, String>();
		String nknm = "OURCK";
		String nm = "CK";
		nickName.put(nknm, nm);
		System.out.println(nickName);
		
		nm = "I'm NOT CK!";
		System.out.println(nickName);
		/*
		 * 对于String等基本类型，容器放入的似乎是String对象的值，
		 * 但是别忘了，String类被final修饰，
		 * 因此
		 
		 nm = "I'm CK!";
		 
		 * 这一语句正如上段所述，仅仅只是指向了一个新对象的引用而已，且原先的对象仍存在。
		 */
	}

}

class MyStr{
	private String str;
	MyStr(String str){
		this.str = str;
	}
	public String toString() {
		return str;
	}
	public void modify(String str) {
		this.str = str;
	}
}
