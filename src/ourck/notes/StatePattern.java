package ourck.notes;
/*-------------------------------------
 *	OURCK - 通过“状态模式”控制多态
 *	2018年2月12日 下午12:50:26
 *-------------------------------------

/* 
 * 所谓”状态模式“是指在运行时可以通过某种手段（如：某个方法）
 * 实现选择性的多态。
 * 通过“状态模式”，可以获得多态的动态灵活性。
 */
import static net.mindview.util.Print.print;

class Actor {
  public void act() {}
}

class HappyActor extends Actor {
  public void act() { print("HappyActor"); }
}

class SadActor extends Actor {
  public void act() { print("SadActor"); }
}

class Stage {
  private Actor actor = new HappyActor();
  public void change() { actor = new SadActor(); } //通过这一方法灵活地改变多态的状态。
  public void performPlay() { actor.act(); } //这一方法的行为也随之改变
}

public class StatePattern {
  public static void main(String[] args) {
    Stage stage = new Stage();
    stage.performPlay();
    stage.change();
    stage.performPlay();
  }
}

