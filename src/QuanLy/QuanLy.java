package QuanLy;

import Domain.HocSinhDuThi;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vuxua
 */
public class QuanLy {
    private ArrayList<HocSinhDuThi> danhSach;
    
    public QuanLy(ArrayList<HocSinhDuThi> danhSach){
        this.danhSach = danhSach;
    }
    
    public QuanLy(){
        this.danhSach = new ArrayList<HocSinhDuThi> ();
    }
    
    public boolean checkListEmpty() {
		return this.danhSach.isEmpty();
    }
    
    public void nhapDanhSach(){
        Scanner sc = new Scanner(System.in);
        int soLuong = 0;
        final int gioiHan = 100;
        char luaChon;
        do {
            if(soLuong >= gioiHan){
                System.out.println("Số lượng học sinh đã đạt tối đa (" + gioiHan + "). Không thể thêm nữa.");
                break;
            }
            
            System.out.println("\tNhập thông tin học sinh thứ " + (soLuong+ 1));
            HocSinhDuThi hs = new HocSinhDuThi();
            hs.nhapThongTinHocSinhDuThi();
            danhSach.add(hs);
            soLuong++;
            
            System.out.println("Bạn có muốn tiếp tục? (Y/N)");
            luaChon = sc.nextLine().charAt(0);
        }while(luaChon != 'N' && luaChon != 'n');
    }
    
    public void hienThiDanhSach(){
        System.out.print("\t\t\t------ KẾT QUẢ XÉT TUYỂN ------\n");
        tieuDe();
        for(HocSinhDuThi hs : danhSach)
            hs.hienThiHocSinhDuThi();
    }
    
    public void timKiemTheoTen(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời nhập tên cần tìm: ");
        String tenCanTim = sc.nextLine();
        int count = 0;
        
        for(HocSinhDuThi hs : danhSach){
            if(hs.getHoTen().equalsIgnoreCase(tenCanTim)){
                hs.hienThiHocSinhDuThi();
                count++;
            }
        }
        if(count == 0)
            System.out.println("Không tìm thấy học sinh có tên \"" + tenCanTim + "\" trong danh sách.");
    }
    
    public static void tieuDe(){
        System.out.print("+---------------+---------------+-----------+---------------+----------+-------+-------+-------+------+---------+\n");
        System.out.print("|  Mã học sinh  |   Họ và tên   | Giới tính |    Địa chỉ    |  Chuyên  | Môn 1 | Môn 2 | Môn 3 | Tổng | Kết quả |\n");
        System.out.print("+---------------+---------------+-----------+---------------+----------+-------+-------+-------+------+---------+\n");
    }
    
    public static void menu(){
        System.out.println("\n\t---- MENU ----");
		System.out.println("\n1. Nhập danh sách học sinh dự thi" 
				+ "\n2. In kết quả dự thi ra màn hình"
				+ "\n3. Tìm kiếm học sinh theo tên"
				+ "\n4. Thoát chương trình"
				);
    }
    
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            QuanLy ql = new QuanLy();
            char luaChon;
            do{
                menu();
                System.out.print("\nLựa chọn của bạn: ");
                do{
                    luaChon = sc.nextLine().charAt(0);
                    if(luaChon < '0' || luaChon > '9')
                        System.out.print("\nLựa chọn không hợp lệ! Mời nhập lại: ");
                }while(luaChon < '0' || luaChon > '9');
                
                switch(luaChon){
                    case '1' -> ql.nhapDanhSach();
                    case '2' -> {
                        if(!ql.checkListEmpty())
                            ql.hienThiDanhSach();   
                        else
                            System.out.println("Chưa có học sinh nào trong danh sách");
                    }
                    case '3' -> {
                        if(!ql.checkListEmpty())
                            ql.timKiemTheoTen();  
                        else
                            System.out.println("Chưa có học sinh nào trong danh sách");
                    }
                    case '4' -> System.out.println("Cảm ơn đã dùng chương trình!"); 
                    default -> System.out.println("Lựa chọn không hợp lệ");
                }
            }while(luaChon != '4');
        }
    }
}
