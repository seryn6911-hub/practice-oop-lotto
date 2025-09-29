package lotto.model;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private Lotto lottos;
    private int ticketNumber;
    //로또 추첨

    public List<Lotto> randomPick(int ticketNumber) {
        List<Lotto> lottos = new ArrayList<>();
        int ticketCount = ticketNumber;
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;

    }
}
