package ourck.questions;
/*OURCK - finalize()何时执行？
 * 
 * 阅读代码，观察输出，回答问题。
 */
public class Tank {

	boolean IsEmpty;
	
	@Override
	protected void finalize() throws Throwable {
		if(IsEmpty){
			System.out.println("Ready to be deleted...");
			super.finalize();
		}
		else {
			System.out.println("Error: Tank is not empty!");
		}
	}
	
	Tank(){IsEmpty = false;}
	
	public void useUp() {IsEmpty = true;}
	
	public static void main(String[] args) {
		Tank tank = new Tank();
		tank.useUp();
		new Tank();
		System.gc();
	}

}
/* 问题：如何在调用System.gc()时执行finalize()内容？似乎有时（比如第一次）是不执行的？ */

