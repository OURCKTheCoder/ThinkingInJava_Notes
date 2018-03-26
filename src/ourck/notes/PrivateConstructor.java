package ourck.notes;
/*---------------------------------
 *	OURCK - 私有化构造器
 *	2018年2月4日 下午10:20:09
 *---------------------------------
	

/* 
 * 可用于个性化构造的。比如：对创建新对象进行计数。
 * 3X要点。
 */

class ConnectionManager{
	public static void buildConnections(int Size) {
		cts = Connection.makeConnections(Size);
	}
	public static Connection[] accessConnection(){ //←1.单例及其唯一访问形式：“设计模式”
		if(cts.length == 0) return null;
		else return cts;//这里是对单例对象的访问
	}
	private static Connection[] cts;
}

class Connection{	
	public static Connection makeConnection(){ //←2.静态方法间接构造（单个对象）
		return new Connection();
	}
	public static Connection[] makeConnections(int Size){ //←3.静态方法间接构造（对象数组）
		Connection[] cts = new Connection[Size];
		return cts;
	}
	private Connection() {} //←私有的构造器
}

public class PrivateConstructor{
	public static void main(String[] args) {
		ConnectionManager.buildConnections(7);
		if(ConnectionManager.accessConnection() != null)
			System.out.println("There's " + 
								ConnectionManager.accessConnection().length + 
								" Connections.");
		else
			System.out.println("Disconnected!");
	}
}