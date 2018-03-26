package ourck.notes;
/*-------------------------------------
 *	OURCK - "=="和equals()是不一样的！
 *	2018年2月5日 下午10:07:40
 *-------------------------------------

/* 
 * 阅读代码，观察输出。
 */
public class DifferenceInEqualCondition{
	public static void main(String[] args){
		Integer i = new Integer(7);
		Integer j = new Integer(7);
			//7 = 7，这是常识。
		if(i == j) System.out.println("==!");
			// ==是判断两个变量或实例是不是“指向同一个内存空间”，即是否指向同一对象
		if(i.equals(j)) System.out.println("equals()!");
			//equals是判断两个变量或实例所指向的“内存空间”（对象）的值是不是相同(对于String/Integer/一些常见类型而言)
			//因此，上面两个i和j，不指向同一对象，但这两个对象的值相同。
		
		Character str1 = 'c'; char str2 = 'a';
		if(str1.equals(str2)) System.out.println("equals()!");
			//当然，自动包装类也一样。
		
		String str4 = "txt", str3 = "txt";
		if(str3.equals(str4)) System.out.println("equals()!");
		String str5 = "txt", str6 = "txt";
		if(str5.equals(str6)) System.out.println("equals()!");
		
	}
}
