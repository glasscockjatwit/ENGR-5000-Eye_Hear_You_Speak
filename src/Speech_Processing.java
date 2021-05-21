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
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.AudioInputStream;
import java.io.*;


/*
 * Will include a main in this file 
 */
public class Speech_Processing{
	BandPassFilter filter;
	File audioFile;
	AudioInputStream audioStream;
	LinkedList d_vectors = new LinkedList(); //could create a linked list of d vector objects
	private double windowDelta;
	private int windowAmount;
	private int dVectorsTotal;
	private int trainedSpeakers;
	private static int embeddingLength;
	private static double windowSize; // in seconds
	private static double windowOverlap; //in seconds
	String speakerNames[] = {null}; //might check to see if an array is a good tool for this or not
	
	//constructor
	Speech_Processing(File input){
		this.audioFile = input;
		dVectorsTotal = 0;
		trainedSpeakers = 0;
		embeddingLength = 128;
		windowSize = 1;
		windowOverlap = 0.5;
		
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
		} catch (IOException e) {
			
		}
		catch(UnsupportedAudioFileException f) {
			
		}
	}
	
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
			//to resample, just reset the sample rate of the audio possibly by using a factor
			//possibly create new audio stream or audio handling file
			//audioStream = resampleAudio(audioStream, audio, fs, 16000);
			fs = 16000;
		}
		
		//normalize audio
		//data = obj.bandpass_filter.filter(audio);
			
	}
	private void resampleAudio(AudioInputStream originalFormat, int currentFS, int newFS) {
		//TODO: Implement this method, based on resample information from method call in preprocessing method
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
		windowAmount = (int) audioStream.getFrameLength() / (int) windowDelta;//floor in Java goes towards positive inf and Matlab goes towards negative inf
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
		if(audioStream.getFrameLength() < windowSize) {
			//TODO: debug the audio length
		}
		
		
		
		
		
		return windows;
	}
	//public <T> void getEmbeddings(<T> obj, <T> audio, int fs) {//update the parameters
		//TODO: implement and debug
		//Convert window size and overlap to sample domain
		//int[] windows = makeAudioWindows(obj, audio, fs);
	
		//if the window is empty, return nothing
		//if(windows.isEmpty()) {
			//return null;
		//}
		
		//grab embeddings for each window
		//set the embeddings to zero to start with
		//int embeddings[windows.length][128]; 
		//for(int emb = 1; emb < windows.length; i++) {
			//for(int i = 0; i < 128; i++) {
				//embeddings[emb][j] = vggishFeatures();//update parameters
			//}
		//}
	//}
	
	//returns the processed speech array for the data attributed to each speaker
	int getSpeechSpeakerIndices( int fs, int windows[],Speaker speakers) {
		//TODO: implement and debug
		int index = 0;
		//Convert window size and over
		double window_size_samples = this.windowSize * fs;
		double window_overlap_samples = this.windowOverlap * fs;
		double window_delta_samples = window_size_samples - window_overlap_samples;
		
		return index;
		
	}
	
	
	/*
	 * Main method to do the work of the audio processing
	 */
	public static void main() {
		File audioFile = new File("D:\\John\\Memorex USB\\College\\Academics\\Fourth Year\\Senior Design\\Coding\\Java Implementation\\Diarization\\GodOnlyKnows.wav");
		
		//Testing the creation of the AudioInput Stream
		Speech_Processing test =  new Speech_Processing(audioFile);
		System.out.println("");
	}
}
//d vector is a struct, [128, n]
//row of strings, can use a linked list for it
//