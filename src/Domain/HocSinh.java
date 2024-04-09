package Domain;

import java.util.Scanner;

public class HocSinh {
    private String maHS, hoTen, gioiTinh, diaChi;

    public HocSinh() {
    }

    public HocSinh(String maHS, String hoTen, String diaChi, String gioiTinh) {
        this.maHS = maHS;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
    }

    public String getMaHS() {
        return maHS;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
    public void nhapThongTin(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nhập mã học sinh");
        this.maHS = sc.nextLine();
        
        System.out.println("Nhập họ tên");
        this.hoTen = sc.nextLine();
        
        System.out.println("Nhập giới tính (nam/nu)");
        this.gioiTinh = sc.nextLine();
        
        System.out.println("Nhập địa chỉ");
        this.diaChi = sc.nextLine();
    }
    
    public void hienThiHocSinh(){
        System.out.printf("|%15s|%15s|%11s|%15s", this.maHS, this.hoTen, this.gioiTinh, this.diaChi);
    }
}
