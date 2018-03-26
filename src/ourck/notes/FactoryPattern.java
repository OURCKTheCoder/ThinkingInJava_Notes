package ourck.notes;
/*-------------------------------------
 *	OURCK - 更形象生动的“工厂(factory)”设计模式
 *	2018年2月23日 下午5:22:33
 *-------------------------------------

/* 
 * 原文实在太生涩难懂。。。搞了个铅笔版本的。
 * 彩色铅笔有两种：红和绿
 * 生产厂家：中华和辉柏嘉
 */

interface Pen{
	void write();
	void erase();
}

interface PenFactory{
	Pen produceAPen();
}

class RedPen implements Pen{
	public void write() { System.out.println("Write a RED line!"); }
	public void erase() { System.out.println("Erase!"); }
}

class GreenPen implements Pen{
	public void write() { System.out.println("Write a GREEEEEN line!"); }
	public void erase() { System.out.println("Erase!"); }
}

class Zhonghua implements PenFactory{
	public Pen produceAPen() { return new RedPen(); }
}

class Huibaijia implements PenFactory{
	public	Pen produceAPen() { return new GreenPen(); }
}

public class FactoryPattern{

	public static void getSampleFrom(PenFactory fact){
		//Pen SamplePen = new RedPen();或+
		//Pen SamplePen = new GreenPen();
		//↑不用“工厂”设计模式则只能编译时就确定类型
		Pen SamplePen = fact.produceAPen();
		SamplePen.write();
		SamplePen.erase();
	}
	
	public static void main(String[] args){
		FactoryPattern.getSampleFrom(new Zhonghua());
		FactoryPattern.getSampleFrom(new Huibaijia());
	}
}

