/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uno;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.ImageIcon;


/**
 * The Deck class consists of 108 Uno Cards. There are four suits, Red, Green,Yellow and Blue, 
 * each consisting of one 0 card, two 1 cards, 2s, 3s, 4s,5s, 6s, 7s, 8s and 9s; two Draw Two cards; two Skip cards; and two Reverse cards. 
 * In addition there are four Wild cards and four Wild Draw Four cards.
 */


public class UnoDeck {
    private UnoCard[] cards;
    private int cardsInDeck;


    public UnoDeck() {
        //initializes the cards array
        cards = new UnoCard[108];
        reset();
    }
    
    public void reset(){
        UnoCard.Color[] colors = UnoCard.Color.values();
        cardsInDeck = 0;
        
        for (int i = 0; i < colors.length-1; i++){ 
            UnoCard.Color color = colors[i];
            
            cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValue(0));
            
            for (int j = 1; j < 10; j++){
                cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValue(j));
                cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValue(j));
            }
            
            UnoCard.Value[] values = new UnoCard.Value[]{UnoCard.Value.DrawTwo, UnoCard.Value.Skip, UnoCard.Value.Reverse};
            for (UnoCard.Value value : values){
                cards[cardsInDeck++] = new UnoCard(color, value);
                cards[cardsInDeck++] = new UnoCard(color, value);
            }
        }
        
        UnoCard.Value[] values = new UnoCard.Value[]{UnoCard.Value.Wild, UnoCard.Value.Wild_Four};
            for (UnoCard.Value value : values){
                for (int i = 0; i < 4; i++){
                    cards[cardsInDeck++] = new UnoCard(UnoCard.Color.Wild, value);
                }
            }           
    }
    
    public void replaceDeckWith(ArrayList<UnoCard> cards){
      this.cards = cards.toArray(new UnoCard[cards.size()]);
      this.cardsInDeck = this.cards.length;
    }
    
    public boolean isEmpty() {
      return cardsInDeck == 0;
    }
    
    public void shuffle() {
      int n = cards.length;
      Random random = new Random();

      for (int i = 0; i < cards.length; i++) {

        // Get a random index of the array past the current index
        // ... The argument is an exclusive bound
        // Swap the random element with the present element

        int randomValue = i + random.nextInt(n - i);
        UnoCard randomCard = cards[randomValue];
        cards[randomValue] = cards[i];
        cards[i] = randomCard;
      }
    }
    
    public UnoCard drawCard() throws IllegalArgumentException {
      if (isEmpty()){
        throw new IllegalArgumentException("Cannot draw a card since there are no cards in the deck");
      }
      return cards[--cardsInDeck];
    }
    
    public ImageIcon drawCardImage() throws IllegalArgumentException {
      if(isEmpty()) {
        throw new IllegalArgumentException("Cannot draw a card since the deck is empty");
      }
      return new ImageIcon(cards[--cardsInDeck].toString() + ".png");
    }
    
    public UnoCard[] drawCard(int n) {
        if (n < 0) {
        throw new IllegalArgumentException("Must draw positiive cards but tried to draw " + n + " cards.");
        }

        if (n > cardsInDeck) {
        throw new IllegalArgumentException("Cannot draw " + n + " cards since there are only " + cardsInDeck + " cards.");
        }
        
         UnoCard[] ret = new UnoCard[n];
         for (int i = 0; i < n; i++) {
             ret[i] = cards[--cardsInDeck];
         }
         return ret;
    }
}