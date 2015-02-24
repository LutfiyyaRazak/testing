import java.util.*;
import java.lang.*;
import java.io.*;
import java.net.*;

public class Friends{
	private Vector<String> friends;
	
	public Friends(){
		friends = new Vector<String>();
	}
	
	
	public void add(String a){
		friends.add(a);
	}
	
	public void clear(){
		friends.clear();
	}
	
	public boolean remove(String a){
		int index = getIndex(a);
		if(index != -999){
			friends.remove(index);
			return true;
		}
		return false;
	}
	
	public boolean search(String a){
		for(String s : friends){
			if(s.toLowerCase().contains(a.toLowerCase())){
				return true;
			}
		}
		return false;
	}
	
	public int getIndex(String a){
		for(int i = 0; i < friends.size();i++){
			if(friends.get(i).toLowerCase().contains(a.toLowerCase()) && !a.equals("")){
				return i;
			}
		}
		return -999;
	}
	
	public int getAllfriends(PrintWriter screen){
		String a = "";
		if(friends.isEmpty()){
			screen.write(27);//Esc
			screen.print("[9;0HNo friends available");
			screen.write(10);
			screen.flush();
			return 10;
		}
		
		int v = 9;
		for(String s : friends){
			screen.write(27);
			screen.print("["+v+";0H"+s);
			screen.write(10);
			screen.flush();
			v += 2;
		}
		
		return v;
	}
	
	public String getFriend(int index){
		if(index >= 0)
			return friends.get(index);
		return "none\n";
	}
	
	public int getfriends(String a,PrintWriter screen){
		int output = 12;
		if(friends.isEmpty()){
			screen.write(27);
			screen.print("[12;0HNo friends available");
			screen.write(10);
			screen.flush();
			return 13;
		}
		
		for(String s : friends){
			if(s.toLowerCase().contains(a.toLowerCase())){
				screen.write(27);
				screen.print("["+output+";0H"+s);
				screen.write(10);
				screen.flush();
				output += 2;
			}
		}
		
		if(output == 12) {
			screen.write(27);
			screen.print("[12;0HThere is no friends that matches your search.");
			screen.write(10);
			screen.flush();
		}
		return output;
	}
	
	public void export(){
		File file = new File("friend.txt");
		try{
			if(file.exists()){
				file.delete();
			}
			
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			for(String s : friends){
				fw.append(s+"\n");
			}
			
			fw.close();
		}
		catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
	}
}
