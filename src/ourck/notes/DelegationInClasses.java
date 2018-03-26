package ourck.notes;

/*---------------------------------
 *	OURCK - 代理
 *	2018年2月4日 下午10:19:04
 *---------------------------------

/* 
 * 介于组合和继承之间的一种类间关系，
 * 通过接口外再嵌套一层接口实现：层间通信、灵活调用等。
 * 
 * Tips:IDE中直接照着大纲看更省事。
 */
import static net.mindview.util.Print.*;

class Cleanser {

	private String s = "Cleanser";
	
	public void append(String a) { s += a; }
	
	public void dilute() { append(" dilute()"); }
	
	public void apply() { append(" apply()"); }
	
	public void scrub() { append(" scrub()"); }
	
	public String toString() { return s; }
	
	public static void main(String[] args) {
	  Cleanser x = new Cleanser();
	  x.dilute(); x.apply(); x.scrub();
	  print(x);
	}
}	

public class DelegationInClasses{

	Cleanser cleanser = new Cleanser();
	
	public void dilute() {
		cleanser.dilute();
	}
	
	public void apply() {
		cleanser.apply();
	}
	
	public void scrub() {
	  cleanser.scrub();
	}
	
	public String toString() {
		return new String("Detergent - delegates Cleaners." + "\n" + cleanser);
	}
	
	public void foam() { cleanser.append(" foam()"); }
	
	public static void main(String[] args) {
	  DelegationInClasses x = new DelegationInClasses();
	  x.dilute();
	  x.apply();
	  x.scrub();
	  x.foam();
	  print(x);
	  print();
	  print("(Testing base class:)");
	  Cleanser.main(args);
	}	
}
