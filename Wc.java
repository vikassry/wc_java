import java.io.*;

class Counts{
	public int lines, words, bytes, longLine, shortLine;
	public String file, longest, shortest;
	
	public Counts(){ }

	public String toString(){
		return "\t"+lines+"\t"+words+"\t"+bytes+"\t"+longLine+"\t"+shortLine+" "+file;
	}
}



class Counter{
	private String words[];
	private String str, shortest, longest;
	
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

	public int getLongestLine(){
		String []lines = str.split("\r\n");
		String str="";
		for (int i=0;i<lines.length;i++) {
			str = (str.length() > lines[i].length()) ? str : lines[i];
		}
		this.longest = str;
		return str.length();
	}
	
	public int getShortestLine(){
		String []lines = str.split("\r\n");
		String str = lines[0];
		for (int i=0;i<lines.length;i++) {
			str = (str.length() < lines[i].length()) ? str : lines[i];
		}
		this.shortest = str;
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
			case "-l": result.lines = c.count_lines(); result.file=file; break;
			case "-w": result.words = c.count_words(); result.file=file; break;
			case "-c": result.bytes = c.count_bytes(); result.file=file; break;
			case "-L": result.longLine = c.getLongestLine(); result.file=file; break;
			case "-S": result.shortLine = c.getShortestLine(); result.file=file; break;
			default :  result.lines=c.count_lines(); result.words=c.count_words(); 
						result.bytes=c.count_bytes(); result.file=file; break;
		}
		return result;
	}
	
	public static void main(String[] args){
		Wc wc = new Wc(args[0], args[1]);
		System.out.println(wc.getWordCount());
	}
}