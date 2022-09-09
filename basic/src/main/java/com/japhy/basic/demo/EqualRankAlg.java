package com.japhy.basic.demo;

import java.util.Comparator;
import java.util.List;

/**
 * @author Japhy
 * @since 2022/8/15 17:01
 */
public class EqualRankAlg implements RankAlg {

    @Override
    public void rank(List<Rankable> rankableList) {
        rankableList.sort(Comparator.comparing(Rankable::getRankItem));
        int rank = 1;
        for (int i = 0; i < rankableList.size(); i++) {
            Rankable rankable = rankableList.get(i);
            rankable.setRank(rank);
            if (i == 0) {
                rankable.setRank(1);
            } else {
                if (rankable.getRankItem() == rankableList.get(i - 1).getRankItem()) {
                    rankable.setEqualRank(rankableList.get(i - 1).getEqualRank());
                } else {
                    rankable.setEqualRank(rankableList.get(i - 1).getEqualRank() + 1);
                }
            }
            rank++;
        }
    }
}
