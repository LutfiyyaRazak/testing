import java.util.*;
import java.lang.*;
import java.io.*;
import java.net.*;


public class Practical2{
	private String data;
	private Friends old;
	
	public Practical2(){
			File file = new File("friend.txt");
			try{
				old = new Friends();
				Scanner scan = new Scanner(file);
				
				while(scan.hasNextLine()){
					old.add(scan.nextLine());
					System.out.println("friend added.");
				}
				scan.close();
			}
			catch(Exception e){
				System.out.println("Error: "+e.getMessage());
				try{
					file.createNewFile();
				}
				catch(Exception ex){System.out.println("Error: "+ex.getMessage());}
			}
	}
	
	
	public static void main(String[] args)
	{
		Interface terminal = new Interface();
		ServerSocket ss = null;
		try{
			ss = new ServerSocket(22222);
			
			Practical2 obj = new Practical2();
			String input = "";
			int c = 1;
			while(true){
				System.out.println("Waiting for connection...");
				do{
					Socket s = ss.accept();
					System.out.println("connection "+c+" established.");
					PrintWriter screen = new PrintWriter(s.getOutputStream(),true);
					BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
					boolean quit = false; 
					
					while(true){
						try{
							terminal.menu(0,screen); 
							input  = reader.readLine();
							if(input == null) break;
							
							switch(input){
									case "1":
										terminal.menu(1,screen); 
										screen.flush();
								
										screen.write(27);
										screen.print("[9;0HPlease enter Friends Name: ");
										screen.flush();
										String name = reader.readLine();
									
										screen.write(27);
										screen.print("[11;0HPlease enter the Phone number: ");
										screen.flush();
										String phoneNum = reader.readLine();
									
										obj.old.add("{" + name + ", " + phoneNum + "}" );
										System.out.println("New Friend Added: " + "{" + name + ", " + phoneNum + "}");
									
										break;
									case "2":
										terminal.menu(2,screen);
										
										int pos =obj.old.getAllfriends(screen);
										
										System.out.println("Friends listed.");
										screen.write(27);
										screen.print("["+(pos+1)+";0HPress Enter to continue: ");
										screen.flush();
										String in = reader.readLine();
										break;
									case "3":
										terminal.menu(3,screen);
										
										String val = reader.readLine();
										screen.write(27);
										screen.print("[10;0HSearch Results:");
										screen.flush();
										int d = obj.old.getfriends(val,screen);
										
										
										System.out.println("Friends searched.");
										screen.write(27);
										screen.print("["+(d+1)+";0HPress Enter to continue: ");
										screen.flush();
										val = reader.readLine();
										break;
									case "4":
										terminal.menu(4,screen); 
										
										String cv = reader.readLine();
										
										boolean removed = obj.old.remove(cv);
										if(removed)
										{	screen.write(27);
											screen.print("[10;0HFriend deleted");
											screen.write(10);
											screen.flush();
										}else
										{
											screen.write(27);
											screen.print("[10;0HFriend Not deleted");
											screen.write(10);
											screen.flush();
										}		
										
										System.out.println("\nFriend deleted\n");
										screen.write(10);
										screen.write(27);
										screen.print("[12;0HPress Enter to continue: ");
										screen.flush();
										cv = reader.readLine();
										break;
									
									case "5":
										screen.write(27);
										screen.print("[17;0HExiting server...");
										screen.write(10);
										screen.flush();
										
										quit = true;
										break;
								}
								if(quit == true) {
									input = "quit";
									c = 0;
									break;
								}
							}
							catch(Exception ex){
								System.out.println(ex.getMessage());
							}
						}
					c++;
					screen.close();
					s.close();
				}
				
				while(input != "quit");
				obj.old.export();
				System.out.println("connection closed.");
				input = "";
			}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			try{
			ss.close();
			}catch(IOException ioe){System.out.println(ioe.getMessage());}
		}
	}
}
