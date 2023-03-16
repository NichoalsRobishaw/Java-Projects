import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// simple calculator app with usual operations. Added modulo operator

public class Calculator implements ActionListener 
	{
	// global variables
	JFrame frame;
	JTextField textfield;
	// array to hold all buttons ( numbers, functional )
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[10];
	
	JButton addButton, subButton, multButton, divButton, modButton;
	JButton decButton, eqlButton, delButton, clrButton, negButton;
	
	JPanel panel;
	
	Font myFont = new Font("Ink Free", Font.BOLD, 30);
	
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	Calculator() 
		{
		// create the frame title, close operation, window size, and layout
		frame = new JFrame("CS Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,550);
		frame.setLayout(null);
		
		// create textfield for numbers, create size of textfield and make sure use cannot type inside it
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setEditable(false);
		textfield.setFont(myFont);
		
		// operator buttons
		addButton = new JButton("+");
		subButton = new JButton("-");
		multButton = new JButton("*");
		divButton = new JButton("/");
		modButton = new JButton("%");
		
		// functional buttons
		decButton = new JButton(".");
		eqlButton = new JButton("=");
		delButton = new JButton("DEL");
		clrButton = new JButton("CLR");
		negButton = new JButton("(-)");
		
		// set index's of functionalButtons array
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = multButton;
		functionButtons[3] = divButton;
		functionButtons[4] = modButton;
		functionButtons[5] = decButton;
		functionButtons[6] = eqlButton;
		functionButtons[7] = delButton;
		functionButtons[8] = clrButton;
		functionButtons[9] = negButton;
		
		// loop through each button 
		for(int index = 0; index < 10; index++)
			{
			// add a listener to check if clicked
			functionButtons[index].addActionListener(this);
			
			// change font
			functionButtons[index].setFont(myFont);
			
			// disable text outline on button
			functionButtons[index].setFocusable(false);
			
			}
		
		// set index's of numberButtons array
		for(int numIndex = 0; numIndex < 10; numIndex++)
			{
			// create buttons for ( 0 - 9 ) and assign each button as wrapper class of string
			numberButtons[numIndex] = new JButton(String.valueOf(numIndex));
			
			// add a listener to check if clicked
			numberButtons[numIndex].addActionListener(this);
						
			// change font
			numberButtons[numIndex].setFont(myFont);
						
			// disable text outline on button
			numberButtons[numIndex].setFocusable(false);
			}
		
		
		// create buttons for Delete, negative and Clear
		negButton.setBounds(50, 430, 100, 50);
		delButton.setBounds(150,430,100,50);
		clrButton.setBounds(250,430,100,50);
		
		// create JPanel to hold grid of numbers
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(5,5,10,10));
		
		// add all buttons to panel
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(multButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(eqlButton);
		panel.add(divButton);
		panel.add(modButton);
		
		
		// add all components to frame and make it visible
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
		
		}
	
	public static void main(String[] args) 
		{
		// run the calculator function
		Calculator calc = new Calculator();
		
		}

	@Override
	public void actionPerformed(ActionEvent event) 
	    {
		// this is where the functionality of the buttons is done
		
		// check if someone hit a number
		for(int index = 0; index < 10; index++)
		    {
			// check if the event action was the index
			if(event.getSource() == numberButtons[index])
			    {
				// display number to textfield
				textfield.setText(textfield.getText().concat(String.valueOf(index)));
			    }
		    }
		
		// functionality of decimal button
		if(event.getSource() == decButton)
		    {
			textfield.setText(textfield.getText().concat("."));
		    }
		
		// functionality of add button
		if(event.getSource() == addButton)
	        {
			// grab number in textfield and store in num1
		    num1 = Double.parseDouble(textfield.getText());
		    
		    // set operator to addition
		    operator = '+';
		    
		    // clear textfield
		    textfield.setText("");
	        }
		
		// functionality of subtraction button
        if(event.getSource() == subButton)
            {
            // grab number in textfield and store in num1
            num1 = Double.parseDouble(textfield.getText());
				    
            // set operator to addition
            operator = '-';
				    
            // clear textfield
            textfield.setText("");
			        
            }
        
	    // functionality of multiplication button
        if(event.getSource() == multButton)
            {
            // grab number in textfield and store in num1
            num1 = Double.parseDouble(textfield.getText());
			    
            // set operator to addition
            operator = '*';
			    
            // clear textfield
            textfield.setText("");
		    }
        
	    // functionality of division button
        if(event.getSource() == divButton)
            {
            // grab number in textfield and store in num1
            num1 = Double.parseDouble(textfield.getText());
				    
            // set operator to addition
            operator = '/';
				    
            // clear textfield
            textfield.setText("");
			        
            }
        
		// functionality of modulo button
        if(event.getSource() == modButton)
            {
            // grab number in textfield and store in num1
            num1 = Double.parseDouble(textfield.getText());
				    
            // set operator to addition
            operator = '%';
				    
            // clear textfield
            textfield.setText("");
			        
            }
      
        // equal button functionality
        if(event.getSource() == eqlButton)
            {
        	// set num2 to whatever is in the textfield
        	num2 = Double.parseDouble(textfield.getText());
        	
        	// figure out what operation is being used
        	switch(operator)
        	  {
        	  case'+':
        		  result = num1 + num2;
        		  break;
        	  case'-':
        		  result = num1 - num2;
        		  break;
        	  case'*':
        		  result = num1 * num2;
        		  break;
        	  case'/':
        		  result = num1 / num2;
        		  break;
        	  case'%':
        		  result = num1 % num2;
        		  break;
        	  }
        	
        	// update textfield with result
        	textfield.setText(String.valueOf(result));
        	num1 = result;
            }
        
        
        // functionality of clear button
        if(event.getSource() == clrButton)
          {
          // set textfield to empty
          textfield.setText("");
		        
          }
        
        // functionality of delete button
        if(event.getSource() == delButton)
          {
          // grab current text in textfield
          String oldStr = textfield.getText();
          
          // set textfield to empty
          textfield.setText("");
          
          // print out old string just up to 2nd to last char
          for(int index = 0; index < oldStr.length()-1; index++)
            {
        	textfield.setText(textfield.getText()+oldStr.charAt(index)); 
            }
		        
          }
        
        // functionality of negative button
        if(event.getSource() == negButton)
          {
          // take whatever is in the textfield and store in temp
          double temp = Double.parseDouble(textfield.getText());
          
          // make temp a negative number
          temp= temp *(-1);
          
          // display negative textfield
          textfield.setText(String.valueOf(temp));
          }
	    // end of method
	    }


	
}
