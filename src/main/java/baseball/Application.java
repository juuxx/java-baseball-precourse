package baseball;

import baseball.controller.GameController;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        System.out.println("==== 게임 start ====");
        GameController controller = new GameController();
        controller.playGame();
        System.out.println("==== 게임 end ====");
    }
}
