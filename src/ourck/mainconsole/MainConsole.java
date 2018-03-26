package ourck.mainconsole;

public class MainConsole<T> {
	
	private Class<T> cls;
	
	MainConsole(Class<T> cls) { this.cls = cls; } 
	
	public void show() { 
		System.out.println(cls);
		try {
			System.out.println(cls.newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MainConsole<Sample> m = new MainConsole<Sample>(Sample.class);
		m.show();
	}
	
}

class Sample {}