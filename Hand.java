import java.awt.Graphics;
import java.awt.Rectangle;


public class Hand {
        private Card[] hand;
        private int cards;
        private int sum;
        public Hand(){
                this.hand = new Card[11];

        }
        public void add(Card a){
                this.hand[cards] = a;
                this.cards++;

        }
        public int getCards(){
                return this.cards;
        }
        public int getValue(){
                int sum = 0;
                for (int i = 0; i<this.cards; i++) {
                        sum += hand[i].getValue2();
                }
                if (sum > 21) {
                        sum = 0;
                        for (int i = 0; i<this.cards; i++) {
                                sum += hand[i].getValue();
                        }
                }
                return sum;
        }
        public void drawHand(Graphics g, int y){
          int x = 550;
          for (int i = 0; i<this.cards; i++) {
            this.hand[i].draw(g, hand[i].getTitle(), new Rectangle(x, y, 100, 150));
            x += 125;
          }
          
        }
        public void drawDealer(Graphics g, int y){
          int x = 550;
          for (int i = 0; i<this.cards; i++) {
                  this.hand[i].drawBack(g, new Rectangle(x, y, 100, 150));
            x += 125;
          }
          
        }
}