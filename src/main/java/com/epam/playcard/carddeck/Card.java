package com.epam.playcard.carddeck;

import java.util.Objects;

/**
 * 牌
 * @author chengjian hong
 */
public class Card {

    private String name;
    private int point;

    public Card(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return point == card.point &&
                name.equals(card.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, point);
    }
}
