import java.util.Scanner;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
/**
 * 	Pulls data from the tables, and then matches rows in the tables/txt files
 * 	using some math. 
 * 
 * 
 * @author 	Ronith Vinod Chikkaballapur
 * 			ronith.cv@gmail.com

 * @since 	June 25th, 2024.
 */

public class FirstTable{
	public static void main(String[] args){
		FirstTable tf = new FirstTable();
		tf.runner();

	}
	public void runner(){
		//getting values form first table
		Scanner box = FileUtils.openToRead("FirstTable.txt");
		Scanner bird = FileUtils.openToRead("SecondTable.txt");
		String text = "";
		ArrayList<Entry> vals = new ArrayList<Entry>();


		while(box.hasNextLine()){
			String line = box.nextLine();
			Entry el = new Entry(line);
			text += "\n"+line;

			String line2 = bird.nextLine();
			ValueSheet vl = new ValueSheet(line2);
			if(Math.abs(vl.values[2]-vl.values[0] - el.totalCharges) < 0.1 || Math.abs(vl.values[2]-vl.values[0] -vl.values[1]- el.totalCharges) < 0.1 
				|| Math.abs(vl.values[2]-vl.values[0] - el.pgeRev) < 0.1 || Math.abs(vl.values[2]-vl.values[0] -vl.values[1]- el.pgeRev) < 0.1 ){
				el.sheet = vl;
				System.out.println("LINKED");
			}
			else System.out.println("NO LINK FOUND");
			vals.add(el);


		}
		createSheets(vals, "Fremont");

		System.out.println(vals.size());
	}
	public void createSheets(ArrayList<Entry> vals, String school){
		String nm = school + ".csv";
		PrintWriter pw = FileUtils.openToWrite(nm);
		pw.println("School, Date, KWH, Therms");

		for(Entry entry : vals){
			if(entry.school.equals(school)){
				try{
					System.out.println(entry +" $" + entry.pgeRev + " $" + entry.sheet.values[2]);
					pw.println(entry);
				}
				catch(Exception e){
					pw.println("Error here -- check again: NO LINK FOUND");
				}
			}
		}
		pw.close();

	}


}
/*
class Row{
	ArrayList<Entry> entries;
	public Row(){
		entries = new ArrayList<Entry>();
	}
	public void add(Entry entry){
		entries.add(entry);
	}
}
class Date{
	int day;
	int month;
	int year;
	public Date (int a, int b, int c){
		day = a; 
		month = b;
		year = c;
	}


}

class SortedBySchool {
	ArrayList<Entry> list;
	String school;
	public SortedBySchool(String schoo){
		list = new ArrayList<Entry>();
		school = shoo;
	}
	public Entry getEntry(int a){
		return list.get(a);
	}
	public void add(Entry entry){
		if(entry.school.equals(school))
			list.add(entry);
	}

	public void startProcess(){
		add(row)
	}
}*/

class Entry{
	String school;
	int day;
	int month;
	int year;
	double price;
	int kwh;
	int therm;
	ValueSheet sheet;
	double totalCharges;
	double pgeRev;
	//Date date;
	public Entry(String text){
		if(text.indexOf("589 W FREMONT AVE")!=-1)
			school = "District Office";
		else if(text.indexOf("1279 SUNNYVALE SARATOGA RD")!=-1)
			school = "Fremont";
		else if(text.indexOf("1280 JOHNSON AVE UNIT A")!=-1)
			school = "Lynbrook";
		else if(text.indexOf("10100 FINCH AVE, CUPERTINO")!=-1 || text.indexOf("10320 FINCH AVE")!=-1)
			school = "Cupertino";
		else if(text.indexOf("21370 HOMESTEAD RD,")!=-1)
			school = "Homestead";
		else if(text.indexOf("21840 MCCLELLAN")!=-1)
			school = "Monta Vista";
		else 
			System.out.println("NOT FOUND" + "  " + text);

		String time = text.substring(text.indexOf("/")-2, text.lastIndexOf("/")+5).trim();
		System.out.println(time);
		month = Integer.parseInt(time.substring(0,time.indexOf("/")));
		year = Integer.parseInt(time.substring(time.lastIndexOf("/")+1));
		day = Integer.parseInt(time.substring(time.indexOf("/")+1, time.lastIndexOf("/")));
		System.out.println(school + " " + "dy "+day + " yr " + year + " mn " + month);

		totalCharges = Double.parseDouble(text.substring(text.indexOf("$")+1, text.indexOf(" ", text.indexOf("$"))).replace(",",""));
		System.out.println("totalCharges " + totalCharges );

		pgeRev = Double.parseDouble(text.substring(text.lastIndexOf("$")+1).replace(",",""));
		//Date date = new date(day, month, year);


	}
	public String getDate(){
		return month+"/"+day+"/"+year;
	}
	public String toString(){
		return (school+", " + getDate() + ", " + sheet.values[7]+", " + sheet.values[8]);
	}
	
}

class ValueSheet{
	double values[];
	String[] vls;

	public ValueSheet(String line){
		values = new double[15];
		line = line.trim();
		line = line.replace("$","");
		line = line.replace(",","");

		vls = line.split(" ");
		System.out.println(line);
 
 
		for(int a = 0; a<vls.length; a++){
			values[a] = Double.parseDouble(vls[a]);
		}
	}
}
/*
class MonthBill {
	Entry kwh;
	Entry gas;


}
*/
/**


import java.util.Scanner;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
public class FirstTable{
	public static void main(String[] args){
		FirstTable tf = new FirstTable();
		tf.runner();

	}
	public void runner(){
		//getting values form first table
		Scanner box = FileUtils.openToRead("FirstTable.txt");
		Scanner bird = FileUtils.openToRead("SecondTable.txt");
		String text = "";
		ArrayList<Entry> vals = new ArrayList<Entry>();


		while(box.hasNextLine()){
			String line = box.nextLine();
			Entry el = new Entry(line);
			text += "\n"+line;

			String line2 = bird.nextLine();
			ValueSheet vl = new ValueSheet(line2);
			if(Math.abs(vl.values[2]-vl.values[0] - el.totalCharges) < 0.1 || Math.abs(vl.values[2]-vl.values[0] -vl.values[1]- el.totalCharges) < 0.1 
				|| Math.abs(vl.values[2]-vl.values[0] - el.pgeRev) < 0.1 || Math.abs(vl.values[2]-vl.values[0] -vl.values[1]- el.pgeRev) < 0.1 ){
				el.sheet = vl;
				System.out.println("LINKED");
			}
			else System.out.println("NO LINK FOUND");
			vals.add(el);


		}
		createSheets(vals, "Homestead");

		System.out.println(vals.size());
	}
	public void createSheets(ArrayList<Entry> vals, String school){
		String nm = school + ".csv";
		PrintWriter pw = FileUtils.openToWrite(nm);
		pw.println("School, Date, KWH, Therms");

		for(Entry entry : vals){
			if(entry.school.equals(school)){
				try{
					System.out.println(entry +" $" + entry.pgeRev + " $" + entry.sheet.values[2]);
					pw.println(entry);
				}
				catch(Exception e){
					pw.println("Error here -- check again: NO LINK FOUND");
				}
			}
		}
		pw.close();

	}


}

class Entry{
	String school;
	int day;
	int month;
	int year;
	double price;
	int kwh;
	int therm;
	ValueSheet sheet;
	double totalCharges;
	double pgeRev;
	public Entry(String text){
		if(text.indexOf("589 W FREMONT AVE")!=-1)
			school = "District Office";
		else if(text.indexOf("1279 SUNNYVALE SARATOGA RD")!=-1)
			school = "Fremont";
		else if(text.indexOf("1280 JOHNSON AVE UNIT A")!=-1)
			school = "Lynbrook";
		else if(text.indexOf("10100 FINCH AVE, CUPERTINO")!=-1 || text.indexOf("10320 FINCH AVE")!=-1)
			school = "Cupertino";
		else if(text.indexOf("21370 HOMESTEAD RD,")!=-1)
			school = "Homestead";
		else if(text.indexOf("21840 MCCLELLAN")!=-1)
			school = "Monta Vista";
		else 
			System.out.println("NOT FOUND" + "  " + text);

		String time = text.substring(text.indexOf("/")-2, text.lastIndexOf("/")+5).trim();
		System.out.println(time);
		month = Integer.parseInt(time.substring(0,time.indexOf("/")));
		year = Integer.parseInt(time.substring(time.lastIndexOf("/")+1));
		day = Integer.parseInt(time.substring(time.indexOf("/")+1, time.lastIndexOf("/")));
		System.out.println(school + " " + "dy "+day + " yr " + year + " mn " + month);

		totalCharges = Double.parseDouble(text.substring(text.indexOf("$")+1, text.indexOf(" ", text.indexOf("$"))).replace(",",""));
		System.out.println("totalCharges " + totalCharges );

		pgeRev = Double.parseDouble(text.substring(text.lastIndexOf("$")+1).replace(",",""));


	}
	public String getDate(){
		return month+"/"+day+"/"+year;
	}
	public String toString(){
		return (school+", " + getDate() + ", " + sheet.values[7]+", " + sheet.values[8]);
	}
	
}

class ValueSheet{
	double values[];
	String[] vls;

	public ValueSheet(String line){
		values = new double[15];
		line = line.trim();
		line = line.replace("$","");
		line = line.replace(",","");

		vls = line.split(" ");
		System.out.println(line);
 
 
		for(int a = 0; a<vls.length; a++){
			values[a] = Double.parseDouble(vls[a]);
		}
	}
}

class MonthBill {
	Entry kwh;
	Entry gas;


}
*/