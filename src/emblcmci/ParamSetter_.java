package emblcmci;
/** Holds Parameters for AutoThresholdAdjust3D_.class
 *	Dialogue to change default values.  
 */
import ij.gui.GenericDialog;
import ij.plugin.PlugIn;

public class ParamSetter_ implements PlugIn{
	
	private String[] segMethods = { "AutoThreshold", "TrainableSegmentation", "3D_ParticleDetector" };
	
	private static int segMethod = 0;
	
	private static int maxspotvoxels = 300000000;
	
	/**Object volume minimum for volume-based segmentation*/
	private static int minspotvoxels = 3;	
	
	/**object volume minimum for measurement
	 *  (maybe 7 is too small)*/
	private static int minspotvoxels_measure = 7;
	
	/** maximum loop for exiting optimum threshold searching	 */
	private static int maxloops =50;
	
	private static int thadj_volmin = 5;
	
	private static int thadj_volmax = 80;

	private static int thadj_nummin = 1;
	
	private static int thadj_nummax = 4;
	
	public ParamSetter_(){}

	public ParamSetter_(
			int segMethod,
			int maxspotvoxels, 
			int minspotvoxels, 
			int minspotvoxels_measure, 
			int maxloops,
			int thadj_volmin,
			int thadj_volmax,
			int thadj_nummin,
			int thadj_nummax){
		this.setSegMethod(segMethod);
		this.setMaxspotvoxels(maxspotvoxels);
		this.setMinspotvoxels(minspotvoxels);
		this.setMinspotvoxels_measure(minspotvoxels_measure);
		this.setMaxloops(maxloops);
		this.setThadj_volmin(thadj_volmin);
		this.setThadj_volmax(thadj_volmax);
		this.setThadj_nummin(thadj_nummin);
		this.setThadj_nummax(thadj_nummax); 	
	}

	public boolean showDialog()	{
		GenericDialog gd = new GenericDialog("Chromosome Dots Measurement");
		gd.addChoice("Segmentation Method :", segMethods , segMethods[segMethod]);
		gd.addNumericField("Min Spot Size for Segmentation (3Dobject) :", this.getMinspotvoxels(), 0);
		gd.addNumericField("Min Spot Size for measurmeents (3Dobject) :", this.getMinspotvoxels_measure(), 0);
		gd.addNumericField("Max Spot Size for Segmentation (3Dobject) :", this.getMaxspotvoxels(), 0);

		gd.addMessage("------ Adjustment Loop ------");
		
		gd.addNumericField("Min Volume Sum for Segmentation :", this.getThadj_volmin(), 0);
		gd.addNumericField("Max Volume Sum for Segmentation :", this.getThadj_volmax(), 0);
		gd.addNumericField("Min Object Number for Segmentation :", this.getThadj_nummin(), 0);
		gd.addNumericField("Max Object Number for Segmentation :", this.getThadj_nummax(), 0);
		
		gd.addMessage("------ Advanced Options ------");
		gd.addNumericField("Maximum Loop exit for threshold adjustment :", this.getMaxloops(), 0);
		
		gd.showDialog();
		if (gd.wasCanceled()) 
			return false;
		this.setSegMethod(gd.getNextChoiceIndex());
		this.setMinspotvoxels((int) gd.getNextNumber());
		this.setMinspotvoxels_measure((int) gd.getNextNumber());
		this.setMaxspotvoxels((int) gd.getNextNumber());	

		this.setThadj_volmin((int) gd.getNextNumber());
		this.setThadj_volmax((int) gd.getNextNumber());
		this.setThadj_nummin((int) gd.getNextNumber());
		this.setThadj_nummax((int) gd.getNextNumber());

		this.setMaxloops((int) gd.getNextNumber());
		return true;
	}
	public void run(String arg) {
		ParamSetter_ para = new ParamSetter_();
		para.showDialog();
	}
	/**
	 * @param segMethod the segMethod to set
	 */
	public void setSegMethod(int segMethod) {
		this.segMethod = segMethod;
	}

	/**
	 * @return the segMethod
	 */
	public int getSegMethod() {
		return segMethod;
	}
	
	/**
	 * @param maxspotvoxels the maxspotvoxels to set
	 */
	public void setMaxspotvoxels(int maxspotvoxels) {
		this.maxspotvoxels = maxspotvoxels;
	}

	/**
	 * @return the maxspotvoxels
	 */
	public int getMaxspotvoxels() {
		return maxspotvoxels;
	}

	/**
	 * @param minspotvoxels the minspotvoxels to set
	 */
	public void setMinspotvoxels(int minspotvoxels) {
		this.minspotvoxels = minspotvoxels;
	}

	/**
	 * @return the minspotvoxels
	 */
	public int getMinspotvoxels() {
		return minspotvoxels;
	}

	/**
	 * @param minspotvoxels_measure the minspotvoxels_measure to set
	 */
	public void setMinspotvoxels_measure(int minspotvoxels_measure) {
		this.minspotvoxels_measure = minspotvoxels_measure;
	}

	/**
	 * @return the minspotvoxels_measure
	 */
	public int getMinspotvoxels_measure() {
		return minspotvoxels_measure;
	}

	/**
	 * @param maxloops the maxloops to set
	 */
	public void setMaxloops(int maxloops) {
		this.maxloops = maxloops;
	}

	/**
	 * @return the maxloops
	 */
	public int getMaxloops() {
		return maxloops;
	}

	/**
	 * @param thadj_volmin the thadj_volmin to set
	 */
	public static void setThadj_volmin(int thadj_volmin) {
		ParamSetter_.thadj_volmin = thadj_volmin;
	}

	/**
	 * @return the thadj_volmin
	 */
	public static int getThadj_volmin() {
		return thadj_volmin;
	}

	/**
	 * @param thadj_volmax the thadj_volmax to set
	 */
	public static void setThadj_volmax(int thadj_volmax) {
		ParamSetter_.thadj_volmax = thadj_volmax;
	}

	/**
	 * @return the thadj_volmax
	 */
	public static int getThadj_volmax() {
		return thadj_volmax;
	}

	/**
	 * @param thadj_nummin the thadj_nummin to set
	 */
	public static void setThadj_nummin(int thadj_nummin) {
		ParamSetter_.thadj_nummin = thadj_nummin;
	}

	/**
	 * @return the thadj_nummin
	 */
	public static int getThadj_nummin() {
		return thadj_nummin;
	}

	/**
	 * @param thadj_nummax the thadj_nummax to set
	 */
	public static void setThadj_nummax(int thadj_nummax) {
		ParamSetter_.thadj_nummax = thadj_nummax;
	}

	/**
	 * @return the thadj_nummax
	 */
	public static int getThadj_nummax() {
		return thadj_nummax;
	}
}
