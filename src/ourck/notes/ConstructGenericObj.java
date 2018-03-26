package ourck.notes;
/*-------------------------------------
 *	OURCK - 构造泛型对象
 *	2018年3月25日 下午1:01:51
 *-------------------------------------

/* 
 * 众所周知，为了向前兼容，Java中的泛型是带有类型擦除的。
 * 只有这样，才能让JSE旧版本中的非泛型类库与新版本中的泛型机制有一个良好的过渡（P376）
 * 
 * 既然擦出了关于泛型的类型信息，就不能使用new来创建泛型对象。
 * 这个时候，较底层的反射机制就有用了：
 */

class Sample {}

class Foo<T> {
//	public T obj2 = new T(); 					//1.Compile error.
	public T obj;
	public Foo(Class<T> cls) { 					//4.综上123，只能手动传入类型信息了。
												//	这样做也是符合逻辑的：因为既然已经声明使用了这个类，
												//	就说明T的类型客户自己心知肚明。
												//	再顺便传个已知类型的Class问题肯定不大（就是显得罗嗦）
		try { 
//			Class<T> cls2 = T.class;			//2.参数化类型似乎不能直接获取class对象;
//			Class<T> cls3 = obj.getClass();		//3.public final Class<?> getClass()：
												//	对于通配符"?"类型擦除到上界Object，
												//	而Class<? extends Object>当然不能转换为Class<T>
//			obj = obj.getClass().newInstance();	//	这样当然也不行：Object -\-> T.即便 obj.getClass()没问题。
			obj = cls.newInstance();
		} 
		catch (Exception e) { throw new RuntimeException(e); }
	}
}


public class ConstructGenericObj {
	public static void main(String[] args) {
		Foo<Sample> Foo1 = new Foo<Sample>(Sample.class);
		System.out.println(Foo1.obj.getClass().getSimpleName());
	}
}
