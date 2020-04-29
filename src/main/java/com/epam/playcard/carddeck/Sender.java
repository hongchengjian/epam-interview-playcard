package com.epam.playcard.carddeck;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 发牌者
 * @author chengjian hong
 */
public class Sender {
    private static ArrayList<Card> arrayList = new ArrayList<>(54);

    public ArrayList<Card> init() {
        for (SuitsEnum suit : SuitsEnum.values()) {
            for (PointsEnum point : PointsEnum.values()) {
                arrayList.add(new Card(suit.name().toLowerCase() + " " + point.getName(), point.getRank()));
            }
        }
        arrayList.add(new Card("black Joke", 20));
        arrayList.add(new Card("red Joke", 20));
        return arrayList;
    }


    public void shuffle(ArrayList<Card> arrayList) {
        Collections.shuffle(arrayList);
    }

}
