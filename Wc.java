class Wc{
	String words[], str;
	int lines;
	public Wc(){}

	public int getWordCount(String text){
		text = text.trim();
		if(text=="") return 0;
		lines = text.split("\r\n").length-1;
		return text.split(" ").length + lines;
	}
	public int getLineCount(String text){
		if(text=="") return 0;
		return text.split("\r\n").length;
	}
	public int getBytesCount(String text){
		return text.length();
	}
}