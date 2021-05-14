/*
 * John Glasscock
 * Senior Design Project - Eye Hear You Speak
 * Spring and Summer 2021
 * Wentworth Institute of Technology
 */

/*
 * Band pass filter class to be used 
 * for speech processing by the speech processing
 * file. 
 */
public class BandPassFilter {
	//create just the no arg constructor for now, don't know if
	//a constructor with arguments will be needed.
	private double firstStopFreq;
	private double firstPassFreq;
	private double secondPassFreq;
	private double secondStopFreq;
	private double firstStopAtten; //in dB
	private double passRipple; //in dB;
	private double secondStopAtten; //in dB
	private double sampleRate;
	
	
	public BandPassFilter() {
		//set default values based on Matlab documentation
		firstStopFreq = 0.35;
		firstPassFreq = 0.45;
		secondPassFreq = 0.55;
		secondStopFreq = 0.65;
		firstStopAtten = 60;
		passRipple = 1;
		secondStopAtten = 60;
		//default sample rate based on our previous code
		sampleRate = 16000; 
	}
	//constructor where the values have to be specified
	public BandPassFilter(double infirstStopFreq, double infirstPassFreq, double insecondPassFreq, double insecondStopFreq, 
			double infirstStopAtten, double inpassRipple, double insecondStopAtten) {
		//set the values to the one passed into the function
		firstStopFreq = infirstStopFreq;
		firstPassFreq = infirstPassFreq;
		secondPassFreq = insecondPassFreq;
		secondStopFreq = insecondStopFreq;
		firstStopAtten = infirstStopAtten;
		passRipple = inpassRipple;
		secondStopAtten = insecondStopAtten;
		//use default sample rate for now
		sampleRate = 16000;
	}
	public void FilterAudio() {//void for now, once I learn what files will be passed in this will be updated
		
	}
}
