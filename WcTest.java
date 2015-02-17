import org.junit.Test;
import static org.junit.Assert.*;

public class WcTest{
	@Test
	public void getWordCount_gives_5_for_string_with_5_words(){
		Wc w = new Wc();
		int count = w.getWordCount("hii i a m vikas");
		assertEquals(5, count);
	}
	@Test
	public void getWordCount_gives_0_for_empty_string(){
		Wc w = new Wc();
		int count = w.getWordCount("");
		assertEquals(0, count);
	}
	@Test
	public void getWordCount_gives_1_for_one_string(){
		Wc w = new Wc();
		int count = w.getWordCount("hiii");
		assertEquals(1, count);
	}
	@Test
	public void getWordCount_gives_4_for_string_with_newLine_words(){
		Wc w = new Wc();
		int count = w.getWordCount(" hiii\r\ni m vikas ");
		assertEquals(4, count);
	}
	@Test
	public void getLineCount_gives_number_of_line(){
		Wc w = new Wc();
		int count = w.getLineCount("abcd \r\n wow");
		assertEquals(count, 2);
	}
	@Test
	public void getBytes_gives_number_of_bytes(){
		Wc w = new Wc();
		int count = w.getBytesCount("abcd \r\n wow");
		assertEquals(count, 11);
	}
}