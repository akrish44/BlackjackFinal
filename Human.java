class Human extends Player {
        private Human human;
        public Human(){
                super();
        }
        public void hit(Dealer dealer){
                addCard(dealer.getCard());
        }
}