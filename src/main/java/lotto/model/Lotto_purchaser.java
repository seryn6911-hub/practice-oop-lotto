package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto_purchaser {
    private final int price;
    private final int costOfPurchasing;
    private List<Lotto> lottos;


    public Lotto_purchaser(int costOfPurchasing) {
        this.price = costOfPurchasing;
        this.costOfPurchasing = costOfPurchasing;
    }

    // 구매 금액에 따른 로또 티켓 수 반환
    public int costToTicketNUM() {
        return costOfPurchasing / 1000;
    }


    public List<List<Integer>> randomPick() {
        List<Lotto> lottos = new ArrayList<>();
        int ticketCount = costToTicketNUM();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        this.lottos = lottos;
        List<List<Integer>> lottoList = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoList.add(lotto.getNumbers());
        }
        return lottoList;
    }





}
