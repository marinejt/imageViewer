package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;

import model.Image;

public class ImageBMP extends Image{

<<<<<<< HEAD
	
	public ImageBmp(File file) throws IOException  {
=======
	public ImageBMP(File file) throws IOException  {
>>>>>>> origin/master
		
		FileInputStream fs = null;
		java.awt.Image image;
		try {
			fs = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        int bflen=14; // 14 byte BITMAPFILEHEADER
        byte bf[]=new byte[bflen];
        try {
			fs.read(bf,0,bflen);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int bilen=40; // 40-byte BITMAPINFOHEADER
        byte bi[]=new byte[bilen];
        try {
			fs.read(bi,0,bilen);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Interperet data.
        int nsize = (((int)bf[5]&0xff)<<24)
            | (((int)bf[4]&0xff)<<16)
            | (((int)bf[3]&0xff)<<8)
            | (int)bf[2]&0xff;
        //System.out.println("File type is :"+(char)bf[0]+(char)bf[1]);
        //System.out.println("Size of file is :"+nsize);

        int nbisize = (((int)bi[3]&0xff)<<24)
            | (((int)bi[2]&0xff)<<16)
            | (((int)bi[1]&0xff)<<8)
            | (int)bi[0]&0xff;
        //System.out.println("Size of bitmapinfoheader is :"+nbisize);

        int nwidth = (((int)bi[7]&0xff)<<24)
            | (((int)bi[6]&0xff)<<16)
            | (((int)bi[5]&0xff)<<8)
            | (int)bi[4]&0xff;
        //System.out.println("Width is :"+nwidth);

        int nheight = (((int)bi[11]&0xff)<<24)
            | (((int)bi[10]&0xff)<<16)
            | (((int)bi[9]&0xff)<<8)
            | (int)bi[8]&0xff;
        //System.out.println("Height is :"+nheight);


        int nplanes = (((int)bi[13]&0xff)<<8) | (int)bi[12]&0xff;
        //System.out.println("Planes is :"+nplanes);

        int nbitcount = (((int)bi[15]&0xff)<<8) | (int)bi[14]&0xff;
        //System.out.println("BitCount is :"+nbitcount);

        // Look for non-zero values to indicate compression
        int ncompression = (((int)bi[19])<<24)
            | (((int)bi[18])<<16)
            | (((int)bi[17])<<8)
            | (int)bi[16];
        //System.out.println("Compression is :"+ncompression);

        int nsizeimage = (((int)bi[23]&0xff)<<24)
            | (((int)bi[22]&0xff)<<16)
            | (((int)bi[21]&0xff)<<8)
            | (int)bi[20]&0xff;
        //System.out.println("SizeImage is :"+nsizeimage);

        int nxpm = (((int)bi[27]&0xff)<<24)
            | (((int)bi[26]&0xff)<<16)
            | (((int)bi[25]&0xff)<<8)
            | (int)bi[24]&0xff;
        //System.out.println("X-Pixels per meter is :"+nxpm);

        int nypm = (((int)bi[31]&0xff)<<24)
            | (((int)bi[30]&0xff)<<16)
            | (((int)bi[29]&0xff)<<8)
            | (int)bi[28]&0xff;
        //System.out.println("Y-Pixels per meter is :"+nypm);

        int nclrused = (((int)bi[35]&0xff)<<24)
            | (((int)bi[34]&0xff)<<16)
            | (((int)bi[33]&0xff)<<8)
            | (int)bi[32]&0xff;
        //System.out.println("Colors used are :"+nclrused);

        int nclrimp = (((int)bi[39]&0xff)<<24)
            | (((int)bi[38]&0xff)<<16)
            | (((int)bi[37]&0xff)<<8)
            | (int)bi[36]&0xff;
        //System.out.println("Colors important are :"+nclrimp);
		// TODO Auto-generated constructor stub
        if (nbitcount==24)
        {
            // No Palatte data for 24-bit format but scan lines are
            // padded out to even 4-byte boundaries.
            int npad = (nsizeimage / nheight) - nwidth * 3;
            //added for Bug correction
            if(npad == 4){
                npad=0;
            }
            int ndata[] = new int [nheight * nwidth];
            byte brgb[] = new byte [( nwidth + npad) * 3 * nheight];

            fs.read (brgb, 0, (nwidth + npad) * 3 * nheight);
            int nindex = 0;
            for (int j = 0; j < nheight; j++)
                {
                    for (int i = 0; i < nwidth; i++)
                        {
                            ndata [nwidth * (nheight - j - 1) + i] =

                                (255&0xff)<<24
                                | (((int)brgb[nindex+2]&0xff)<<16)
                                | (((int)brgb[nindex+1]&0xff)<<8)
                                | (int)brgb[nindex]&0xff;
                            nindex += 3;
                        }
                    nindex += npad;
                }

            image = Toolkit.getDefaultToolkit().createImage( new MemoryImageSource (nwidth, nheight,ndata, 0, nwidth));
        }
        
 
	}
	public BufferedImage draw() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHeight() {
		// TODO A
		return 0;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
