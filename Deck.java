import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> deck;

    public Deck() {
        this.deck = new ArrayList<Card>();
    }

    public void createDeck() {
        for(Suit s: Suit.values()) {
            for(Face f : Face.values()) {
                this.deck.add(new Card(s, f));
            }
        }
    }

    public void shuffle() {
        ArrayList<Card> tempDeck = new ArrayList<Card>();
        Random random = new Random();
        int indexOfCard = 0;
        int originalSize = this.deck.size();
        for(int i = 0; i < originalSize; i++) {
            indexOfCard = random.nextInt((this.deck.size() - 1) + 1);
            tempDeck.add(this.deck.get(indexOfCard));
            this.deck.remove(indexOfCard);
        }
        this.deck = tempDeck;
    }

    public void drawCard(Deck cardfromDeck) {
        this.deck.add(cardfromDeck.deck.get(0));
        cardfromDeck.deck.remove(0);
    }

    public int valueOfHand() {
        int totalValue = 0;
        for(Card card : this.deck) {
            totalValue += card.getFace();
        }
        return totalValue;
    }

    public String toString() {
        StringBuilder cardList = new StringBuilder();
        for(Card card : this.deck) {
            cardList.append(card).append("\n");
        }
        return cardList.toString();
    }
}
