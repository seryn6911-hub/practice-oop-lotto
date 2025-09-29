package lotto.contorller;

import lotto.enums.Rank;

import java.util.*;

public class RankSystem {
    List<List<Integer>> lottos;
    List<Integer> winningNumbers;
    int bounusNumber; // typo: bonusNumber로 수정하는 것을 권장




    public RankSystem(List<List<Integer>> lottos, List<Integer> winningNumber, int bounusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumber;
        this.bounusNumber = bounusNumber;
    }


    public Map<Rank, Integer> calculateWinningStatistics() {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);

        // 초기화
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }

        for (List<Integer> lotto : lottos) {
            int collectNumber = 0;
            boolean hasBonusNumber = false;

            // 각 번호 비교
            for (int lottoNumber : lotto) {
                boolean isWinningNumber = false;

                for (int win : winningNumbers) {
                    if (lottoNumber == win) {
                        collectNumber++;
                        isWinningNumber = true;
                        break; // 중복 방지
                    }
                }

                // 보너스 번호 체크
                if (!isWinningNumber && lottoNumber == bounusNumber) {
                    hasBonusNumber = true;
                }
            }

            // 등수 판정
            if (collectNumber == 6) {
                result.put(Rank.SIX, result.get(Rank.SIX) + 1);
            } else if (collectNumber == 5 && hasBonusNumber) {
                result.put(Rank.FIVE_AND_BONUS, result.get(Rank.FIVE_AND_BONUS) + 1);
            } else if (collectNumber == 5) {
                result.put(Rank.FIVE, result.get(Rank.FIVE) + 1);
            } else if (collectNumber == 4) {
                result.put(Rank.FOUR, result.get(Rank.FOUR) + 1);
            } else if (collectNumber == 3) {
                result.put(Rank.THREE, result.get(Rank.THREE) + 1);
            }

        }

        return result;
    }



}