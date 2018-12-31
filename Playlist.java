package sjsu.Singh.cs146.project1;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

/**
 * This program reads a text file (Playlist.txt) and puts the data into an array.
 * Then, the elements of the array are "shuffled" using the Fisher-Yates Shuffle Algorithm.
 * The shuffled array is then output in another text file (SinghMaanPlaylist.txt).
 * @author Maan Singh
 * @version 1.0
 */
public class Playlist {
	
	/**
	 * The main method that runs the program. It takes input from a given text file and puts it in an array.
	 * It shuffles it then and then outputs it in another file.
	 * @param args
	 */
	public static void main(String[] args) {
		String playlist[] = new String[458]; //initialized empty array where the songs from Playlist.txt are stored.

		try {
			File f = new File("Playlist.txt"); //new file object created that reads from Playlist.txt
			Scanner sc = new Scanner(f); //Scanner object created to "scan" data from the file object
			
			/*
			 * The loop below scans every line in the file Playlist.txt and stores it in the play list array created at the start of the method.
			 * Then, fisherYates static method is run with the array as parameter that shuffles the array.
			 */
			while (sc.hasNext()) {
				for (int i = 0; i<458; i++) {
					String song = sc.nextLine();
					playlist[i] = song;
				}
				fisherYates(playlist);//fisherYates static method. see below.
			}
			sc.close(); //scanner object closed
		} catch (Exception e) { //catches any exception while reading file
			e.printStackTrace(); //prints stack trace for details on the exception
			System.out.println("Error encountered.");
		}
		
		File f1 = new File("SinghMaanPlaylist.txt"); //new file object created that will store the data from the newly shuffled array.
		FileWriter fw; 
		try {
			fw = new FileWriter(f1); //FileWriter object created to write on the file object.
			
			/*
			 * This loop runs through all the elements in the array and then writes it to the file SinghMaanPlaylist.txt using file writer object. 
			 */
			for (int i = 0; i<playlist.length; i++) {
				fw.write(playlist[i] + "\n");
			}
			fw.close(); //file writer object closed
		} catch(Exception e) { //catches any exception while reading file
			e.printStackTrace(); //prints stack trace for details on the exception
			System.out.println("Error encountered.");
		}
	}
	
	/**
	 * This method performs the Fisher-Yates Shuffle Algorithm on a given array that is passed as a parameter.
	 * @param array the array to be shuffled.
	 * @return the shuffled array.
	 */
	public static void fisherYates(String[] array) {
		
		Random myRandGen = new Random(); // Random object created
		myRandGen.setSeed(20);
		
		for (int i = array.length-1; i > 0; i--) { //runs through the array from the last element until the element at index position 0
			int j=myRandGen.nextInt(i); //gets a random number between 0 and n
			String temp = array[i]; //String that stores the value of the element at index i
			array[i] = array[j]; //the element at index i placed at a random spot in the play list
			array[j] = temp; //the element from index i is transferred to the random index and the shuffle is complete finally!
		}
	}
	
}
