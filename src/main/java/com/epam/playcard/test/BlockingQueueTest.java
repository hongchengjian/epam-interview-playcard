package com.epam.playcard.test;

import com.alibaba.fastjson.JSON;
import com.epam.playcard.carddeck.Card;
import com.epam.playcard.carddeck.Player;
import com.epam.playcard.carddeck.Sender;
import org.springframework.util.CollectionUtils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingQueueTest {
    private static BlockingQueue<Card> cards = new LinkedBlockingDeque<>();

    public static Card take() {
        Card card = null;
        try {
            card = cards.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return card;
    }

    public static void put(Card card) {
        try {
            cards.put(card);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean win(Player[] players) {
        if (null != players && 0 != players.length) {
            for (Player player : players) {
                // 每个玩家手中的牌
                ArrayList<Card> list = player.getList();
                if (!CollectionUtils.isEmpty(list)) {
                    System.out.println(MessageFormat.format("{0}-{1}-{2}", player.getId(), player.getName(), JSON.toJSON(player.getList())));
                    int sum = list.stream().mapToInt(c -> c.getPoint()).sum();
                    if (sum > 50) {
                        System.out.printf("%d-%s sum:%d%s%n", player.getId(), player.getName(), sum, JSON.toJSON(player.getList()));
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        // 1个发牌者
        Sender sender = new Sender();
        // 54张牌
        ArrayList<Card> cardList = sender.init();
        // 发牌者洗牌
        sender.shuffle(cardList);

        // 3个玩家
        Player[] players = new Player[3];
        players[0] = new Player(1, "Player1");
        players[1] = new Player(2, "Player2");
        players[2] = new Player(3, "Player3");

        // 游戏共多少轮数
        int rounds = 18;
        for (int j = 0; j < rounds; j++) {
            Iterator<Card> it = cardList.iterator();
            if (it.hasNext()) {
                // 一轮中，顺序发三张
                for (int i = 0; i < 3; i++) {
                    Card currentCard = it.next();
                    // 取一张删掉一张
                    put(currentCard);
                    it.remove();
                }
            }
            players[0].getCard(take());
            players[1].getCard(take());
            players[2].getCard(take());


            System.out.printf("round%d is over%n", j);
            if (win(players)) break;
        }
    }

}
