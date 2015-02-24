import java.util.*;
import java.lang.*;
import java.io.*;
import java.net.*;


public class Interface{

	public void menu(int number,PrintWriter screen)
	{
		screen.write(27);
		screen.print("[32;1m"); //colour green
		screen.flush();
		
		if(number == 0){
			screen.write(27);//Esc
			screen.print("[2J");// clear screen
			screen.flush();
			
			screen.write(10);
			screen.flush();
			screen.write(27); //Esc
			screen.print("[0;0H**********************************************");
			screen.flush();
			
			screen.write(27); 
			screen.print("[3;10HFRIENDS PHONEBOOK MENU");
			screen.write(10);
			screen.write(10); 
			screen.flush();
			
			screen.write(27);
			screen.print("[6;0H1 - Add New Friend");
			screen.write(10);
			screen.write(10); 
			screen.flush();
			screen.write(27);
			screen.print("[7;0H2 - List All Friends");
			screen.write(10); 
			screen.write(10);
			screen.flush();
			
			screen.write(27);
			screen.print("[8;0H3 - Search Friend");
			screen.write(10);
			screen.write(10); 
			screen.flush();
			
			screen.write(27);
			screen.print("[9;0H4 - Delete Friend");
			screen.write(10);
			screen.write(10); 
			screen.flush();
			
			screen.write(27);
			screen.print("[10;0H5 - Exit");
			screen.write(10); 
			screen.write(10); 
			screen.flush();
			
			screen.write(27);
			screen.print("[13;0H**********************************************");
			screen.write(10); 
			screen.flush();
			
			screen.write(27);
			screen.print("[16;0HPlease Enter a choice: ");
			screen.flush();
		}
		else if(number == 1) 
		{
			screen.write(27);
			screen.print("[2J");
			screen.flush();
			
			screen.write(27);
			screen.print("[0;0H**********************************************");
			screen.flush();
			
			screen.write(10); 
			screen.flush();
			screen.write(27);
			screen.print("[3;10HAdd New Friend");
			screen.write(10); 
			screen.flush();
			screen.write(27);
			screen.print("[6;0H**********************************************");
			screen.write(10); 
			screen.flush();
			screen.write(10); 
			screen.flush();
			
		}
		else if(number == 2) 
		{
			screen.write(27);
			screen.print("[2J");
			screen.flush();
			
			screen.write(27);
			screen.print("[0;0H**********************************************");
			screen.flush();
			
			screen.write(10); 
			screen.flush();
			screen.write(27);
			screen.print("[3;10HList Friends");
			screen.write(10);
			screen.flush();
			screen.write(27);
			screen.print("[6;0H**********************************************");
			screen.write(10); 
			screen.flush();
			screen.write(10); 
			screen.flush();
		}
		else if(number == 3)
		{
			screen.write(27);
			screen.print("[2J");
			screen.flush();
			
			screen.write(27);
			screen.print("[0;0H**********************************************");
			screen.flush();
			
			screen.write(10);
			screen.flush();
			screen.write(27);
			screen.print("[3;10HSearch Menu");
			screen.write(10); 
			screen.flush();
			screen.write(27);
			screen.print("[6;0H**********************************************");
			screen.write(10); 
			screen.flush();
			screen.write(10); 
			screen.flush();
			
			screen.write(27);
			screen.print("[8;0HPlease enter search value (name or phone number ): ");
			screen.flush();
		}
		else if(number == 4)
		{
			screen.write(27);
			screen.print("[2J");
			screen.flush();
			
			screen.write(27);
			screen.print("[0;0H**********************************************");
			screen.flush();
			
			screen.write(10); 
			screen.flush();
			screen.write(27);
			screen.print("[3;10HDelete Friend");
			screen.write(10); 
			screen.flush();
			screen.write(27);
			screen.print("[6;0H**********************************************");
			screen.write(10);
			screen.flush();
			screen.write(10);
			screen.flush();
			
			screen.write(27);
			screen.print("[8;0HDelete Friend by (name or phone number ): ");
			screen.flush();
		}
	}
}
