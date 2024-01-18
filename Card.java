import greenfoot.*; 

/**
 * Game Board for Triples
 * 
 * @Kyle Jin
 * @Jan 8, 2024
 */

public class Card extends Actor
{
    // Enumerations
    public enum Shape
    {
        TRIANGLE, SQUARE, CIRCLE, NO_SHAPE
    }
    
    public enum Color
    {
        RED, GREEN, BLUE, NO_COLOR
    }
   
    // Fields
    private Shape shape;
    private Color color;
    private boolean isSelected;
    private GreenfootImage cardImage, selectedCardImage;
    private int numberOfShapes, shading;
    
    // Constructor
    public Card(Shape shape, Color color, int numberOfShapes, int shading, GreenfootImage cardImage, GreenfootImage selectedCardImage)
    {
        this.shape = shape;
        this.color = color;
        this.numberOfShapes = numberOfShapes;
        this.shading = shading;
        this.cardImage = cardImage;
        this.selectedCardImage = selectedCardImage;
        this.isSelected = false;
        setImage(cardImage);
    }
    
    // Methods
    
    // *Getter Methods
    public Shape getShape()
    {
        return shape;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public boolean getIsSelected()
    {
        return isSelected;
    }
    
    public GreenfootImage getCardImage()
    {
        return cardImage;
    }
    
    public GreenfootImage getSelectedCardImage()
    {
        return selectedCardImage;
    }
    
    public int getNumberOfShapes()
    {
        return numberOfShapes;
    }
    
    public int getShading()
    {
        return shading;
    }
    
    // *Setter Methods
    public void setIsSelected(boolean isSelected)
    {
        this.isSelected = isSelected;
    }
}

