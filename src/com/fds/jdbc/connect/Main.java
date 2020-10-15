package com.fds.jdbc.connect;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.ResultSet;
import com.fds.jsp.servlet.*;

public class Main {
	public final static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.print("Nhập lệnh: ");
		
		List<SinhVien> listSinhVien = new ArrayList<>();
		List<Lop> listLop = new ArrayList<>();
		List<Khoa> listKhoa = new ArrayList<>();
		String sqlSelect = sc.nextLine();
		if(sqlSelect.isEmpty()) {
			System.err.println("Statement cannot be null");
			System.exit(1);
		}
		Connection cn = JDBC.getJBDCconnection();
		Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs =  st.executeQuery(sqlSelect);
		
		
		do {
			System.out.println("Các lệnh: 1- Xem thông tin sinh viên");
			System.out.println("        : 2- Xem thông tin lop");
			System.out.println("        : 3- Xem thông tin khoa");
			System.out.println("        : 4 _ghi file sinh vien ");
			System.out.println("        : 5 _ghi file lop ");
			System.out.println("        : 6 _ghi file khoa ");
			System.out.println("        : 7- thoát");
		System.out.println("chọn: ");
		int key = sc.nextInt();

		switch (key) {
		case 1:

			
			// hiển thị thông tin sinhvien

			while (rs.next()) {
				SinhVien sv2 = new SinhVien();
				sv2.setMaSV(rs.getString("maSV"));
				sv2.setHoTen(rs.getString("hoTen"));
				sv2.setMaLop(rs.getString("maLop"));
				sv2.setSdt(rs.getString("sdt"));
				sv2.setMaKhoa(rs.getString("maKhoa"));
				listSinhVien.add(sv2);
			}

			System.out.println(listSinhVien.size());
			for (SinhVien temp : listSinhVien) {
				System.out.println("Ma SV:  " + temp.getMaSV());
				System.out.println("Ho ten: " + temp.getHoTen());
				System.out.println("Lop:    " + temp.getMaLop());
				System.out.println("SDT:    " + temp.getSdt());
				System.out.println("Khoa:   " + temp.getMaKhoa());
				System.out.println("---------------------------");
			}

			try {
				FileOutputStream fos = new FileOutputStream("D://connectionWithJDBC/data/New Text Document.txt");
				Writer out = new BufferedWriter(new OutputStreamWriter(fos,"UTF-8"));
//				ObjectOutputStream oos = new ObjectOutputStream(fos);
				for(SinhVien temp5 : listSinhVien) {
					out.append("mã SV  :   " + temp5.getMaSV() + "\n");
					out.append("ten SV :   " + temp5.getHoTen() + "\n");
					out.append("lop    :   " + temp5.getMaLop() + "\n");
					out.append("sdt    :   " + temp5.getSdt() + "\n");
					out.append("khoa   :   " + temp5.getMaKhoa() + "\n");
					out.append("----------------------------------------- \n");
				}
				out.flush();
				out.close();
				System.out.println("done");
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			/*
			 * for(int i =0;i<listSinhVien.size();i++) {
			 * System.out.println(listSinhVien.get(i)); }
			 * 
			 * while(((ResultSet) rs).next()) { showInforSinhvien(rs); }
			 * System.out.println("--move to previous row--"); while(((ResultSet)
			 * rs).previous()) { showInforSinhvien(rs); }
			 */

			break;

		case 2:
			/*rs = st.executeQuery(sqlSelect);
			while (((ResultSet) rs).next()) {
				showInforLop(rs);
			}
			System.out.println("--move to previous row--");
			while (((ResultSet) rs).previous()) {
				showInforLop(rs);
			}*/
			
			while(rs.next()) {
				Lop l1 = new Lop();
				l1.setMaLop(rs.getString("maLop"));
				l1.setTenLop(rs.getString("tenLop"));
				listLop.add(l1);
			}
				System.out.println("size list Lop:"+listLop.size());
				for(Lop temp1 : listLop) {
					System.out.println("Ma lop :  " + temp1.getMaLop());
					System.out.println("Ten lop:  " + temp1.getTenLop());
					System.out.println("----------------------");
					
		}
				
			
			
			try {
				FileOutputStream fos = new FileOutputStream("D://connectionWithJDBC/data/New Text Document.txt");
				Writer out = new BufferedWriter(new OutputStreamWriter(fos,"UTF-8"));
//				ObjectOutputStream oos = new ObjectOutputStream(fos);
				for(Lop temp5 : listLop) {
					out.append("mã Lớp  :   " + temp5.getMaLop() + "\n");
					out.append("Tên lớp :   " + temp5.getTenLop() + "\n");
					
					out.append("----------------------------------------- \n");
				}
				out.flush();
				out.close();
				System.out.println("done");
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			break;
		case 3:
			/*rs = st.executeQuery(sqlSelect);
			while (((ResultSet) rs).next()) {
				showInforKhoa(rs);
			}
			System.out.println("--move to previous row--");
			while (((ResultSet) rs).previous()) {
				showInforKhoa(rs);
			}*/
			
			while(rs.next()) {
				Khoa k = new Khoa();
				k.setMaKhoa(rs.getString("maKhoa"));
				k.setTenKhoa(rs.getString("tenKhoa"));
				k.setNamTL(rs.getString("namTL"));
				listKhoa.add(k);
			}
			
			System.out.println("Size in khoa :" + listKhoa.size());
			for(Khoa temp2 : listKhoa) {
				System.out.println("ma Khoa  :" + temp2.getMaKhoa());
				System.out.println("ten Khoa :" + temp2.getTenKhoa());
				System.out.println("nam tl  :" + temp2.getNamTL());
				System.out.println("---------------------");
				
			}
			
			
		
			
			try {
				FileOutputStream fos = new FileOutputStream("D://connectionWithJDBC/data/New Text Document.txt");
				Writer out = new BufferedWriter(new OutputStreamWriter(fos,"UTF-8"));
//				ObjectOutputStream oos = new ObjectOutputStream(fos);
				for(Khoa temp5 : listKhoa) {
					out.append("mã khoa          :   " + temp5.getMaKhoa() + "\n");
					out.append("ten khoa         :   " + temp5.getTenKhoa() + "\n");
					out.append("nam thanh lap    :   " + temp5.getNamTL() + "\n");
					out.append("----------------------------------------- \n");
				}
				out.flush();
				out.close();
				System.out.println("done");
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
			
			break;
			
			
		default:
			System.out.println("thoát");
			break;
		}
		
	}while(false);
		cn.close();
		
		
		
		/// Ghi dữ liệu vào file text !
		
//		try {
//			FileOutputStream fos = new FileOutputStream("D://connectionWithJDBC/data/New Text Document");
//			DataOutputStream dos = new DataOutputStream(fos);
//			ObjectOutputStream oos = new ObjectOutputStream(fos);
//			for(SinhVien temp4 : listSinhVien) {
//				dos.writeUTF("ma SV  :   " + temp4.getMaSV() + "\t");
//				dos.writeUTF("ten SV :   " + temp4.getHoTen() + "\t");
//				dos.writeUTF("lop    :   " + temp4.getMaLop() + "\t");
//				dos.writeUTF("sdt    :   " + temp4.getSdt() + "\t");
//				dos.writeUTF("khoa   :   " + temp4.getMaKhoa() + "\t");
////				oos.writeObject(temp4);
//			}
//			
//			fos.close();
//			dos.close();
//			oos.close();
//			System.out.println("done!");
//		}
//		catch (IOException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}

	/*
	 * private static void Interact() throws SQLException{ Connection cn =
	 * JDBC.getJBDCconnection(); System.out.println("Nhập lệnh truy vấn");
	 * 
	 * Statement st = cn.createStatement(); String sqlInsert = sc.nextLine(); int
	 * numberRowsAffected = st.executeUpdate(sqlInsert);
	 * System.out.println("number of row after inserted" + numberRowsAffected);
	 * 
	 * String sqlUpdate = sc.nextLine(); numberRowsAffected =
	 * st.executeUpdate(sqlUpdate); System.out.println("number of row after updated"
	 * + numberRowsAffected);
	 * 
	 * String sqlDelete = sc.nextLine(); numberRowsAffected =
	 * st.executeUpdate(sqlDelete); System.out.println("number of row after Deleted"
	 * + numberRowsAffected); }
	 */
	private static void showInforLop(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("maLop: " + ((ResultSet) rs).getString(1));
		System.out.println("tenLop: " + ((ResultSet) rs).getString(2));
		System.out.println("-----------------------------------");
	}

	private static void showInforKhoa(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("maKhoa: " + ((ResultSet) rs).getString(1));
		System.out.println("tenKhoa: " + ((ResultSet) rs).getString(2));
		System.out.println("namTL: " + ((ResultSet) rs).getString(3));
		System.out.println("----------------------------------");
	}

	private static void showInforSinhvien(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("maSV: " + ((ResultSet) rs).getString(1));
		System.out.println("tenSV: " + ((ResultSet) rs).getString(2));
		System.out.println("maLop: " + ((ResultSet) rs).getString(3));
		System.out.println("SDT: " + ((ResultSet) rs).getString(4));
		System.out.println("maKhoa: " + ((ResultSet) rs).getString(5));
		System.out.println("------------------------------");

	}
}

