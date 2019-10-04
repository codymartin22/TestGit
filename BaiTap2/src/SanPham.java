/**
 * 
 * @author LeMinhTu-43.01.104.194
 *
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class SanPham {
	String TenSP;
	int GiaBan;
	static void addSP(ArrayList<SanPham> SP) {
		System.out.println("Sản phẩm thứ " + (SP.size() +1) + ": ");
		SanPham a = new SanPham();
		a = Input();
		if (a.TenSP.equals("No")||a.GiaBan == -1) {
			System.out.println("Đã dừng nhập!");
			ListDo(SP);
		}
		else {
			SP.add(a);
			addSP(SP);
		}
	}
	static void Nhap(ArrayList<SanPham> SP) {
		System.out.println("Nhập thông tin sản phẩm nhập:");
		System.out.println("Nhập Giá là -1 hoặc Tên là No để dừng:");
		addSP(SP);
	}
	static SanPham Input() {
		Scanner sc = new Scanner(System.in);
		SanPham a = new SanPham();
		System.out.print("Tên SP: ");
		int Gia = 0;
		String Ten;
		Ten = sc.nextLine();
		if (Ten.equals("No") || Gia == -1) {
			a.TenSP = "No";
			a.GiaBan = -1;
			return a;
		}
		System.out.print("Giá SP: ");
		Gia = sc.nextInt();
		if (Ten.equals("No")  || Gia == -1) {
			a.TenSP = "No";
			a.GiaBan = -1;
			return a;
		}
		a.TenSP = Ten;
		a.GiaBan = Gia;
		return a;
	}
	static void Xuat(ArrayList<SanPham> SP) {
		if (SP.size()==0) {
			System.out.println("Danh sách rỗng!");
			ListDo(SP);
		}
		else {
			SanPham a = new SanPham();
			int n = SP.size();
			for (int i=0;i<n;i++) {
				a = SP.get(i);
				System.out.println(i+1 +". Sản phẩm "+a.TenSP+" - Giá bán: " + a.GiaBan);
			}
			ListDo(SP);
		}
	}
	static int Find(ArrayList<SanPham> SP,String a) {
		int index = -1;
		for (int i=0;i<SP.size();i++) {
			SanPham sp = new SanPham();
			sp = SP.get(i);
			if (sp.TenSP.equals(a)) {
               index = i;
               break;
			}
		}
		return index;
	}
	static void Delete(ArrayList<SanPham> SP) {
		String a;
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên sản phẩm muốn xóa: ");
		a = sc.nextLine();
		int index = Find(SP,a);
		if (index == -1) {
			System.out.println("Không tìm thấy sản phẩm!");
			ListDo(SP);
		}
		else {
			SP.remove(index);
			System.out.println("Đã xóa Sản Phẩm!");
			ListDo(SP);
		}
	}
	static void giaTB(ArrayList<SanPham> SP) {
		float kq=0;
		SanPham a = new SanPham();
		for (int i=0;i<SP.size();i++) {
			a = SP.get(i);
			kq += a.GiaBan;
		}
		kq = kq/SP.size();
		System.out.println("Giá trung bình Sản Phẩm: " + kq);
		ListDo(SP);
	}
	static void SapXep(ArrayList<SanPham> SP) {
		Comparator<SanPham> comp = new Comparator<SanPham>(){
			@Override
			public int compare(SanPham a,SanPham b) {
				Integer cp1 = a.GiaBan;
				Integer cp2 = b.GiaBan;
				return cp1.compareTo(cp2);
			}
		};
		Collections.sort(SP,comp);
		Collections.reverse(SP);
		Xuat(SP);
	}
	static void ListCheck(ArrayList<SanPham> SP) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Chọn chức năng: ");
		int a = sc.nextInt();
		switch (a){
		case 1:
			Nhap(SP);
			break;
		case 2:
			SapXep(SP);
			break;
		case 3:
			Delete(SP);
			break;
		case 4:
			giaTB(SP);
			break;
		case 5:
			System.out.print("Đã thoát!");
			System.exit(1);
			break;
		default:
			System.out.println("Không có trong danh sách vui lòng nhập lại!");
			ListCheck(SP);
		}	
	}
	static void ListDo(ArrayList<SanPham> SP){
		Scanner sc = new Scanner(System.in);
		System.out.println("+----------------------------------+");
		System.out.println("+ 1. Nhập Sản phẩm.----------------+");
		System.out.println("+ 2. Sắp xếp Danh Sách và Xuất.----+");
		System.out.println("+ 3. Xóa.--------------------------+");
		System.out.println("+ 4. Giá Trung bình sản phẩm.------+");
		System.out.println("+ 5. Kết thúc.---------------------+");
		System.out.println("+----------------------------------+");
		ListCheck(SP);
	}
	public static void main(String[] args) {
		ArrayList<SanPham> SP = new ArrayList<SanPham>();
		ListDo(SP);
	}
	
}
