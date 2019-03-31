package javaapplication16;

import java.util.*;

class invoice{
	Scanner scn = new Scanner(System.in);
        Scanner scn2 = new Scanner(System.in);
        Scanner scn3 = new Scanner(System.in);

	String saddress,baddress;
        String items ; 
	int quant  ;
	int payrec ;
        int amodue ; 

	
	public void Item(){
            System.out.println("Give item: ");
		this.items=scn.nextLine();
            System.out.println("Give countity of item: ");
		this.quant=scn.nextInt();
	}
	public void Address(){
		System.out.println("Enter shipping address: ");
		this.saddress=scn2.nextLine();
		System.out.println("Enter billing address: ");
		this.baddress=scn2.nextLine();
	}
	public void Payment(){
		System.out.println("Enter payment ammount: ");
		this.payrec=scn.nextInt();
	}
	public void displayInvoice(){
		System.out.println("\nShipping Address: " + this.saddress);
		System.out.println("Billing Address: " + this.baddress);
		
		
			System.out.println("Item: " + items);
                        System.out.println("quantities ordered: " + quant);
		
		System.out.println("payments received: " + this.payrec);
		System.out.println("amounts still due: " + (quant-this.payrec) + "\n");	
	}
        public int end(){
            System.out.println("if you want to stop press 0");
            int t = scn3.nextInt();
            return t;
        }   
        public int same(){
            System.out.println("more products ? 1 for Yes /0 for NO ");
            int ans = scn3.nextInt();
            return ans;
        }
}        
        


public class JavaApplication16{
	public static void main(String[] args){
            int t=2;
            int  ans=0;
            String sas = null,bas = null;
            while (t!=0){
		invoice order = new invoice();
		order.Item();
                if (ans==0){ 
                order.Address();
                }
                order.Payment();
		order.displayInvoice();
                t=order.end();
                if (ans==0){
                ans=order.same();
                }
            }
	} 
} 