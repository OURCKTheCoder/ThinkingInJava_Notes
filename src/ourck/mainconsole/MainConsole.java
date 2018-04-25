package ourck.mainconsole;

import nu.xom.*;

public class MainConsole {

	public static void main(String[] args) {
		Element root = new Element("ROOT");
		root.appendChild("leaf");
		Element leafnode = new Element("leafnode");
		root.appendChild(leafnode);
		Document doc = new Document(root);
		System.out.println(doc);
	}

}
