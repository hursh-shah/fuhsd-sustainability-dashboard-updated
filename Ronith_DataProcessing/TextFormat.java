import java.util.Scanner;
import java.io.PrintWriter;
/**
 * 	Formats the code, and ensures there aren't any abnormal number of spaces/lines.
 * 	Then prints out a proper copy, which is cleaned.
 * 
 * @author 	Ronith Vinod Chikkaballapur
 * 			ronith.cv@gmail.com
 * @since 	June 25th, 2024.
 */

public class TextFormat{
	public static void main(String[] args){
	TextFormat tf = new TextFormat();
	tf.runner();

	}
	public void runner(){

		Scanner box = FileUtils.openToRead("SecondTable copy.txt");

		String text = "";
		int num = 0;
		PrintWriter pw = FileUtils.openToWrite("SecondTable.txt");

		while(box.hasNext()){
			text += " "+box.next();
			num++;

			if(num==15){
				num = 0;
				pw.println(text);
				txt.replace("\n", "");
				txt.replace("-", "");
				txt.replace("&", "");
				text = "";
			}
		}
		pw.close();



		/*
		int counter = 0;
		int lastNum = 0;
		for(int a = 0; a<text.length();a++){
			if(text.charAt(a)=='$' /*|| (a<text.length()-2&&text.substring(a,a+2).equals("-$")))
				counter++;
			if(counter%3==1 && counter!=lastNum){
				formatted+=""+'\n';
				lastNum = counter;
			}
			formatted+=text.charAt(a);

		}
		System.out.println(formatted);
		PrintWriter pw = FileUtils.openToWrite("Formatted.txt");
		pw.print(formatted);
		pw.close();*/

	}
}