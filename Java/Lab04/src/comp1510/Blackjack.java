package comp1510;
/**
 * Blackjack.
 * @author jay
 * @version 1.0
 */
public class Blackjack {
    /** declare the cards.*/
    public enum Rank { two, three, four, five, six,
        /**card value.*/
        seven, eight, nine, ten, jack, queen, king, ace } 
    /**
     * Drives the program.
     * @param args command line argument
     */
    public static void main(String[] args) {
        
        Rank highCard;
        Rank faceCard;
        Rank card1;
        Rank card2;
        
        highCard = Rank.ace;
        faceCard = Rank.king;
        
        System.out.println("A blackjack hand: " + highCard
                + " and " + faceCard);
        
        card1 = Rank.six;
        card2 = Rank.ten;
        
        System.out.println("A two card hand: " + card1 + " and "
                + card2);
        
        int card1Val;
        int card2Val; 
        int sum;
        /**
         * card1Val = card1's value
         * card2Val = card2"s value
         * sum = value of card1 + vard2
         */
        card1Val = card1.ordinal() + 2; // ordinal start with 0 
        card2Val = card2.ordinal() + 2;
        sum = card1Val + card2Val;
        
        
        System.out.println("The sum of the face value of the two " 
                + "cards is : " + sum);  
    }

}
