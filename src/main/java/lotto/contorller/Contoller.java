package lotto.contorller;

import lotto.model.Lotto;
import lotto.model.Lotto_purchaser;
import lotto.view.View;
import java.util.List;

public class Contoller {
    private final View view; // private final로 변경

    public Contoller(View view) {
        this.view = view;
    }

    public void startController(){
        try {
            //금액 받기
            int purchasePrice = view.lottoPurchseStart();
            Lotto_purchaser purchaser = new Lotto_purchaser(purchasePrice);

            //로또 개수 출력
            view.LottoNum(purchaser.costToTicketNUM());

            //로또배열 생성
            purchaser.randomPick();
            view.LottoDrow(purchaser.getLottos());

            //당첨번호 입력
            List<Integer> winningNumber = view.winningNumber();
            //보너스 번호 입력
            int bounusNumber = view.bounusNumber();

            WinningStaticCalculation staticCalculation = new WinningStaticCalculation(
                    purchaser.getLottos(), winningNumber, bounusNumber, purchasePrice);

            // 통계 계산 실행
            staticCalculation.calculateWinningStatistics();

            // winningStatistics 메서드 호출
            view.winningStatistics(
                    staticCalculation.collect6,
                    staticCalculation.collect5AndBounus,
                    staticCalculation.collect5,
                    staticCalculation.collect4,
                    staticCalculation.collect3,
                    staticCalculation.getLottoYield()
            );
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}