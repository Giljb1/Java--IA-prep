


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.Group; 

import java.util.Random; //Random Class
import java.util.Arrays; //Array Class

/**
 * Write a description of JavaFX class TicketWin here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TicketWin 
{
    Label title;    
    Button playBtn;
    Text text;
    
    private int[] lotteryTicket; //Player lottery ticket
    private int[] winningCombo;
    LotteryMachine powerBall;
    
    TicketWin(int max){
        System.out.println("Ticket Created with max val of: " + max);
        
        
        //Lottery from 0-36
        powerBall = new LotteryMachine(10);
        
        //Create player ticket of 6 numbers between 0-36
        this.lotteryTicket = powerBall.createLotteryTicket();
        
        //Output player ticket
        System.out.println(powerBall.toString());
        
        display();
        
    }
    
    
  
    public void display()
    {
        
        Stage stage = new Stage();
        stage.setTitle("Ticket");
        
        //Create view in Java
        
        title = new Label("0");
        title.setText(powerBall.toString());
    
        
        
        //setting the position of the text 
        //text.setX(50); 
        //text.setY(50); 
         
        playBtn = new Button("play");
        
        //set the button to create ticket
        playBtn.setOnAction(this::buttonClick);       
       
        VBox container = new VBox(title,playBtn);
        //Style container
        //container.setSpacing(15);
        //container.setPadding(new Insets(25));
    
        
        //container.setAlignment();
        //Set view in window
        Scene sc = new Scene(container,400,400);
        stage.setScene(sc);
        
        //Launch
        stage.show();
        
        
    }

    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     */
    private void buttonClick(ActionEvent event)
    {
        
        System.out.println("Self destruct");
        
        //Create Winning combination
        
        //Check ticket for winning combination
        
        //Display winning or earning = new window
        
        
    }
    
    
    
     
    
}
