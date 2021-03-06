package com.impetus.elibrary.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.jws.WebService;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebService(endpointInterface = "com.impetus.elibrary.service.UserSOAPService")
public class UserSOAPServiceImpl  extends SpringBeanAutowiringSupport implements UserSOAPService {

	@Autowired
	UserService userService;

	@Autowired
	BookRequestService bookRequestService;

	@Autowired
	SessionFactory sessionFactory;

	private Logger logger = Logger.getLogger(UserSOAPServiceImpl.class.getName());

	@Override
	public @ResponseBody byte[] bookDeliveryToUsers() {

		Session session = sessionFactory.openSession();

		PDDocument doc = null;
		PDPage page = null;
		byte[] bFile = new byte[0];
		String[][] content = { { "Name","Book","Address", "Mobile", "Status" } };
		String fileName="BookDeliverRequest"+System.currentTimeMillis()+".pdf";
		FileInputStream fileInputStream=null;
		 
        try {
			logger.info("Start - generate PDF");
			doc = new PDDocument();
			page = new PDPage();

			doc.addPage(page);
			PDFont font = PDType1Font.HELVETICA_BOLD;
			@SuppressWarnings("unchecked")
			List<Object[]> bookDeliveryList = session
					.createQuery(
							"select a.name as name,b.bookName as book, a.address1 as address, a.mobile as mobile, b.status as status"
							+ " from User a, BookRequest b where a.userId=b.userId "
							+ " and b.status in ('Ready','Request_Return') ")
					.list();

			for (Object[] attr : bookDeliveryList) {
				
				String name = String.valueOf(attr[0]);
				String book = String.valueOf(attr[1]);
				String address = String.valueOf(attr[2]);
				String mobile = String.valueOf(attr[3]);
				String status = String.valueOf(attr[4]);
				
				String[][] data = { { name,book, address, mobile, status } };

				content = append(content, data);
			}

			PDPageContentStream stream = new PDPageContentStream(doc, page);
			stream.beginText();
			stream.setFont(font, 12);
			stream.moveTextPositionByAmount(100, 700);
			stream.drawString("Customer Report");
			stream.endText();
			drawTable(page, stream, 690, 100, content);

			stream.close();
			doc.save(fileName);
			
			
			File file = new File(fileName);
			bFile = new byte[(int) file.length()];
			fileInputStream = new FileInputStream(file);
		    fileInputStream.read(bFile);
		    fileInputStream.close();
	 
		    
		    logger.info("File to Byte Array : Done.");
			
		} catch (Exception e) {
			logger.warning("PdfReport Generation : " + e.getMessage());
		} finally {
			if (session != null) {
				try {
					doc.close();
					session.close();
				} catch (Exception e) {
				}
			}
		}

		return bFile;
	}

	static class BookDeliveryAttributes {
		String name;
		String address1;
		String mobile;
		String status;
	}

	public void drawTable(PDPage page, PDPageContentStream contentStream,
			float y, float margin, String[][] content) throws IOException {
		final int rows = content.length;
		final int cols = content[0].length;
		final float rowHeight = 20f;
		final float tableWidth = page.findMediaBox().getWidth() - (2 * margin);
		final float tableHeight = rowHeight * rows;
		final float colWidth = tableWidth / (float) cols;
		final float cellMargin = 2f;

		// draw the rows
		float nexty = y;
		for (int i = 0; i <= rows; i++) {
			contentStream.drawLine(margin, nexty, margin + tableWidth, nexty);
			nexty -= rowHeight;
		}

		// draw the columns
		float nextx = margin;
		for (int i = 0; i <= cols; i++) {
			contentStream.drawLine(nextx, y, nextx, y - tableHeight);
			nextx += colWidth;
		}

		// now add the text
		contentStream.setFont(PDType1Font.HELVETICA_BOLD, 6);

		float textx = margin + cellMargin;
		float texty = y - 15;
		for (int i = 0; i < content.length; i++) {
			for (int j = 0; j < content[i].length; j++) {
				String text = content[i][j];
				contentStream.beginText();
				contentStream.moveTextPositionByAmount(textx, texty);
				contentStream.drawString(text);
				contentStream.endText();
				textx += colWidth;
			}
			texty -= rowHeight;
			textx = margin + cellMargin;
		}
	}
	
	public static String[][] append(String[][] a, String[][] b) {
		String[][] result = new String[a.length + b.length][];
		System.arraycopy(a, 0, result, 0, a.length);
		System.arraycopy(b, 0, result, a.length, b.length);
		return result;
	}

}
