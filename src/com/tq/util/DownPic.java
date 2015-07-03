package com.tq.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tq.entity.Student;

public class DownPic {
	public static void main(String[] args) throws Exception {
		// ��URL���������ص�����
		int i = 1;
		while (true) {
			Session session = HibernateUtil.getSession();
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
				Student student = (Student) session.get(Student.class, i++);
				if (student != null) {
					String card = student.getCard();
					String pic = "E:\\eclipse word\\crawler\\WebContent\\img\\"
							+ card + ".jpg";
					student.setPic("\\img\\" + card + ".jpg");
					URL url;
					try {
						url = new URL(
								"http://59.51.24.46/hysf/uploadfile/studentphoto/pic/"
										+ card + ".jpg");

						BufferedInputStream bis = new BufferedInputStream(
								url.openStream());
						BufferedOutputStream bos = new BufferedOutputStream(
								new FileOutputStream(pic));
						int s = -1;
						// д�뱾���ļ�
						while ((s = bis.read()) != -1) {
							bos.write(s);
						}
						bos.flush();
						bos.close();
						bis.close();
					} catch (FileNotFoundException e) {
						System.out.println("��һ��Ȼû��");
					}
					if (i % 20 == 0) {
						session.clear();
					}
					System.out.println("���ص�" + i + "��ͼƬ�ɹ�");
				} else {
					break;
				}
				transaction.commit();
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}
	}
}
