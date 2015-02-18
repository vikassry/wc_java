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

public class Wc{
	private String txt;

	public Wc(String text){
		this.txt = text;
	}
	public String getWordCount(){
		Counter c = new Counter(txt);
		return c.count_lines() + " "+ c.count_words() +" "+ c.count_bytes();
	}
}