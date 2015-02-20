import java.io.*;

class Counts{
	public static int lines, words, bytes;
	public static String file;
	public Counts(){ }
}


class Counter{
	private String words[];
	private String str;
	private int lines, wordsCount, lineCount;
	
	public Counter(String text){
		this.str = text;
	}

	public int count_words(){
		return(str=="") ? 0 : str.trim().split("[ \n]").length;
	}

	public int count_lines(){
		return str.split("\r\n").length - 1;
	}

	public int count_bytes(){
		return str.length();
	}

}

class MyReader{
	public MyReader(){}

	public String getTextFromFile(String file){
		FileReader fr = null;
		File f = new File(file);
		int len = (int)f.length();
		char [] cbuff = new char[len];

		try{
			fr = new FileReader(file);
		}
		catch(Exception e){
			System.out.println(">>\tFile not found..."+e);
		}
		BufferedReader br = new BufferedReader(fr);
		try{
			br.read(cbuff, 0, len);
		}
		catch(Exception e){
			System.out.println("Reading Errorr.."+e);
		}
		return String.copyValueOf(cbuff);
	}
}

public class Wc{
	private String []in;
	private String file;
	private String option;
	public Wc(String option, String file){
			this.option = option;
			this.file = file;
	}
	
	public Counts getWordCount(){
		MyReader r = new MyReader();
		String text = r.getTextFromFile(file);
		Counter c = new Counter(text);
		Counts result = new Counts();
		switch(option){
			case "-l":  result.lines = c.count_lines();
			case "-w": result.words = c.count_words();
			case "-c": result.bytes = c.count_bytes();
			default :  result.lines=c.count_lines(); result.words=c.count_words(); 
					   result.bytes=c.count_bytes(); result.file=file;
		}
		return result;
	}
	
	public static void main(String[] args){
		Wc wc = new Wc("-l",args[0]);
		System.out.println(wc.getWordCount());
	}
}