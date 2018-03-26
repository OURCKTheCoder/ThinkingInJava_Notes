package ourck.notes.userclass;

//也可以使用外部类以避免麻烦
public class UserJava_ExternalClass {
		
		public static void main(String[] args) {
			Man man2 = new Man();
			man2.age = 16;
			System.out.println(man2.age);
		}

}

class Man{
	int age = 0;
}
