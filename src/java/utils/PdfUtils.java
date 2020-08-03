/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.SpecialSymbol;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;
import model.QuestionModel;
import model.UserModel;

/**
 *
 * @author pedro
 */
public class PdfUtils {

	public static void Generate(ArrayList<UserModel> users) {
		// criação do documento
		Document document = new Document();
		try {

			PdfWriter.getInstance(document, new FileOutputStream("/Users/pedro/NetBeansProjects/sac/pdf/geradopdf.pdf"));
			document.open();

			// adicionando um parágrafo no documento
			document.add(new Paragraph("Gerando PDF - Java"));
		} catch (DocumentException | IOException de) {
			System.err.println(de.getMessage());
		}
		document.close();
	}

	public static void GenerateUser(ArrayList<UserModel> users) {
		Document document = new Document();
		try {

			PdfWriter.getInstance(document, new FileOutputStream("/Users/pedro/NetBeansProjects/sac/pdf/users.pdf"));
			document.open();

			document.add(new Paragraph("Todos os usuarios do sistema"));
			for (UserModel user : users) {
				document.add(new Paragraph("Id: " + user.getId()));
				document.add(new Paragraph("Email: " + user.getEmail()));
				document.add(new Paragraph("Name: " + user.getName()));
				document.add(new Paragraph("Role: " + user.getRole()));
			}
			document.add(new Paragraph("Gerando PDF - Java"));
		} catch (DocumentException | IOException de) {
			System.err.println(de.getMessage());
		}
		document.close();
	}

	public static void GenerateQuestions(ArrayList<QuestionModel> questions) {
		Document document = new Document();
		try {
			document.add(new Paragraph("Piores produtos"));

			PdfWriter.getInstance(document, new FileOutputStream("/Users/pedro/NetBeansProjects/sac/pdf/questions.pdf"));
			document.open();

			for (QuestionModel question : questions) {
				document.add(new Paragraph("Total: " + question.getQuestion_id()));
				document.add(new Paragraph("Product: " + question.getProduct_id()));
			}
			document.add(new Paragraph("Gerando PDF - Java"));
		} catch (DocumentException | IOException de) {

			System.err.println(de.getMessage());
		}
		document.close();
	}

	public static void GenerateQuestionsAll(ArrayList<QuestionModel> questions) {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("/Users/pedro/NetBeansProjects/sac/pdf/sac.pdf"));
			document.open();
			document.add(new Paragraph("Todos as questoes"));

			for (QuestionModel question : questions) {
				document.add(new Paragraph("Question: " + question.getQuestion_id()));
				document.add(new Paragraph("Product: " + question.getProduct_id()));
				document.add(new Paragraph("Description: " + question.getDescription()));
				document.add(new Paragraph("Solution: " + question.getSolution()));
				document.add(new Paragraph("Type: " + question.getType()));
				document.add(new Paragraph("Active: " + question.getActive()));

			}
			document.add(new Paragraph("Gerando PDF - Java"));
		} catch (DocumentException | IOException de) {

			System.err.println(de.getMessage());
		}
		document.close();
	}
}
