public class Player{
        private Hand hand;
        public Player(){
                this.hand = new Hand();
        }
        public void addCard(Card a){
                this.hand.add(a);
        }
        public int score(){
                return this.hand.getValue();

        }
        public Hand returnHand(){
                return this.hand;
        }
}