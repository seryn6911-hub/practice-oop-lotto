package lotto.contorller;

import lotto.enums.Rank;
import lotto.model.Lotto_purchaser;
import lotto.view.View;
import java.util.List;
import java.util.Map;

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

            RankSystem rankSystem = new RankSystem(
                    purchaser.getLottos(), winningNumber, bounusNumber);

            // 통계 계산 실행
            Map<Rank, Integer> rank =rankSystem.calculateWinningStatistics();
            YieldCalculation yieldCalculation = new YieldCalculation(rank, purchasePrice);
            double profit=yieldCalculation.getLottoYield();
            //통계출력
            view.winningStatistics(rank,profit);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}