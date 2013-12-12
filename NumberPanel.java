import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class NumberPanel extends JPanel implements ActionListener{
        private JLabel label, bet, wallet;
        private JButton hit, stay, game, betb, dbl;
        private int value = 0;
        private Human human;
        private Dealer dealer;
        private TableApplet table;
        private int x, betv, walletv;

        public NumberPanel(Human human, Dealer dealer, TableApplet table) {
                super();
                this.human = human;
                this.table = table;
                this.dealer = dealer;
                this.value = human.score();
                this.walletv = 100;

                label = new JLabel("");
                label.setFont(new Font("sansserif", Font.BOLD, 16));
                this.add(label);

                String title = "Hit";
                hit = new JButton(title);
                hit.setActionCommand(title);
                hit.addActionListener(this);
                this.add(hit);

                title = "Stay";
                stay = new JButton(title);
                stay.setActionCommand(title);
                stay.addActionListener(this);
                this.add(stay);

                title = "New Game";
                game = new JButton(title);
                game.setActionCommand(title);
                game.addActionListener(this);
                this.add(game);

                title = "Bet $10";
                betb = new JButton(title);
                betb.setActionCommand(title);
                betb.addActionListener(this);
                this.add(betb);

                title = "Double Down";
                dbl = new JButton(title);
                dbl.setActionCommand(title);
                dbl.addActionListener(this);
                this.add(dbl);

                bet = new JLabel("You bet: " + betv);
                bet.setFont(new Font("sansserif", Font.BOLD, 16));
                this.add(bet);

                wallet = new JLabel("Your total balance: " + walletv);
                wallet.setFont(new Font("sansserif", Font.BOLD, 16));
                this.add(wallet);
                
        }
        public void actionPerformed(ActionEvent ae){
                if("Hit".equals(ae.getActionCommand())){
                        this.human.hit(this.dealer);
                        if (this.human.score() > 21) {
                                label.setText("Bust! Dealer Wins!");
                                this.x = 2;
                                hit.setEnabled(false);
                                stay.setEnabled(false);
                                dbl.setEnabled(false);
                        }
                        betb.setEnabled(false);
                        this.x = 1;
                        table.repaint();
                        repaint();
                        validate();
                } else if ("Stay".equals(ae.getActionCommand())){
                        while(this.dealer.score() < 17){
                                this.dealer.hit(this.dealer);
                        }
                        if (playerWins()) {
                                walletv += (betv*2);
                                label.setText("Player Wins!");
                        }
                        if (dealerWins()) {
                                label.setText("You bust! Dealer wins :(");
                        }
                        if (this.dealer.score() == this.human.score()){
                                walletv += betv;
                                label.setText("Tie!");
                        }
                        wallet.setText("Your Balance is: " + walletv);
                        this.x = 2;
                        betb.setEnabled(false);
                        hit.setEnabled(false);
                        stay.setEnabled(false);
                        dbl.setEnabled(false);
                        table.repaint();
                        repaint();
                        validate();

                        
                }
                if ("New Game".equals(ae.getActionCommand())) {
                        newHand();
                        label.setText("");
                        betb.setEnabled(true);
                        hit.setEnabled(true);
                        stay.setEnabled(true);
                        dbl.setEnabled(true);
                        repaint();
                        table.repaint();
                        validate();

                        
                }
                if ("Bet 10$".equals(ae.getActionCommand())){
                        betv += 10;
                        walletv -= 10;
                        bet.setText("Your Bet: " + betv);
                        wallet.setText("Your Wallet: " + walletv);
                        table.repaint();
                        repaint();
                        validate();
                }
                if ("Double Down".equals(ae.getActionCommand())) {
                        this.human.hit(this.dealer);
                        betv *= 2;
                        walletv -= betv;
                        if (this.human.score() > 21) {
                                label.setText("Bust! Dealer Wins!");
                                this.x = 2;
                                hit.setEnabled(false);
                                stay.setEnabled(false);
                                dbl.setEnabled(false);
                        }
                        bet.setText("Your Bet: " + betv);
                        wallet.setText("Your Wallet: " + walletv);
                        betb.setEnabled(false);
                        this.x = 1;
                        table.repaint();
                        repaint();
                        validate();
                }
        }
        public int stay(){
                return this.x;
        }
        public boolean playerWins(){
                if (this.human.score() <= 21) {
                        if (this.human.score() > dealer.score() || this.dealer.score() > 21) {
                                return true;                
                        }
                }
                return false;
        }
        public boolean dealerWins(){
                if (this.dealer.score() <= 21) {
                        if (this.human.score() < this.dealer.score() || this.human.score() > 21) {
                                return true;
                        }
                }
                return false;
        }
        public void newHand(){
                this.human = new Human();
                this.dealer = new Dealer();
                this.table.newgame(this.human, this.dealer);
                this.human.hit(this.dealer);
                this.human.hit(this.dealer);
                this.dealer.hit(this.dealer);
                this.dealer.hit(this.dealer);
                betv = 0;
                bet.setText("Your Bet: " + betv);
                this.x = 0;
        }
        public int getBet(){
                return this.betv;
        }
        public int getWallet(){
                return this.walletv;
        }
}