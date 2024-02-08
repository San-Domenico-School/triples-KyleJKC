import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Player.class
 * 
 * @Kyle Jin
 * @Jan 29, 2024
 */
public class Player extends Actor
{
    // Fields
    private Dealer dealer;
    private Card cardsSelected[];
    private ArrayList<Card> cardsOnBoard;
    private ArrayList<Integer> selectedCardsIndex;
    
    // Constructor
    public Player(Dealer dealer)
    {
        this.dealer = dealer;
        this.cardsSelected = new Card[3];
        this.cardsOnBoard = new ArrayList<Card>();
        this.selectedCardsIndex = new ArrayList<Integer>();
    }
    
    // Methods
    public void addedToWorld(World world)
    {
        cardsOnBoard = (ArrayList) getWorld().getObjects(Card.class);
    }
    
    private void selectCards()
    {
        for (int i = 0; i < cardsOnBoard.size(); i++)
        {
            if(Greenfoot.mouseClicked(cardsOnBoard.get(i)))
            {
                if(cardsOnBoard.get(i).getIsSelected())
                {
                    cardsOnBoard.get(i).setIsSelected(false);
                    cardsOnBoard.get(i).setImage(cardsOnBoard.get(i).getCardImage());
                    selectedCardsIndex.remove(Integer.valueOf(i));
                }
                else
                {
                    cardsOnBoard.get(i).setIsSelected(true);
                    cardsOnBoard.get(i).setImage(cardsOnBoard.get(i).getSelectedCardImage());
                    selectedCardsIndex.add(i);
                }
            }
        }
    }
    
    private void resetCardsSelected()
    {
        for (Card card : cardsOnBoard)
        {
            card.setImage(card.getCardImage());
            card.setIsSelected(false);
        }
        selectedCardsIndex.clear();
    }
    
    private boolean setCardsSelected()
    {
        for(int i = 0; i < selectedCardsIndex.size(); i++)
        {
            cardsSelected[i] = cardsOnBoard.get(i);
        }
        
        return (selectedCardsIndex.size() == 3) ? true : false;
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        selectCards();
        boolean threeCardsHaveBeenSelected = setCardsSelected();
        if(threeCardsHaveBeenSelected)
        {
            dealer.setCardsSelected(cardsOnBoard, selectedCardsIndex, cardsSelected);
            dealer.checkIfTriple();
            resetCardsSelected();
        }
        cardsOnBoard = (ArrayList) getWorld().getObjects(Card.class);
    }
}
