import java.util.Scanner;
import java.io.PrintWriter;
public class TextFormat{
	public static void main(String[] args){
	TextFormat tf = new TextFormat();
	tf.runner();

	}
	public void runner(){

		Scanner box = FileUtils.openToRead("Doc2.txt");
		String text = "";
		while(box.hasNextLine()){
			text += " "+box.nextLine();
		}
		System.out.println(text);

		String formatted = "";
		int counter = 0;
		int lastNum = 0;
		for(int a = 0; a<text.length();a++){
			if(text.charAt(a)=='$' /*|| (a<text.length()-2&&text.substring(a,a+2).equals("-$"))*/)
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
		pw.close();

	}
}