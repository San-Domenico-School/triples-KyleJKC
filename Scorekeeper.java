/**
 * Write a description of class Scorekeeper here.
 * 
 * @Kyle Jin
 * @Jan 18, 2024
 */
public class Scorekeeper  
{
    private static int deckSize, score;
    private static long startTime = System.currentTimeMillis();
    
    public static void setDeckSize(int size)
    {
        deckSize = size;
    }
    public static void updateScore()
    {
        score += 3;
    }
    public static int getScore()
    {
        return score;
    }
}
