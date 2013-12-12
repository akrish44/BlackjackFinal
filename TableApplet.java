import java.awt.*;
import java.applet.*;


public class TableApplet extends Applet {
        private Dealer dealer;
        private Human human;
        private NumberPanel np;
        public void init() {
                this.dealer = new Dealer();
                this.human = new Human();
                Dimension size = new Dimension(2000,100);
                this.human.hit(dealer);
                this.human.hit(dealer);
                this.dealer.hit(dealer);
                this.dealer.hit(dealer);
                this.np = new NumberPanel(this.human, this.dealer, this);
                this.np.setPreferredSize(size);
                this.add(np);

        }

        public void paint(Graphics g) {
                super.paint(g);
                if (this.np.stay() == 0) {
                        this.dealer.returnHand().drawDealer(g, 350);
                        this.human.returnHand().drawDealer(g, 150);
                }
                if (this.np.stay() == 1) {
                        this.human.returnHand().drawHand(g,150);
                        this.dealer.returnHand().drawDealer(g, 350);
                }
                if (this.np.stay() == 2) {
                        this.dealer.returnHand().drawHand(g, 350);
                        this.human.returnHand().drawHand(g,150);
                }
                

        }
        public void newgame(Human human, Dealer dealer){
                this.human = human;
                this.dealer = dealer;
        }

}