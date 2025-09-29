package lotto;

import lotto.contorller.Contoller;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        try {
            View view = new View();
            Contoller controller = new Contoller(view);
            controller.startController();
        } catch (IllegalArgumentException e) {
            // 예외 발생 시 조용히 종료 - 추가 출력 없음
        }
    }
}