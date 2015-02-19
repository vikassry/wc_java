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
	public void getWordCount_gives_number_of_words_lines_bytes_in_string(){
		String input[] = {"one.txt"};
		Wc wc = new Wc(input);
		String result = wc.getWordCount();
		assertEquals(result, "\t2\t10\t49 one.txt");
	}
	@Test
	public void getTextFromFile_reads_the_content_of_file(){
		MyReader r = new MyReader();
		String text = r.getTextFromFile("one.txt");
		assertEquals(text, "hello, this is a good day.\r\nWhat do you think?\r\n ");
	}
}