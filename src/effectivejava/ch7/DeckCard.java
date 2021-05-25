package effectivejava.ch7;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeckCard {

    enum Suit {CLUE, DIAMOND, HEART, SPADE}
    enum Rank {ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}

    public static void main(String[] args) {

        List<Card> cards = newDeckStream();

        for (Card card: cards){
            System.out.println(card);
        }

    }

    private static List<Card> newDeck(){
        List<Card> cards = new ArrayList<>();
        for(Suit suit : Suit.values()){
            for (Rank rank: Rank.values()){
                cards.add(new Card(suit.name(), rank.name()));
            }
        }

        return cards;
    }

    private static List<Card> newDeckStream(){
        return Stream.of(Suit.values())
                .flatMap(suit ->
                        Stream.of(Rank.values())
                                .map(rank -> new Card(suit.name(), rank.name())))
                .collect(Collectors.toList());
    }

    static class Card{
        private String suit;
        private String rank;

        public Card(String suit, String rank) {
            this.suit = suit;
            this.rank = rank;
        }

        public String getSuit() {
            return suit;
        }

        public String getRank() {
            return rank;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "suit='" + suit + '\'' +
                    ", rank='" + rank + '\'' +
                    '}';
        }
    }

}
