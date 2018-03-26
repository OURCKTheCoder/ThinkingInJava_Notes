package ourck.notes;
/*------------------------------------
 *	OURCK - Vampire Num（吸血鬼数字）
 *	2018年2月4日 下午10:20:37
 *------------------------------------

/* 
 * 位数为偶数的数字，可由一对数字相乘而得到，这对数字包含乘积位数的一半位数。
 * 他们可以任意排序。
 * 以00结尾的数字是不允许的。
 * 
 * 例如：1260 = 21 * 60, 1827 = 21 * 87, 2187 = 27 * 81
 * 找出所有的四位数Vampire Num.
 */
public class VampiresNum {

	public static void main(String[] args) {
		for(Integer num = 1000; num < 10000; num++) {
			if(num % 100 == 0) continue;
			
			char bits[] = num.toString().toCharArray();
			Integer bit[] = new Integer[4];
			for(int j = 0; j < bits.length; j++) 
				bit[j] = bits[j] - '0';
			

				
			
		}
	}
}
