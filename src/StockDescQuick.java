import java.util.ArrayList;
import java.util.Scanner;

public class StockDescQuick {
	
	static ArrayList<Integer> equityCalc(ArrayList<Integer> arrayList, int low, int high){
         
		int middle = low + (high-low)/2;
		int pivot = arrayList.get(middle);
		int i=low, j=high;
		
		while(i<=j){
			while(arrayList.get(i)< pivot)
				i++;
			while(arrayList.get(j)>pivot)
				j--;
			if(i<=j){
				int temp = arrayList.get(i);
				arrayList.set(i,arrayList.get(j));
				arrayList.set(j,temp);
				i++;
				j--;
			}
		}
		
		if(low< j)
			equityCalc(arrayList,low,j);
		if(high> i)
			equityCalc(arrayList,i,high);
		
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
		
        int low=0, high = arraylist.size()-1;
		int length = arraylist.size();
		
		System.out.println("Please insert the current stock value");
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();
		
		ArrayList<Integer> sortedList = equityCalc(arraylist,low,high);

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
