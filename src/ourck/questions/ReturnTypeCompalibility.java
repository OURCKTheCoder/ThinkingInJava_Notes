package ourck.questions;
/*-------------------------------------
 *	OURCK - 继承中方法必须返回类型兼容？
 *	2018年2月9日 下午8:43:16
 *-------------------------------------

/* 
 * 阅读代码，回答问题。
 */
public class ReturnTypeCompalibility {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}

class Farm{
	Tree plant() {
		Tree tree = new Tree();
		tree.grow();
		return tree;
	}
}

class BigFarm extends Farm{
	AppleTree plant() {
		AppleTree apt = new AppleTree();
		apt.grow();
		return apt;
	}
}
 
class Tree{
	public void grow() {
		System.out.println("Growing...");
	}
}

class AppleTree extends Tree{
	public void grow() {
		System.out.println("Growing...With an apple!");
	}
}

/*
 * 问题：不能将BigFarm类中的方法plant()重写为具有别的返回类型，
 * 		必须与父类的返回类型“相兼容”（相同、可转换、可向上转型）
 * 		为什么？
 * 
 * 解答：因为这样会造成二义性
 * 		试想，假设真能像上面那样重写方法，把Tree plant()重写为void plant()，
 * 		调用BigFarm.plant()时，是指以上的那一个方法呢？
 */
 
/*
 * 另一方面，上面把Tree plant()重写为AppleTree plant()的做法，实际上正是利用了JSE5中
 * 所谓的”协变返回类型“特性：它允许 导出类的被覆盖方法 指定一个基类版本方法的返回类型 的子类型返回值。
 * 
 * 当调用BigFarm.plant()时，由于：
 * 1.AppleTree可向上转型为Tree
 * 2.或说Tree的一个子类为AppleTree
 * 3.——又或者说AppleTree是一种Tree，它具有Tree该具有的特征。（够通俗了）
 * 因此编译器接受这种重写方式，
 * 也将返回一个AppleTree引用
 * 
 * 不过注意一点：上面的例子中，
 * 如果这样改：
class Farm{
	AppleTree plant() {...}
}

class BigFarm extends Farm{
	Tree plant() {...}
}
 * 是错误的。
 * 根据”子类返回相兼容于父类“的规则，若是子类返回一个Tree引用，
 * 这个Tree可以是PineappleTree、MelonTree或者别的什么Tree——不一定是AppleTree。
 * （通俗点说，AppleTree是Tree，但Tree不是AppleTree。）
 * 即：返回类型不是基类版本方法的返回类型的子类，不能兼容。
 */

