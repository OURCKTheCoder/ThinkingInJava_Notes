package ourck.notes;
/*-------------------------------------
 *	OURCK - 装饰器设计模式
 *	2018年4月1日 下午2:51:21
 *-------------------------------------

/* 
 * 这一设计模式可以认为是混型的思路拓展。
 * 在装饰器设计模式下，extends关键字表示的含义
 * 不再是A from B，
 * 而是A + B。（所谓“extends（拓展）”）
 * 
 * 另一方面，装饰器本身又是另一个类的代理。
 */

class BlueBerry {
	public void putOnTheCake() {
		System.out.println(" [!]BlueBerry: I'm on the cake!");
	}
}

class BlueBerryDecorator extends BlueBerry {
	BlueBerry blueBerry = new BlueBerry();
	public void goingToPutABerry() {
		blueBerry.putOnTheCake();
		System.out.println("There's a blueberry on this " + this);
	}
	public void putOnTheCake() { // Proxied method.
		blueBerry.putOnTheCake();
	}
}

class BigCake extends BlueBerryDecorator {
	public String toString() { return "BigCake"; }
}

class SmallCake extends BlueBerryDecorator {
	public String toString() { return "SmallCake"; }
}

public class DecoratorPattern {
	public static void main(String[] args) {
		BigCake bc = new BigCake();
		SmallCake sc = new SmallCake();
		
		bc.putOnTheCake(); //putOnTheCake方法来自BlueBerry（通过装饰器这一层代理被重写）
		sc.goingToPutABerry(); //goingToPutABerry方法来自装饰器
	}
}

/*
 * 装饰器设计模式通过在可装饰对象周围添加进需要的事物，
 * 来对这一可装饰对象进行拓展（extends）并对功能分层。
 * 我们可以根据需要来动态地extends一个装饰器，来获得其功能。
 * 
 * 好处？灵活、按需、动态。
 * 缺点？
 * 在逻辑上其实还是基于多重继承来添加功能，因此只有最后拉出来的那一坨东西才有价值。
 * 即：“尽管能添加多个层，但是最后一层才是实际的类型，也只有那一层的方法是可视的”。
 * 
 * 另一方面，混型则可以直接把多个接口和一个类揉合在一起（只经过一层关系），这就显得精准而优雅;
 * 不过缺点也就显现出来：不能直接揉合多个类（除非使用内部类来实现“多重”继承）
 */