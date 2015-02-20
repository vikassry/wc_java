import org.junit.Test;
import static org.junit.Assert.*;

public class WcTest{

	@Test
	public void count_words_gives_5_for_string_with_5_words(){
		Counter w = new Counter("hii i a m vikas");
		assertEquals(5, w.count_words().count);
	}
	@Test
	public void count_words_gives_0_for_empty_string(){
		Counter w = new Counter("");
		assertEquals(0, w.count_words().count);
	}
	@Test
	public void count_words_gives_1_for_one_string(){
		Counter w = new Counter("hiii");
		assertEquals(1, w.count_words().count);
	}
	@Test
	public void count_words_gives_4_for_string_with_newLine_words(){
		Counter w = new Counter(" hiii\r\ni m vikas ");
		assertEquals(4, w.count_words().count);
	}
	@Test
	public void count_lines_gives_number_of_line(){
		Counter w = new Counter("abcd \r\n wow");
		assertEquals(w.count_lines().count, 1);
	}
	@Test
	public void count_bytes_gives_number_of_bytes(){
		Counter w = new Counter("abcd \r\n wow");
		assertEquals(w.count_bytes().count, 11);
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
		Storage result = wc.getWordCount();
		assertEquals(result.count, 3);
		assertEquals(result.words, 0);
		assertEquals(result.bytes, 0);
		assertEquals(result.file, "one.txt");
	}
	
	@Test
	public void getWordCount_gives_number_of_words_in_given_file_for_w_option(){
		Wc wc = new Wc("-w","one.txt");
		Storage result = wc.getWordCount();
		assertEquals(result.count, 21);
	}

	@Test
	public void getWordCount_gives_number_of_bytes_in_given_file_for_c_option(){
		Wc wc = new Wc("-c","one.txt");
		Storage result = wc.getWordCount();
		assertEquals(result.count, 109);
	}

	@Test
	public void getLongestLine_gives_longest_line_length(){
		Counter c = new Counter("hello, this is a good day.\r\nWhat do you think?\r\n");
		assertEquals(c.getLongestLine().count, 26);
		assertEquals(c.getLongestLine().str, " hello, this is a good day.");
	}

	@Test
	public void getShortestLine_gives_longest_line_length(){
		Counter c = new Counter("hello, this is a good day.\r\nWhat do you think?\r\n ");
		assertEquals(c.getShortestLine().count, 1);
		assertEquals(c.getShortestLine().str, "  ");
	}

	@Test
	public void wc_gives_invalid_option_for_wrong_option(){
		Wc wc = new Wc("-t","one.txt");
		Storage result = wc.getWordCount();
		assertEquals(result.count, 0);
		assertEquals(result.str, "Invalid option !!");
		assertEquals(result.file, "");
	}

	@Test
	public void wc_gives_longest_line_with_its_length_for_L_option(){
		Wc wc = new Wc("-L","one.txt");
		Storage result = wc.getWordCount();
		assertEquals(result.count, 54);
		assertEquals(result.str, " I don't think so, because it rained heavily last night");
		assertEquals(result.file, "one.txt");
	}

	@Test
	public void wc_gives_longest_line_with_its_length_for_S_option(){
		Wc wc = new Wc("-S","one.txt");
		Storage result = wc.getWordCount();
		assertEquals(result.count, 5);
		assertEquals(result.str, " Ohh! ");
		assertEquals(result.file, "one.txt");
	}
}