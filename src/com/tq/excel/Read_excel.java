package com.tq.excel;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import com.tq.entity.Student;
import com.tq.util.HibernateUtil;

public class Read_excel {
	public static void main(String[] args) {
		Sheet sheet;
		Workbook book;
		Cell name, sno, card, xi;
		try {
			// t.xlsΪҪ��ȡ��excel�ļ���
			book = Workbook.getWorkbook(new File("src/com/tq/excel/data.xls"));
			// ��õ�һ�����������(ecxel��sheet�ı�Ŵ�0��ʼ,0,1,2,3,....)
			// sheet = book.getSheet(0);
			// ��ȡ���Ͻǵĵ�Ԫ��
			// name = sheet.getCell(0, 0);
			// while (true) {
			// ��ȡÿһ�еĵ�Ԫ��
			for (int j = 0; j < book.getNumberOfSheets() - 1; j++) {
				sheet = book.getSheet(j);
				for (int i = 3; i < sheet.getRows(); i++) {
					name = sheet.getCell(0, i);// ���У��У�
					sno = sheet.getCell(3, i);
					card = sheet.getCell(12, i);
					xi = sheet.getCell(5, i);
					if ("".equals(name.getContents()) == true) // �����ȡ������Ϊ��
						break;
					Student s = new Student();
					s.setName(name.getContents().trim());
					s.setSno(sno.getContents().trim());
					s.setCard(card.getContents().trim());
					s.setXi(xi.getContents().trim());
					HibernateUtil.add(s);
				}
			}
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
