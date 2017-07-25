package com.d2d.client.helper;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.d2d.service.util.FolderUtil;

public class ImageUploadHelper {

	public void createImage(InputStream inputStream, String path, String fileName){
		try {			
			BufferedImage originalImage = ImageIO.read(inputStream);
			if(originalImage != null){
				FolderUtil.createFolders(path);
				//int imgWidth = originalImage.getWidth() - ((originalImage.getWidth() * 20)/100) ;
				//int imgHeight = originalImage.getHeight() - ((originalImage.getHeight() * 20)/100) ;
				int imgWidth = 540;
				int imgHeight = 270;
				BufferedImage resizedImage = resizeImage(originalImage, imgWidth, imgHeight);
				ImageIO.write(resizedImage, "jpg", new File(path + fileName));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void createThumbImage(InputStream inputStream, String path, String fileName){
		try {			
			BufferedImage originalImage = ImageIO.read(inputStream);
			if(originalImage != null){
				//FolderUtil.createFolders(path);
				//int imgWidth = originalImage.getWidth() - ((originalImage.getWidth() * 40)/100);
				//int imgHeight = originalImage.getHeight() - ((originalImage.getHeight() * 40)/100);
				int imgWidth = 300;
				int imgHeight = 220;

				
				BufferedImage resizedImage = resizeImage(originalImage, imgWidth, imgHeight);
				ImageIO.write(resizedImage, "jpg", new File(path + fileName));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	private static BufferedImage resizeImage(BufferedImage originalImage, int width, int height){		   
		BufferedImage dimg = new BufferedImage(width, height, originalImage.getType());  
		Graphics2D graphics2d = dimg.createGraphics();  
		graphics2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		graphics2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		graphics2d.drawImage(originalImage, 0, 0, width, height, 0, 0, originalImage.getWidth(), originalImage.getHeight(), null);  
		graphics2d.dispose();  
		return dimg;  
	}
}
