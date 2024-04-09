package Domain;

import java.util.Scanner;

/**
 *
 * @author vuxua
 */
public class HocSinhDuThi extends HocSinh{
    private String chuyen;
    private float diemMon1, diemMon2, diemMon3;
    private float tongDiem;
    private String ketQua;

    public HocSinhDuThi(String chuyen, float diemMon1, float diemMon2, float diemMon3, float tongDiem, String ketQua, String maHS, String hoTen, String diaChi, String gioiTinh) {
        super(maHS, hoTen, diaChi, gioiTinh);
        this.chuyen = chuyen;
        this.diemMon1 = diemMon1;
        this.diemMon2 = diemMon2;
        this.diemMon3 = diemMon3;
        this.tongDiem = tongDiem;
        this.ketQua = ketQua;
    }
    
    public HocSinhDuThi(){}

    public String getChuyen() {
        return chuyen;
    }

    public void setChuyen(String chuyen) {
        this.chuyen = chuyen;
    }

    public float getDiemMon1() {
        return diemMon1;
    }

    public void setDiemMon1(float diemMon1) {
        this.diemMon1 = diemMon1;
    }

    public float getDiemMon2() {
        return diemMon2;
    }

    public void setDiemMon2(float diemMon2) {
        this.diemMon2 = diemMon2;
    }

    public float getDiemMon3() {
        return diemMon3;
    }

    public void setDiemMon3(float diemMon3) {
        this.diemMon3 = diemMon3;
    }

    public float getTongDiem() {
        return tongDiem;
    }

    public void setTongDiem(float tongDiem) {
        this.tongDiem = tongDiem;
    }

    public String getKetQua() {
        return ketQua;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }
    
    public float tinhTong(){
        return diemMon1 * 2 + diemMon2 + diemMon3;
    }
    
    public String tinhKetQua(){
        if(chuyen.equals("Toán") && tongDiem >= 32)
            return "Đỗ";
        else if(chuyen.equals("Ly") && tongDiem >= 28)
            return "Đỗ";
        else if(chuyen.equals("Tin") && tongDiem >= 24)
            return "Đỗ";
        else if(tongDiem > 20)
            return "Đỗ";
        else
            return "Trượt";
    }
    
    public void nhapThongTinHocSinhDuThi(){
        super.nhapThongTin();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nhập chuyên");
        this.chuyen = sc.nextLine();
        
        System.out.println("Nhập điểm môn 1");
        this.diemMon1 = sc.nextFloat();
        
        System.out.println("Nhập điểm môn 2");
        this.diemMon2 = sc.nextFloat();
        
        System.out.println("Nhập điểm môn 3");
        this.diemMon3 = sc.nextFloat();
        
        tongDiem = tinhTong();
        ketQua = tinhKetQua();
    }
    
    public void hienThiHocSinhDuThi(){
        super.hienThiHocSinh();
        System.out.printf("|%10s|%7s|%7s|%7s|%6s|%9s|%n", this.chuyen, this.diemMon1, this.diemMon2, this.diemMon3, this.tongDiem, this.ketQua);
        System.out.print("+---------------+---------------+-----------+---------------+----------+-------+-------+-------+------+---------+\n");
    }
}
