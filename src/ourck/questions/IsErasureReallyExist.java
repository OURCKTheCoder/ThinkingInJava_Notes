//: generics/ArrayMaker.java
package ourck.questions;
/*-------------------------------------
 *	OURCK - 类型擦除真的存在吗？
 *	2018年3月25日 下午5:18:46
 *-------------------------------------

/* 
 * 源文件来源见最上面。
 * 阅读代码。
 */

import java.lang.reflect.*;
import java.util.*;

public class IsErasureReallyExist<T> {
  private Class<T> kind;
  public IsErasureReallyExist(Class<T> kind) { this.kind = kind; }
  @SuppressWarnings("unchecked")
  T[] create(int size) {
    return (T[])Array.newInstance(kind, size);
  }
  
  /*
   * P378上面说：“即使被存储为Class<T>，擦除也意味着他实际将被存储为Class，
   * 因此Array.newInstance没有kind的类型信息。“
   * 
   * 可是看看Array.newInstance的JDK文档：
     	public static Object newInstance(Class<?> componentType, int length)
   * 里面的参数：
       	Class<?> componentType
   * 难道不应该是这句话导致类型信息的丢失吗？（通配符导致擦除到Object）
   * 那么实际上kind究竟有没有类型信息？
   * 
   * （注：IDE调试时发现kind里面存有类型信息。这能说明这一问题吗？）
   * 
   * 下面这个方法是后来加进去的。能看到对其进行测试后，
   * kind确确实实返回了正确类型的对象。这一点跟容器的泛型应该是一样的。
   */
  T retOneObj() { 
	  try {
		  return kind.newInstance();
	  } catch (InstantiationException | IllegalAccessException e) {
		  throw new RuntimeException(e);
	  }
  }
  
  public static void main(String[] args) {
    IsErasureReallyExist<Sample> stringMaker =
      new IsErasureReallyExist<Sample>(Sample.class);
    Sample[] stringArray = stringMaker.create(9);
    System.out.println(Arrays.toString(stringArray));
    
    System.out.println(stringMaker.retOneObj());
  }
} 

class Sample {}

/*
 * 综上，问题如下：
 * 1.kind究竟有没有保存有类型信息？如果否，那调试时kind里面存有的“类型信息”是什么？
 * 2.如果真的已经擦除了类型信息，那么那一大堆容器们如何返回正确的对象？
 */

/*
 * 解答：
 * 对于1.，不知道。
 * 对于2.,实际上的过程是这样的：
 * 		<T> --> Object --> (T)Object
 * 			^运行时		^编译器自动加上的
 * 记住：泛型中的所有动作都发生在边界处。
 * 		对传递进来的值作额外的编译器检查，并插入对传递出去的值的类型。
 */