import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Card{
        private int suit;
        private int value;
        private String suitName;
        private String title;
        private Picture picture;
        private String back;

        public Card(int value, int suit){
                this.value = value;
                this.back = "back-blue";
                this.suit = suit;
                if(suit == 0){
                        this.suitName = "Clubs";
                }else if (suit == 1) {
                        this.suitName = "Diamonds";
                }else if (suit == 2) {
                        this.suitName = "Hearts";
                }else if (suit == 3) {
                        this.suitName = "Spades";
                }
                
                if(value == 11){
                        this.title = "J" + this.suitName;
                } else if(value == 12){
                        this.title = "Q" + this.suitName;
                } else if(value == 13){
                        this.title = "K" + this.suitName;
                }
                
                if (value <= 10) {
                        if(value == 1){
                                this.title = "A" + this.suitName;
                        } else {
                                this.title = value + suitName;
                        }
                        
                }
                if (this.value>10){
                        this.value = 10;
                }
        }
        private static Image loadImage(String title) {
            String path = null;
            Image image = null;

            try {
                path = "cards" + File.separator + title + ".png";
                image = ImageIO.read(new File(path));
                } catch (IOException e) {
                    System.out.println("Could not load card at path: " + path);
                    e.printStackTrace();
                }
                return image;
        }        
        public void draw(Graphics g, String name, Rectangle r) {
            g.drawImage(Card.loadImage(name), r.x, r.y, r.width, r.height, null);
        }
        public int getValue(){
                return this.value;
        }
        public int getValue2() {
                if (this.value==1) {
                        return 11;
                } else {
                        return this.value;
                }
        }
        public void drawBack(Graphics g, Rectangle r){
                g.drawImage(Card.loadImage(back), r.x, r.y, r.width, r.height, null);
        }
        public int getNumber(){
                return this.suit;
        }
        public String getTitle(){
                return this.title;
        }

}