package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Sinhvien
 *
 */
@Entity

public class Sinhvien implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String masv;
	private String hoten;
	private String gioitinh;
	private String sodienthoai;
	private String diachi;

	public Sinhvien() {
		super();
	}

	public Sinhvien(String masv, String hoten, String gioitinh, String sodienthoai, String diachi) {
		super();
		this.masv = masv;
		this.hoten = hoten;
		this.gioitinh = gioitinh;
		this.sodienthoai = sodienthoai;
		this.diachi = diachi;
	}

	public String getMasv() {
		return masv;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	@Override
	public String toString() {
		return "Sinhvien [masv=" + masv + ", hoten=" + hoten + ", gioitinh=" + gioitinh + ", sodienthoai=" + sodienthoai
				+ ", diachi=" + diachi + "]";
	}
	
	
   
}
