package com.epam.playcard.carddeck;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

/**
 * 玩牌者
 * @author chengjian hong
 */
public class Player {
    private static final int ROUND = 3;

    /**
     * 玩家id
     */
    private int id;
    /**
     * 玩家名
     */
    private String name;
    /**
     * 玩家手里的牌
     */
    private ArrayList<Card> list;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void getCard(Card card){
        if(CollectionUtils.isEmpty(list)){
            list = new ArrayList<>(ROUND);
        }
        list.add(card);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getList() {
        return list;
    }

    public void setList(ArrayList<Card> list) {
        this.list = list;
    }
}
