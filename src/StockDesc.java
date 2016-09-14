import java.util.ArrayList;
import java.util.Scanner;

public class StockDesc {
	
	static ArrayList<Integer> equityCalc(ArrayList<Integer> arrayList){
		int i,j,temp;
		int length=arrayList.size();
		
		//Utilizing selection sort
		for(i=0;i<length;i++){
			for(j=i+1;j<length;j++){
				if(arrayList.get(j)<arrayList.get(i)){
				 temp = arrayList.get(i);
				 arrayList.set(i, arrayList.get(j));
				 arrayList.set(j, temp);
				}
			}
		}
		return arrayList;
	}
	
	
	public static void main(String arg[]){
		//Implementation to know buy/sell/hold for the given equity
		
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		int median;
		
		System.out.println("How many values are there for median calculation");
		Scanner medCount = new Scanner(System.in);
		int count = medCount.nextInt();
		
		System.out.println("Please insert number of values to caluculate buy/hold/sell ");
		Scanner calc = new Scanner(System.in);
		while(arraylist.size()<=count-1){
		 int i = calc.nextInt();
		 arraylist.add(i);  
		}
		
		int length = arraylist.size();
		System.out.println("please insert the current stock value");
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();

		ArrayList<Integer> sortedList = equityCalc(arraylist);

        System.out.println("Sorted Stock Values"+sortedList);
		
		if((length%2) == 0){
			median = (sortedList.get(length/2) + sortedList.get((length/2)+1)) / 2 ;
			System.out.println("Median value is "+" "+median);
		}
		else{
		    median = sortedList.get(length/2);
		    System.out.println("Median value is "+" "+median);
		}
		
		if(value<median)
			System.out.println("You can sell the stock");
		if(value>median)
			System.out.println("You can Buy the stock");
	    if(value == median)
	    	System.out.println("You can hold the stock");
	

		sc.close();
		medCount.close();
		calc.close();
	}

}
