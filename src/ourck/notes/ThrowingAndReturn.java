package ourck.notes;
/*-------------------------------------
 *	OURCK - 方法的返回和异常抛出
 *	2018年3月22日 上午9:58:02
 *-------------------------------------

/* 
 * 具有返回值的方法，要么返回值，要么抛出异常并中断。
 * 阅读代码。
 */
public class ThrowingAndReturn {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}

class SampleClass{
	
	private Integer getNumAndThrowExp() throws Exception { //假装能抛出异常
		return 7;
	}
	
	public Integer willThrow() throws Exception{
		try {
			return getNumAndThrowExp();
		} catch (Exception e) {
			/*
			 * 这里必须对方法抛出的异常进行处理。
			 * 所谓“处理”，并不只是进行一些简单操作（比如printStackTrack)就完事。
			 * 程序既然运行到这里，就说明try块内的getNumAndThrowExp()已经抛出异常，
			 * 并且已经中断。
			 * 
			 * 这样一来，将导致getNumAndThrowExp()方法不产生Integer类型的返回值，
			 * 也就造成willThrow()方法不能产生合法的返回。
			 * 
			 * 正确的“处理”，应该是在catch块内也抛出异常，
			 * new 了一个Exception后程序不会执行下去了，而是处理该异常了。
			 * 这么做才会中断当前willThrow()方法的运行，并通知外层的异常处理程序。
			 * 
			 * 异常链是个好东西，无论是从逻辑上还是从程序健壮性上来看。
			 */
			throw new Exception(); // <- Like this.
		}
	}
}
