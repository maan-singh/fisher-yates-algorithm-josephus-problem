package sjsu.Singh.cs146.project1;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlaylistTest {
	String expectedLine;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMain() {
		try {
		BufferedReader Out=new BufferedReader (new FileReader ("SinghMaanPlaylist.txt"));

		BufferedReader In=new BufferedReader (new FileReader ("folder/Target2.txt")); 
		
		while ((expectedLine = In.readLine ()) != null) {

            String actualLine = Out.readLine ();

            assertEquals (expectedLine, actualLine);

         }
		
		Out.close();
		In.close();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR!");
		}
	}

}
