
import java.util.Random; //Random Class
import java.util.Arrays; //Array Class


public class LotteryMachine {
    
    //Properties
    private int max;  //number between 0-max
    private int[] lotteryTicket;
    private int[] winningCombo;
    
    private final int INTERVAL = 36;
    
    //Create the machine
    public LotteryMachine(int max){
        
        this.setMax(max);
        this.lotteryTicket = new int[6]; //Allocate space for ticket of 6 number
        this.winningCombo = new int[this.getMax()]; //Set size of winning combination
    }
    
    //Getters and setters
    public int getMax(){ return this.max;}
    
    public void setMax(int newMax){
        this.max = newMax;
    }
    
    //Ticket
    public String toString(){
        return "ticket" + Arrays.toString(this.lotteryTicket);
    }
    
    //Creates a ticket with 6 randomly selected numbers
    public int[] createLotteryTicket(){
        
        for (int i =0 ; i< 6 ; i++){
            this.lotteryTicket[i] = 1 + randNum(INTERVAL); //1-36
        }
        
        System.out.println("Lottery ticket pre-cleaned: " + Arrays.toString(this.lotteryTicket));
        
        //Clean duplicates
        this.lotteryTicket = removeDuplicates(this.lotteryTicket); //Clean duplicates out
        //System.out.println("Lottery ticket cleaned: " + Arrays.toString(this.lotteryTicket));
        return this.lotteryTicket;
    }
    
    //Creates a ticket with 6 randomly selected numbers
    public int[] createWinningCombo(){
        
        for (int i =0 ; i< this.getMax() ; i++){
            this.winningCombo[i] = 1 + randNum(INTERVAL); //1-36
        }
        
        this.winningCombo = removeDuplicates(this.winningCombo);
        
        return winningCombo;
    }
    
    
    //Process the player ticket
    public void processTicket(int[] ticket, int[] winningCombo){
        
        int count = 0;
        
        for(int i = 0 ; i< ticket.length ; i++){ //Compare each ticket number
         
            for(int j = 0 ; j< winningCombo.length ; j++){ //Compare each winning number
         
                if(ticket[i] == winningCombo[j]){
                    //Don't count 0 they represent duplicates removed
                    if(ticket[i] != 0 || winningCombo[j]!=0){ 
                        count ++;
                        System.out.print("\nWinning number: " + ticket[i]);
                    }
                }
            } 
         
        } 
        
        System.out.println("\n\nAmount of winning numbers: " + count);
        System.out.println("\n" + this.getReward(count));
    }
    
    //Create a string for the winner of looser
    public String getReward(int count){
        
        String message="";
        
        if (count == 8) message += "You are a billionaire";
        if (count == 7) message += "You win $100 millions";
        if (count == 6) message += "You win 1 million";
        if (count == 5) message += "You win $100k";
        if (count == 4) message += "You win $10k";
        if (count == 3) message += "You win $1000";
        if (count == 2) message += "You win $1";
        if (count < 1) message  += "Loser";
        
        return message;
        
    }
    
    //-----------------Utility methods------------------------
    
    //Check adjacent values for duplicates
    public int[] removeDuplicates(int[]a){
        
        //Create an array of duplicates index
        int[] ticketNoDuplicates = new int[a.length];
        int duplicateIndex = 0;
        int temp=0;
        
        //sort array first
        Arrays.sort(a);
        //System.out.println("Sorted: " + Arrays.toString(a));
        
        
        ticketNoDuplicates[0] = a[0]; //Copy the first element
        
        duplicateIndex = 1; //Skip the first
        
        //Traverse array and skip the first one
        for(int i=1 ; i<a.length ; i++){
            //Check that adjacent values are not duplicates
            if( a[i-1] != a[i] ){ 
                ticketNoDuplicates[duplicateIndex] = a[i];
            }
            duplicateIndex++; //Move to the next cell
        }
        //System.out.println("Lottery ticket cleaned: " + Arrays.toString(ticketNoDuplicates));
        
        return ticketNoDuplicates;   //Return a reference
        
    }
 
    
    /*
     Generate a random number between 0 (inclusive) to max value(exclusive)
     @max  the maximum value(exclusive)
    */
    public int randNum(int max){
        
        //Create generator
        Random r= new Random();
        
        return r.nextInt(max);
 
    }
    
    
    
    
}