import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Dealer class
 * 
 * @Kyle Jin
 * @Feb 2, 2024
 */
public class Dealer extends Actor
{
    private Deck deck;
    private ArrayList<Card> cardsOnBoard;
    private ArrayList<Integer> selectedCardsIndex;
    private Card cardsSelected[];
    private int numCardsInDeck;
    private int triplesRemaining;
    
    public Dealer(int numCardsInDeck)
    {
        this.numCardsInDeck = numCardsInDeck;
        this.triplesRemaining = numCardsInDeck / 3;
        this.deck = new Deck(numCardsInDeck);
        this.cardsSelected = new Card[3];
    } 
    
    public void addedToWorld(World world)
    {
        dealBoard();
        setUI();
    }
    
    public void dealBoard()
    {
        Greenfoot.playSound("shuffle.wav");
        for (int y = 45; y <= 450; y += 90)
        {
            for (int x = 80; x <= 350; x+= 135)
            {
                getWorld().addObject(deck.getTopCard(), x, y);
                numCardsInDeck--;
            }
        }
    }
    
    public void setUI()
    {
        Integer score = Scorekeeper.getScore();
        Integer numCardsRemaining = numCardsInDeck;
        getWorld().showText(score.toString(), 312, 505);
        getWorld().showText(numCardsRemaining.toString(), 312, 470);
    }
    
    public void endGame()
    {
        Greenfoot.stop();
    }
    
    public boolean checkIfTriple() {
        boolean isTriple = true;

        if (!((cardsSelected[0].getShape() == cardsSelected[1].getShape() && cardsSelected[1].getShape() == cardsSelected[2].getShape()) ||
              (cardsSelected[0].getShape() != cardsSelected[1].getShape() && cardsSelected[1].getShape() != cardsSelected[2].getShape() && cardsSelected[0].getShape() != cardsSelected[2].getShape()))) {
            isTriple = false;
        }
        if (!((cardsSelected[0].getColor() == cardsSelected[1].getColor() && cardsSelected[1].getColor() == cardsSelected[2].getColor()) ||
              (cardsSelected[0].getColor() != cardsSelected[1].getColor() && cardsSelected[1].getColor() != cardsSelected[2].getColor() && cardsSelected[0].getColor() != cardsSelected[2].getColor()))) {
            isTriple = false;
        }
        if (!((cardsSelected[0].getShading() == cardsSelected[1].getShading() && cardsSelected[1].getShading() == cardsSelected[2].getShading()) ||
              (cardsSelected[0].getShading() != cardsSelected[1].getShading() && cardsSelected[1].getShading() != cardsSelected[2].getShading() && cardsSelected[0].getShading() != cardsSelected[2].getShading()))) {
            isTriple = false;
        }
        
        if (isTriple)
        {
            actionIfTriple();
        }
        else
        {
            Animations.wobble(cardsSelected);
        }
        
        return isTriple;
    }
    
    public void actionIfTriple()
    {
        int position[][] =  new int[3][2];
        Animations.slideAndTurn(cardsSelected);
        for(int i = 0; i < 3; i++)
        {
            position[i][0] = cardsSelected[i].getX();
            position[i][1] = cardsSelected[i].getY();
            getWorld().removeObject(cardsSelected[i]);
        }
        for(int i = 0; i < 3; i++)
        {
            if(numCardsInDeck > 0){
                getWorld().addObject(deck.getTopCard(), position[i][0], position[i][1]);
                numCardsInDeck--;
            }
        }
        triplesRemaining--;
        Scorekeeper.updateScore();
        setUI();
        if(triplesRemaining == 0)
        {
            endGame();
        }
    }
    
    public void setCardsSelected(ArrayList<Card> cards, ArrayList<Integer> ints, Card card[])
    {
        for(int i = 0; i < 3; i++)
        {
            cardsSelected[i] = cards.get(ints.get(i));
        }
    }
    
    /**
     * Act - do whatever the Dealer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
