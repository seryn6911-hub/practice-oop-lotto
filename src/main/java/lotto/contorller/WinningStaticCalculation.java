package lotto.contorller;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningStaticCalculation {
    List<List<Integer>> lottos;
    List<Integer> winningNumbers;
    int bounusNumber; // typo: bonusNumber로 수정하는 것을 권장
    int collect3;
    int collect4;
    int collect5;
    int collect5AndBounus; // typo: collect5AndBonus로 수정하는 것을 권장
    int collect6;
    int lottoPrice;
    double LottoYield;

    public WinningStaticCalculation(List<List<Integer>> lottos, List<Integer> winningNumber, int bounusNumber, int lottoPrice) {
        this.lottos = lottos;
        this.winningNumbers = winningNumber;
        this.bounusNumber = bounusNumber;
        this.lottoPrice = lottoPrice;
    }

    public void calculateWinningStatistics(){
        collect3=0;
        collect4=0;
        collect5=0;
        collect5AndBounus=0;
        collect6=0;

        for (List<Integer> lotto : lottos) {
            int collectNumber = 0;
            boolean hasBonusNumber = false;

            // 각 로또 번호에 대해 당첨번호 일치 여부와 보너스번호 일치 여부를 동시에 확인
            for (int lottoNumber : lotto) {
                boolean isWinningNumber = false;

                // 당첨 번호와 일치하는지 확인
                for(int win : winningNumbers) {
                    if(lottoNumber == win){
                        collectNumber++;
                        isWinningNumber = true;
                        break; // 중복 카운트 방지
                    }
                }

                // 당첨 번호가 아닌 경우에만 보너스 번호 검사
                if(!isWinningNumber && lottoNumber == bounusNumber){
                    hasBonusNumber = true;
                }
            }



            // 등수 판정
            if(collectNumber == 6){
                collect6++;
            } else if(collectNumber == 5){
                if(hasBonusNumber){
                    collect5AndBounus++;
                } else {
                    collect5++;
                }
            } else if(collectNumber == 4){
                collect4++;
            } else if(collectNumber == 3){
                collect3++;
            }
        }
    }

    private void calculateYield() {
        long totalPrize = (long)collect6 * 2000000000L +
                (long)collect5AndBounus * 30000000L +
                (long)collect5 * 1500000L +
                (long)collect4 * 50000L +
                (long)collect3 * 5000L;

        if (lottoPrice > 0) {
            LottoYield = (double)totalPrize / lottoPrice * 100;
        } else {
            LottoYield = 0.0;
        }
    }

    public int get3(){
        return collect3;
    }
    public int get4(){
        return collect4;
    }
    public int get5(){
        return collect5;
    }
    public int get5AndBounus(){
        return collect5AndBounus;
    }
    public int get6(){
        return collect6;
    }

    public double getLottoYield(){
        double totalPrize = (double)collect6 * 2000000000.0 +
                (double)collect5AndBounus * 30000000.0 +
                (double)collect5 * 1500000.0 +
                (double)collect4 * 50000.0 +
                (double)collect3 * 5000.0;

        double yield = (double) totalPrize / lottoPrice * 100.0;

        return Math.round(yield * 100.0) / 100.0;
    }
}