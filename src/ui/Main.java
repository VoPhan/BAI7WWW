package ui;

import java.util.List;

import dao.SinhvienDAO;
import entity.Sinhvien;

public class Main {
	public static void main(String[] args) throws Exception {
		SinhvienDAO sinhvienDAO = new SinhvienDAO();
		Sinhvien sv = new Sinhvien("12434", "Nguyen Lan", "Nu", ".265665", "q1");
//		sinhvienDAO.addSinhvien(sv);
//		sv = sinhvienDAO.getSinhvien("12434");
//		sv.setSodienthoai("0913555555");
//		sinhvienDAO.deleteSinhvien(sv);
		
		List<Sinhvien> list = sinhvienDAO.getStudents();
		System.out.println(list);
	}
}
