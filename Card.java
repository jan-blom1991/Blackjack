enum Suit {
    HEART, DIAMOND, SPADE, CLUB;
}

enum Face {
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);

    int faceValue;

    Face(int faceValue) {
        this.faceValue = faceValue;
    }

    public int getFaceValue() {
        return faceValue;
    }
}

public class Card {
    private Suit suit;
    private Face face;

    public Card(Suit suit, Face face) {
        this.suit = suit;
        this.face = face;
    }

    public int getFace() {
        return this.face.getFaceValue();
    }

    public String toString() {
        return this.face.toString().toLowerCase() + " of " + this.suit.toString().toLowerCase() + "s";
    }
}
