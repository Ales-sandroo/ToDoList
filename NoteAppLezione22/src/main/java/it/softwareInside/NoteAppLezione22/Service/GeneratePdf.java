package it.softwareInside.NoteAppLezione22.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@org.springframework.stereotype.Service
public class GeneratePdf {
	@Autowired
	Service service;

	public ByteArrayInputStream generaPDFNota(int id) {

		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			Paragraph contenuto = new Paragraph();

			contenuto.add(service.cercaNota(id).toString());

			PdfWriter.getInstance(document, out);
			document.open();
			document.add(contenuto);
			document.close();

		} catch (DocumentException ex) {

			return null;
		}

		return new ByteArrayInputStream(out.toByteArray());
	}
}