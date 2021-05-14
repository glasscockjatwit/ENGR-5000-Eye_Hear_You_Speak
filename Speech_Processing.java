/*
 * John Glasscock
 * Based on work by Matthew Lima
 * Senior Design Project - Eye Hear You Speak
 * Spring and Summer 2021
 * Wentworth Institute of Technology
 */
import java.lang.*;
import java.util.*;
import javax.sound.*;
import java.io.*;


/*
 * Will include a main in this file 
 */
public class Speech_Processing {
	BandPassFilter filter;
	AudioInputStream audio = new AudioInputStream();
	d_vectors = new LinkedList(); //could create a linked list of d vector objects
	private double windowDelta;
	private int windowAmount;
	private int dVectorsTotal = 0;
	private int trainedSpeakers = 0;
	private static int embeddingLength = 128;
	private static double windowSize = 1; // in seconds
	private static double windowOverlap = 0.5; //in seconds
	String speakerNames[] = {null}; //might check to see if an array is a good tool for this or not
	
	//Now for the methods
	protected double vectorSimilarity(double vector1[], double vector2[]) {
		double similarity =  0;
		double dotProduct = 0;
		
		//find the dot product of the vectors using a for loop
		for(int i = 0; i < vector1.length; i++) {
			dotProduct = dotProduct + vector1[i] * vector2[i];
		}
		
		//norm the vectors and divide dot product by those values
		similarity = dotProduct / (vectorNorm(vector1) * vectorNorm(vector2));
		return similarity;//check if I need the return or not
	}
	
	protected double vectorNorm(double vector[]) {
		//helper method to normalize and return the Euclidean norm of a vector
		//Used in the vectorSimilarity method
		double magnitude = 0;
		for(int i = 0; i < vector.length; i++) {
			magnitude = magnitude + vector[i] * vector[i];
		}
		return magnitude;
	}
	protected void preProcessing(double speechVector[], int speechIndices, int fs) {
		//The purpose of this code is to apply a band pass filter to a specified entry
		//Will return a clipped audio file
		
		//TODO: implement and debug
		//TODO: Figure out audio resample method
		
		
		//create the band pass filter object here
		BandPassFilter filter = new BandPassFilter(); //update when I understand the parameters
		
		//make sure audio is sampled at the correct frequency, and if not,
		//resample it
		if(fs < 16000) {
			//audio = resampleAudio(audioObject, audio, fs, 16000);
			fs = 16000;
		}
		
		//If the audio is not a column vector, reshape it
		//TODO: figure out the 
		if(!(audio.length)) {
			
		}
		
	}
	private void detectSpeech() {
		
	}
	
	public int[] makeAudioWindows(int fs, double windowSize, double windowOverlap) {//check to make sure an int array is appropriate
		//if overlap is set to window length, change it to 0
		if(windowSize <= windowOverlap) {
			windowOverlap = 0;
		}
		
		//convert window size and overlap to sample domain
		windowSize = windowSize * fs;
		windowOverlap = windowOverlap * fs;
		
		//pre-allocate the windows matrix
		windowDelta = windowSize - windowOverlap;
		//issue of length(audio) from the Matlab. Once I know the audio file type I can research documentation
		windowAmount = floor(length(audio) / windowDelta);)//floor in Java goes towards positive inf and Matlab goes towards negative inf
		int[] windows = new int[windowAmount];

		//check to make sure the clip is long enough to break into
		//windows. If not, return an empty array
		if(windowAmount == 0) {
			windows = null;
			return windows;
		}
		//set all the values within the array to zero
		for(int i = 0; i < windows.length; i++) {
			windows[i] = 0;
		}
		//Continue the rest of this later
		if(length(audio) < window_size) {
			//TODO: debug the audio length
		}
	}
	public <T> void getEmbeddings(<T> obj, <T> audio, int fs) {//update the parameters
		//TODO: implement and debug
		//Convert window size and overlap to sample domain
		int[] windows = makeAudioWindows(obj, audio, fs);
	
		//if the window is empty, return nothing
		if(windows.isEmpty()) {
			return null;
		}
		
		//grab embeddings for each window
		//set the embeddings to zero to start with
		int embeddings[windows.length][128]; 
		for(int emb = 1; emb < windows.length; i++) {
			for(int i = 0; i < 128; i++) {
				embeddings[emb][j] = vggishFeatures();//update parameters
			}
		}
	}
	
	//returns the processed speech array for the data attributed to each speaker
	int getSpeechSpeakerIndices( int fs, int windows[],Speaker speakers) {
		//TODO: implement and debug
		//Convert window size and over
		double window_size_samples = this.windowSize * fs;
		double window_overlap_samples = this.windowOverlap * fs;
		double window_delta_samples = window_size_samples - window_overlap_samples;
		
		
	}
	
	
	/*
	 * Main method to do the work of the audio processing
	 */
	public static void main() {
		
		
		
	}
}
//d vector is a struct, [128, n]
//row of strings, can use a linked list for it
//