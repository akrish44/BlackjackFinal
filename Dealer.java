import java.awt.Graphics;
import java.awt.Rectangle;

class Dealer extends Player{
        private Deck deck;
        public Dealer(){
                super();
                this.deck = new Deck();
                this.deck.shuffle();
        }
        public void hit(Dealer dealer){
                addCard(dealer.getCard());
        }
        public Card getCard(){
                return deck.returnTop();
        }
}