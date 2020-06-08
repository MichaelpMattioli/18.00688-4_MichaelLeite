package br.maua.interfaces;

import br.maua.models.PicturePokerCard;
import br.maua.models.PicturePokerHandValues;

import java.util.List;

public interface CheckHand {
    PicturePokerHandValues checkHand(List<PicturePokerCard> cardList);
}
