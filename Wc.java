import java.io.*;

class Counter{
	String words[];
	String str;
	int lines, wordsCount, lineCount;
	
	public Counter(String text){
		this.str = text;
	}

	public int count_words(){
		String txt = str.trim();
		if(txt=="") return 0;
		lines = txt.split("\r\n").length-1;
		return txt.split(" ").length + lines;
	}

	public int count_lines(){
		if(str=="") return 0;
		return str.split("\r\n").length;
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
			System.out.println("reading Errorr.."+e);
		}
		return String.copyValueOf(cbuff);
	}
}

public class Wc{
	private String file;
	public Wc(String path){
		this.file = path;
	}
	
	public String getWordCount(){
		MyReader r = new MyReader();
		String text = r.getTextFromFile(file);
		Counter c = new Counter(text);
		return "\t"+ c.count_lines() + "\t" + c.count_words() +"\t"+ c.count_bytes()+" " + file;
	}
	
	public static void main(String[] args){
		MyReader r = new MyReader();
		Wc wc = new Wc(args[0]);
		System.out.println(wc.getWordCount());
	}
}