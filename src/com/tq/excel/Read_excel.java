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
			// t.xls为要读取的excel文件名
			book = Workbook.getWorkbook(new File("src/com/tq/excel/data.xls"));
			// 获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
			// sheet = book.getSheet(0);
			// 获取左上角的单元格
			// name = sheet.getCell(0, 0);
			// while (true) {
			// 获取每一行的单元格
			for (int j = 0; j < book.getNumberOfSheets() - 1; j++) {
				sheet = book.getSheet(j);
				for (int i = 3; i < sheet.getRows(); i++) {
					name = sheet.getCell(0, i);// （列，行）
					sno = sheet.getCell(3, i);
					card = sheet.getCell(12, i);
					xi = sheet.getCell(5, i);
					if ("".equals(name.getContents()) == true) // 如果读取的数据为空
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
