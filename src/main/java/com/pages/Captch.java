package com.pages;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Captch {

	public static void main(String[] args) {
		
		ITesseract image=new Tesseract();
		try {
			String str=image.doOCR(new File("C:\\Users\\ASIFM\\Pictures\\abc.png"));
			System.out.println(str);
		} catch (TesseractException e) {
			
		System.out.println("Exception "+e.getMessage());
		}
	}
}



/* Tesseract:Tesseract is an optical character recognition engine for various operating systems.
Tess4j: 
Tess4J 

Description:
A Java JNA wrapper for Tesseract OCR API.

Tess4J is released and distributed under the Apache License, v2.0 and is also available from Maven Central Repository.

Features:
The library provides optical character recognition (OCR) support for:

TIFF, JPEG, GIF, PNG, and BMP image formats
Multi-page TIFF images
PDF document format

*/
