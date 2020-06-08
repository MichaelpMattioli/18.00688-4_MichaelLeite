package br.maua.game;

import br.maua.models.PicturePokerCard;
import br.maua.models.PicturePokerCardValues;
import br.maua.models.PicturePokerDeck;

import java.util.List;

public class PicturePoker {
    public static void run(){
        System.out.println("Mario Poker!");
        PicturePokerDealer dealer = new PicturePokerDealer("Luigi");
        System.out.println("Deale da meda:" + dealer.getName());

        PicturePokerHand hand = new PicturePokerHand(dealer.deal());
        System.out.println("\n\nMao Atual:");
        showPicturePokerList(hand.getHand());

        hand.checkHand(hand.getHand());

        System.out.println("Valor da Mao:" + hand.checkHand(hand.getHand()));

    }
    private static void showPicturePokerList(List<PicturePokerCard> cardList) {
        System.out.println("Size:" + cardList.size());
        for (PicturePokerCard card: cardList) {
            System.out.println(card);
        }
    }
}