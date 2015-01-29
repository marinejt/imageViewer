package controller;

import java.io.File;
import java.io.IOException;

import controller.ImageFactory;
import model.Image;
import model.ImageBMP;

/**
 * 
 * @author Fran�ois Caron <francois.caron.7@ens.etsmtl.ca>
 */
public class BmpFactory implements ImageFactory {
	
	/** Singleton instance to the BmpFactory */
	private static ImageFactory _instance = null;
	
	/** Hides the constructor from outside the class. */
	private BmpFactory() {};
	
	/*
	 *  (non-Javadoc)
	 * @see controller.ImageFactory#build(java.io.File)
	 */
	public Image build(File file) {
		Image image = null;
			try {
				image =  new ImageBMP(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return image;
	}
	
	/**
	 * Creates a new instance of the BmpFactory class if none exist.
	 * @return The well-known instance of the BmpFactory class.
	 */
	public static ImageFactory getInstance() {
		if(_instance == null)
			_instance = new BmpFactory();
		return _instance;
	}

}
