package lotto.contorller;

import lotto.enums.Rank;

import java.util.HashSet;
import java.util.Map;

public class YieldCalculation {


    private Map<Rank, Integer> rank;
    private int purchasePrice;

    public YieldCalculation(Map<Rank, Integer> rank,int purchasePrice){
        this.rank=rank;
        this.purchasePrice=purchasePrice;
    }


    public double getLottoYield() {
        double totalPrize = (double) rank.get(Rank.SIX) * 2000000000.0 +
                (double) rank.get(Rank.FIVE_AND_BONUS) * 30000000.0 +
                (double) rank.get(Rank.FIVE) * 1500000.0 +
                (double) rank.get(Rank.FOUR) * 50000.0 +
                (double) rank.get(Rank.THREE) * 5000.0;

        double yield = (double) totalPrize / purchasePrice * 100.0;

        return Math.round(yield * 100.0) / 100.0;
    }
}




