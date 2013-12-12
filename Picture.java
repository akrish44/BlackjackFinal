import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Picture{
        private String suit;
        private int number;
        private Image image;

        public Picture(String suit, int number) {
                this.suit = suit;
                this.number = number;
                this.image = Picture.loadImage(suit,number);

        }
        public Picture(String suit, String title){
                this.suit = suit;

        }
        public void draw(Graphics g, Rectangle r) {
                g.drawImage(image, r.x, r.y, r.width, r.height, null);
        }
        private static Image loadImage(String suit, int number){
                String path = null;
                Image image = null;
                try{
                        path = "cards" + File.separator +  number  +  suit + ".jpg";
                        image = ImageIO.read(new File(path));
                } catch(IOException e) {
                        System.out.println("Could not load image at path: " + path);
                        System.exit(1);

                }
                return image;
        }
}