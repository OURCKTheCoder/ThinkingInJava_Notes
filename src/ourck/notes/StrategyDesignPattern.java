package ourck.notes;

/*-------------------------------------
 *	OURCK - 策略设计模式
 *	2018年2月19日 下午1:56:04
 *-------------------------------------

/* 
 * 能根据所传递的参数对象不同而具有不同行为的方法，称为“策略设计模式”。
 * 这类方法中包含要执行的算法中固定不变的部分，而根据“策略”（传进的参数）选择变化的部分。
 * 
 * 不同于重载，本例省去了多次编写同一个具有相同特征签名的方法的麻烦，
 * 而是把这种多态交与向上转型来实现。
 * 另一方面，不同的方法实现是在不同的对象（类）中的，
 * 一般的方法重载则是在同一对象中。
 * 
 * “你可以用任何你想要的对象调用我的方法，只要这个对象遵循我的接口。”
 */
import java.util.*;
import static net.mindview.util.Print.*;

class Processor {
  public String name() {
    return getClass().getSimpleName();
  }
  Object process(Object input) { return input; }
}	

class Upcase extends Processor {
  String process(Object input) { // Covariant return
    return ((String)input).toUpperCase();
  }
}

class Downcase extends Processor {
  String process(Object input) {
    return ((String)input).toLowerCase();
  }
}

class Splitter extends Processor {
  String process(Object input) {
    // The split() argument divides a String into pieces:
    return Arrays.toString(((String)input).split(" "));
  }
}	

public class StrategyDesignPattern {
  public static void process(Processor p, Object s) {
    print("Using Processor " + p.name());
    print(p.process(s));
  }
  public static String s =
    "Disagreement with beliefs is by definition incorrect";
  public static void main(String[] args) {
    process(new Upcase(), s); //不同Processor们向上转型。
    process(new Downcase(), s);
    process(new Splitter(), s);
  }
}
/*
 * 本例中，Processor类对象即为“策略”，
 * main()中共有三种策略应用到了String类型的对象(s)上。
 */
