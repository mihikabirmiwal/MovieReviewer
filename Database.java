//GOOD
import java.util.Scanner;
import java.util.HashMap;
public class Database 
{
	public Database()
	{
		super();
		stock();
	}
	
	static HashMap<String, int[]> weights = new HashMap();
	public HashMap<String, int[]> getDatabase()
	{
		return weights;
	}
	
	public static void main(String[] args) 
	{
		Database db = new Database();
		Scanner scan = new Scanner("moviereviews.txt");
		Scanner uin = new Scanner(System.in);	
		System.out.println("Please enter your movie review.");
		String review = uin.nextLine();
		System.out.println("The rating is: " + calcRating(review, weights));
	}
	public void stock()
	{
        Scanner scan = new Scanner(this.getClass().getResourceAsStream("moviereviews.txt"));
		while(scan.hasNextLine())	//filling up reference hashmap
		{
			String[] myArray = scan.nextLine().split(" ");
			int value = Integer.parseInt(myArray[0]);
			for(int i=1;i<myArray.length;i++)
			{
				if(!weights.containsKey(myArray[i]))	//hashMap doesn't have the word already
				{
					int[] newWordData = new int[2];
					newWordData[0] = value;
					newWordData[1] = value;
					weights.put(myArray[i], newWordData);
				}
				else	//hashMap already has the word
				{
					int[] oldWordData = new int[2];
					oldWordData[0] = weights.get(myArray[i])[0];
					oldWordData[1] = weights.get(myArray[i])[1];
					oldWordData[0] = oldWordData[0] + value;
					oldWordData[1]++;
					weights.remove(myArray[i]);
					weights.put(myArray[i], oldWordData);					
				}
			}
		}        
	}
	public static double calcWeight(int[] hash)	//for each word
	{
		double val = 1.0*hash[0]/hash[1];
		return val;
	}	
	
	public static double calcRating(String s, HashMap<String, int []> reference)
	{
		double rating;
		String[] review = s.split(" ");
		double points = 0;
		int counter = 0;
		for(int i=0;i<review.length;i++)
		{
			points+= calcWeight(reference.get(review[i]));
			counter++;
		}
		rating = points/counter;
		return rating;
	}
}
