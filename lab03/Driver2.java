
public class Driver2 {
    public static void main(String[] args) {

        Card[] cards = {
            new Card("Ace", "Spades"),
            new Card("Queen", "Hearts"),
            new Card("King", "Diamonds"),
            new Card("King", "Diamonds"),   // Duplicate
            new Card("10", "Clubs")
        };

        boolean duplicateFound = false;

        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < i; j++) {
                if (cards[i].equals(cards[j])) {
                    System.out.println("Duplicate found: " + cards[i]);
                    duplicateFound = true;
                    break;
                }
            }

            if (duplicateFound)
                break;
        }
    }
}