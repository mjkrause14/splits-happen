import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ScoringTest {
	Scoring score;
	String perfectLine;
	String missLine;
	String spareLine;
	String finalLine;
	
	@Before
	public void setUp() throws Exception {
		perfectLine = "XXXXXXXXXXXX";
		missLine = "9-9-9-9-9-9-9-9-9-9-";
		spareLine = "5/5/5/5/5/5/5/5/5/5/5";
		finalLine = "X7/9-X-88/-6XXX81";
	}

	@Test
	public void testPerfectGame() {
		char[] perfect = perfectLine.toCharArray();
		score = new Scoring(perfect);
		
        for(int i = 0; i < perfect.length; i++) {
            score.getScoreVal(perfect[i], i);
        }
        
		assertEquals(300, score.getScore());
	}
	
	@Test
	public void testMissGame() {
		char[] miss = missLine.toCharArray();
		score = new Scoring(miss);
		
        for(int i = 0; i < miss.length; i++) {
            score.getScoreVal(miss[i], i);
        }
        
		assertEquals(90, score.getScore());
	}
	
	@Test
	public void testSpareLine() {
		char[] spare = spareLine.toCharArray();
		score = new Scoring(spare);
		
        for(int i = 0; i < spare.length; i++) {
            score.getScoreVal(spare[i], i);
        }
        
		assertEquals(150, score.getScore());
	}
	
	@Test
	public void testFinalLine() {
		char[] line = finalLine.toCharArray();
		score = new Scoring(line);
		
        for(int i = 0; i < line.length; i++) {
            score.getScoreVal(line[i], i);
        }
        
		assertEquals(167, score.getScore());
	}

}
