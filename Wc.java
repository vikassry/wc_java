import java.io.*;

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
	public Wc(String[] path){
		in = path;
		System.out.println(in[0]);

		if(in.length>1){
			this.option = in[0];
			this.file = in[1];
		}
		else
			this.file = in[0];
	}
	
	public String getWordCount(){
		MyReader r = new MyReader();
		String text = r.getTextFromFile(file);
		Counter c = new Counter(text);
		return "\t"+ c.count_lines() +"\t"+ c.count_words() +"\t"+ c.count_bytes() +" "+ file;
	}
	
	public static void main(String[] args){
		MyReader r = new MyReader();
		Wc wc = new Wc(args);
		System.out.println(wc.getWordCount());
	}
}
