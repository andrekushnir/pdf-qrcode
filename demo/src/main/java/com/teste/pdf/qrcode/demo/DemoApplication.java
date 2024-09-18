package com.teste.pdf.qrcode.demo;

import java.io.FileOutputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		teste();
	}

		public static void teste() {
		Document document = new Document();
		try
		{
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("AddImageExample.pdf"));
			document.open();
		
			//Add Image
			Image image1 = Image.getInstance("boleto.jpg");

			//Fixed Positioning
			image1.setAbsolutePosition(0100f, 500f);

			image1.scaleToFit(300f, 500f);

					
			//Add to document
			document.add(image1);
		
			Image image2 = Image.getInstance("qrcode.jpg");
			image2.setAbsolutePosition(0279f, 580f);
			image2.scaleAbsolute(50f, 50f);
			
			document.add(image2);

			document.close();
			writer.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
