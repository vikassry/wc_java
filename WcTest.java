import org.junit.Test;
import static org.junit.Assert.*;

public class WcTest{

	@Test
	public void count_words_gives_5_for_string_with_5_words(){
		Counter w = new Counter("hii i a m vikas");
		int count = w.count_words();
		assertEquals(5, count);
	}
	@Test
	public void count_words_gives_0_for_empty_string(){
		Counter w = new Counter("");
		int count = w.count_words();
		assertEquals(0, count);
	}
	@Test
	public void count_words_gives_1_for_one_string(){
		Counter w = new Counter("hiii");
		int count = w.count_words();
		assertEquals(1, count);
	}
	@Test
	public void count_words_gives_4_for_string_with_newLine_words(){
		Counter w = new Counter(" hiii\r\ni m vikas ");
		int count = w.count_words();
		assertEquals(4, count);
	}
	@Test
	public void count_lines_gives_number_of_line(){
		Counter w = new Counter("abcd \r\n wow");
		int count = w.count_lines();
		assertEquals(count, 1);
	}
	@Test
	public void count_bytes_gives_number_of_bytes(){
		Counter w = new Counter("abcd \r\n wow");
		int count = w.count_bytes();
		assertEquals(count, 11);
	}

	@Test
	public void getTextFromFile_reads_the_content_of_file(){
		String content = "hello, this is a good day.\r\nWhat do you think?\r\n"+
						"I don't think so, because it rained heavily last night\r\nOhh! ";
		MyReader r = new MyReader();
		String text = r.getTextFromFile("one.txt");
		assertEquals(text, content);
	}
	
	@Test
	public void getWordCount_gives_number_of_lines_in_given_file_for_l_option(){
		Wc wc = new Wc("-l","one.txt");
		Counts result = wc.getWordCount();
		assertEquals(result.lines, 3);
		assertEquals(result.words, 0);
		assertEquals(result.bytes, 0);
		assertEquals(result.file, "one.txt");
	}
	
	@Test
	public void getWordCount_gives_number_of_words_in_given_file_for_w_option(){
		Wc wc = new Wc("-w","one.txt");
		Counts result = wc.getWordCount();
		assertEquals(result.words, 21);
	}

	@Test
	public void getWordCount_gives_number_of_bytes_in_given_file_for_c_option(){
		Wc wc = new Wc("-c","one.txt");
		Counts result = wc.getWordCount();
		assertEquals(result.bytes, 109);
	}

	@Test
	public void getLongestLine_gives_longest_line_length(){
		Counter c = new Counter("hello, this is a good day.\r\nWhat do you think?\r\n");
		assertEquals(c.getLongestLine(), 26);
	}

	@Test
	public void getShortestLine_gives_longest_line_length(){
		Counter c = new Counter("hello, this is a good day.\r\nWhat do you think?\r\n ");
		assertEquals(c.getShortestLine(), 1);
	}
}