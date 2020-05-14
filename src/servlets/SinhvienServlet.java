package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SinhvienDAO;
import entity.Sinhvien;

/**
 * Servlet implementation class SinhvienServlet
 */
@WebServlet("/SinhvienServlet")
public class SinhvienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SinhvienDAO sinhvienDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SinhvienServlet() {

    	sinhvienDAO = new SinhvienDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String command = request.getParameter("command");
		if(command == null)
			command = "LIST";
		
		switch (command) {
		case "LIST":
			listSinhvien(request, response);
			break;
		case "ADD":
			addSinhvien(request, response);
			break;
		case "DELETE":
			deleteSinhvien(request, response);
			break;
		case "LOAD":
			loadSinhvien(request, response);
		case "UPDATE":
			updateSinhvien(request, response);
		default:
			break;
		}
		
		
	}

	private void updateSinhvien(HttpServletRequest request, HttpServletResponse response) {
		
	}

	private void loadSinhvien(HttpServletRequest request, HttpServletResponse response) {
	}

	private void deleteSinhvien(HttpServletRequest request, HttpServletResponse response) {
		try {
			String masv = request.getParameter("id");
			Sinhvien sv = sinhvienDAO.getSinhvien(masv);
			boolean kq = sinhvienDAO.deleteSinhvien(sv);
			if(kq)
				response.sendRedirect("SinhvienServlet");
		}catch (Exception e) {
			new ServletException(e);
		}
	}

	private void addSinhvien(HttpServletRequest request, HttpServletResponse response) {
		try {
		String masv = request.getParameter("masv");
		String hoten = request.getParameter("hoten");
		String gioitinh = request.getParameter("gioitinh");
		String phone = request.getParameter("phone");
		String diachi = request.getParameter("diachi");
		
		Sinhvien sv = new Sinhvien(masv, hoten, gioitinh, phone, diachi);
		
		boolean kq = sinhvienDAO.addSinhvien(sv);
		if(kq)
			response.sendRedirect("SinhvienServlet");
		}catch (Exception e) {
			new ServletException(e);
		}
	}

	private void listSinhvien(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Sinhvien> list = sinhvienDAO.getStudents();
			PrintWriter out = response.getWriter();
			out.println("<table border='1' cellspacing='0' cellpadding='10px'><tr><th>masv</th><th>ho ten</th><th>gioitinh</th><th>phone</th><th>dc</th><th>Action</th</tr>");
			for(Sinhvien sv : list) {
				out.println("<tr><td>"+sv.getMasv()+"</td><td>"+sv.getHoten() +"</td><td>" + sv.getGioitinh() +"</td><td>" + 
			sv.getSodienthoai() +"</td><td>" + sv.getDiachi() +
			"</td><td><a href='SinhvienServlet?id="+sv.getMasv()+"&command=DELETE"+"'>Delete</a>"+
			
						"</td></tr>");
			}
			out.println("</table>");
		}catch (Exception e) {
			new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
