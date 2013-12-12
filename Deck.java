import java.util.Random;
import java.awt.Graphics;
import java.awt.Rectangle;
public class Deck {

    private Card[] deck;  
    private int cardsUsed; 
    private Hand hand;
    public Deck() {
      this.deck = new Card[52];
      int cardCt = 0;
      this.hand = new Hand();
      for ( int suit = 0; suit <= 3; suit++ ) {
        for ( int value = 1; value <= 13; value++ ) {
            this.deck[cardCt] = new Card(value,suit);
            cardCt++;
        }
      }
      cardsUsed = 0;
      
    }
    
    public void shuffle() {
      Random r = new Random();
      for (int i = 51; i>0; i--) {
        Card a = deck[i];
        int rand = r.nextInt(i);
        deck[i] = deck[rand];
        deck[rand] = a;
      }
      cardsUsed = 0;
    }
    
    public int cardsLeft() {
      return 52 - cardsUsed;
    }
    
    public Card returnTop(){
      this.cardsUsed++;
      return deck[cardsLeft()];
    }
   
    public void drawDeck(Graphics g, int y){
      int x = 50;
      for (int i = 0; i<deck.length; i++) {
        this.deck[i].draw(g, deck[i].getTitle(), new Rectangle(x, y, 100, 150));
        x += 25;
      }
      
    }


} 