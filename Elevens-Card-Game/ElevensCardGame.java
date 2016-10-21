//Created by Catherine Markley

public class ElevensCardGame
{
   public static void main(String[] args)
   {
      Deck deck = new Deck();
      System.out.println(deck.toString1());
   }
}


class Deck 
{
	private String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
    private String[] ranks = {"ace","two","three","four","five","six","seven","eight","nine","ten","jack","queen","king"};
    private int[] numbers = {11,2,3,4,5,6,7,8,9,10,10,10,10};
    private Card[] cards;

   public Deck() 
   {
      cards = new Card[52];
      
      int indexSuit = 0;
      int indexRank = 0;
      int indexNumber = 0;

	  for(int indexCard = 0;indexCard <=51;indexCard++)
	  {
	  	cards[indexCard] = new Card(suits[indexSuit],ranks[indexRank],numbers[indexNumber]);
	  	indexSuit++;
	  	indexRank++;
	  	indexNumber++;
	  	
	  	if (indexSuit > 3)
	  		indexSuit = 0;
	  	if (indexRank > 12)
	  		indexRank = 0;
	  	if (indexNumber > 12)
	  		indexNumber = 0;
	  }
	  
	  for(int x = 1;x <=1000;x++)
	  {
	  	shuffle();
	  }

    }  
   
    public String toString1()
    {
       String temp = "";
       for(int k = 0; k < 51; k++)
    		 temp = temp + cards[k].toString() + "\n";
       return temp;   
    }
    
    public void shuffle()
    {
    	Card temp;
    	int indexCard1;
    	int indexCard2;
    	indexCard1 = (int)(Math.random()*51);
    	indexCard2 = (int)(Math.random()*51);
    	
    	temp = cards[indexCard1];
    	cards[indexCard1] = cards[indexCard2];
    	cards[indexCard2] = temp;
    	
    }
    
 }
 
 class Card
 {
 	public String suit1;
 	public String rank1;
 	public int number1;
 	
 	public Card(String s,String r,int n)
 	{
 		suit1 = s;
 		rank1 = r;
 		number1 = n;
 	}
 	
 	public String toString()
 	{
 		String temp;
 		temp = "" + suit1 + "," + rank1 + "," + number1;
 		return temp;
 	}

 }