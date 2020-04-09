package com.xdong.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Paragraph p1 = new Paragraph("Report Created on " +  new java.util.Date());
		Paragraph p2 = new Paragraph("Customer "+ model.get("customer"));
		document.add(p1);
		document.add(p2);
		document.close();
		//if use the latest version, we should implement the pdf view by ourselves.
		
	}

}
