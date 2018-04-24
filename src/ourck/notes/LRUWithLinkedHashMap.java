package ourck.notes;
/*-------------------------------------
 *	OURCK - 支持LRU算法的LinkedHashMap
 *	2018年4月7日 下午7:05:53
 *-------------------------------------

/* 
 * 这玩意实在是太有用了，特此记录。
 * 用来干什么？
 * 1.历史记录； 2.用于定时清理不需要的数据； 3.。。。
 */

//: containers/LinkedHashMapDemo.java
// What you can do with a LinkedHashMap.
import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;

public class LRUWithLinkedHashMap {
  public static void main(String[] args) {
    LinkedHashMap<Integer,String> linkedMap =
      new LinkedHashMap<Integer,String>(
        new CountingMapData(9));
    print(linkedMap);
    // Least-recently-used order:
    linkedMap =
      new LinkedHashMap<Integer,String>(16, 0.75f, true); //第三个参数传入true以支持LRU
    linkedMap.putAll(new CountingMapData(9));
    print(linkedMap);
    for(int i = 0; i < 6; i++) // Cause accesses:
      linkedMap.get(i);
    print(linkedMap);
    linkedMap.get(0);
    print(linkedMap);
  }
} /* Output:
{0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0}
{0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0}
{6=G0, 7=H0, 8=I0, 0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0}
{6=G0, 7=H0, 8=I0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 0=A0}
*///:~
