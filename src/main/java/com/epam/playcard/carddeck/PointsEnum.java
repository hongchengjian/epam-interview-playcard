package com.epam.playcard.carddeck;

/**
 * 牌A-K 13张
 * @author chengjian hong
 */
public enum PointsEnum {
    A("A",1),
    _2("2",2),
    _3("3",3),
    _4("4",4),
    _5("5",5),
    _6("6",6),
    _7("7",7),
    _8("8",8),
    _9("9",9),
    _10("10",10),
    J("J",11),
    Q("Q",12),
    K("K",13);

    PointsEnum(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }
    private String name;
    private int rank;

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }
}
