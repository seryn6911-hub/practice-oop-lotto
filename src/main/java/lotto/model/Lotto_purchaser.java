package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto_purchaser {
    private final int price;
    private final int costOfPurchasing;
    private List<Lotto> lottos;

    // 생성자에서 금액 검증
    public Lotto_purchaser(int costOfPurchasing) {
        if (costOfPurchasing < 1000) {
            throw new IllegalArgumentException("로또 구매 금액은 최소 1000원 이상이어야 합니다.");
        }
        if (costOfPurchasing % 1000 != 0) {
            throw new IllegalArgumentException("로또 구매 금액은 1000원 단위여야 합니다.");
        }
        this.price = costOfPurchasing;
        this.costOfPurchasing = costOfPurchasing;
    }

    // 구매 금액에 따른 로또 티켓 수 반환
    public int costToTicketNUM() {
        return costOfPurchasing / 1000;
    }

    // 랜덤 로또 생성
    public void randomPick() {
        List<Lotto> lottos = new ArrayList<>();
        int ticketCount = costToTicketNUM();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        this.lottos = lottos;
    }
    //로또를 int로 반환
    public List<List<Integer>> getLottos() {
        List<List<Integer>> lottos = new ArrayList<>();
        for (Lotto lotto : this.lottos) {
            lottos.add(lotto.getNumbers());
        }
        return lottos;
    }



}
