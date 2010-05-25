package emblcmci;

import java.util.Vector;

import Utilities.Counter3D;
import Utilities.Object3D;
import ij.*;
import ij.plugin.PlugIn;


public class tryObject3D_ implements PlugIn {

	ImagePlus imp;
	int thr, minSize, maxSize, dotSize, fontSize;
	boolean excludeOnEdges, showObj, showSurf, showCentro, showCOM, showNb, whiteNb, newRT, showStat, showMaskedImg, closeImg, showSummary, redirect;
	Vector<Object4D> obj4D;
	
	public void run(String arg) {
		 imp = ij.WindowManager.getCurrentImage();
		 thr = 128;
		 minSize = 3;
		 maxSize = 1000;
		 excludeOnEdges = false;
		 redirect = false;
		 Counter3D OC=new Counter3D(imp, thr, minSize, maxSize, excludeOnEdges, redirect);
		 newRT = true;
		 OC.showStatistics(newRT);
		//IJ.showMessage("test3D_Plugin","Hello world 3!");
		 obj4D=new Vector<Object4D>();
		 
	}
}
