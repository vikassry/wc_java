import java.io.*;

class Storage{
	public int lines, words, bytes, longLine, shortLine, count;
	public String file, longest, shortest, str="";
	
	public Storage(){ }

	public String toString(){
		return "\t"+ count + str+" "+file;
	}
}


class Counter{
	private String words[];
	private String str, shortest, longest;
	Storage s = new Storage();
	public Counter(String text){
		this.str = text;
	}

	public Storage count_words(){
		s.count = (str=="") ? 0 : str.trim().split("[ \n]").length;
		return s;
	}

	public Storage count_lines(){
		s.count = str.split("\r\n").length - 1;
		return s;
	}

	public Storage count_bytes(){
		s.count = str.length();
		return s;
	}

	public Storage getLongestLine(){
		String []lines = str.split("\r\n");
		String str = lines[0];
		for (int i=0;i<lines.length;i++)
			str = (str.length() > lines[i].length()) ? str : lines[i];
		s.str = " "+ str;
		s.count = str.length();
		return s;
	}
	
	public Storage getShortestLine(){
		String []lines = str.split("\r\n");
		String str = lines[0];
		for (int i=0;i<lines.length;i++) {
			str = (str.length() < lines[i].length()) ? str : lines[i];
		}
		s.str = " "+ str;
		s.count = str.length();
		return s;
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
	private String file;
	private String option;
	public Wc(String option, String file){
			this.option = option;
			this.file = file;
	}
	public Storage getWordCount(){
		MyReader r = new MyReader();
		String text = r.getTextFromFile(file);
		Counter c = new Counter(text);
		Storage result = new Storage();
		switch(option){
			case "-l": result = c.count_lines(); result.file = file; break;
			case "-w": result = c.count_words(); result.file = file; break;
			case "-c": result = c.count_bytes(); result.file = file; break;
			case "-L": result = c.getLongestLine(); result.file = file; break;
			case "-S": result = c.getShortestLine(); result.file = file; break;
			default : result.str = "Invalid option !!"; result.file = ""; break;
		}
		return result;
	}
	
	public static void main(String[] args){
		Wc wc = new Wc(args[0], args[1]);
		System.out.println(wc.getWordCount());
	}
}