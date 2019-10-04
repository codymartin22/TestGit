/**
 * 
 * @author LêMindTú - 43.01.104.194
 *
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class Bai2 {
	static void addName(ArrayList<String> Name) {
		String N;
		System.out.print("Nhập họ và tên (nhập No để dừng): ");
		Scanner sc = new Scanner(System.in);
		N = sc.nextLine();
		if (!N.equals("No")) {
			Name.add(N);
			addName(Name);
		}
		else {
			System.out.println("Đã dừng!");
			ListDo(Name);
		}
	}
	static void output(ArrayList<String> Name) {
		if (Name.size() == 0) {
			System.out.print("Danh sách trống vui lòng nhập danh sách trước khi xuất!");
		}
		else System.out.println(Name);
		ListDo(Name);
	}
	static void SapXep(ArrayList<String> Name) {
		 Collections.sort(Name);
		 Collections.reverse(Name);
		 System.out.println("Danh sách sau khi sắp xếp: ");
		 output(Name);
		 ListDo(Name);
	}
	static void NgauNhien(ArrayList<String> Name) {
		 System.out.println("Danh sách sau khi sắp xếp: ");
		 Collections.shuffle(Name);
		 output(Name);
		 ListDo(Name);
	}
	static int Find(ArrayList<String> Name) {
		int index=-1;
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên muốn tìm: ");
		String NamePer = sc.nextLine();
		int check = 0;
		for (int i=0;i<Name.size();i++) {
			String target = Name.get(i);
			if (target.equals(NamePer)) {
				index = i;
				check = 1;
			}
			else check = 0;
		}
		return index;
	}
	static void Delete(ArrayList<String> Name) {
		Scanner sc = new Scanner(System.in);
		int check = Find(Name);
		if (check == -1 ) {
			System.out.println("Không tìm thấy đối tượng vừa nhập!");
			System.out.print("Bạn có muốn xóa tiếp (Y/N): ");
			String a;
			a = sc.nextLine();
			if (!a.equals("N")) {
				Delete(Name);
			}
		}
		else {
			Name.remove(check);
			System.out.println("Đã xóa đối tượng! Danh sách sau khi xóa là: ");
			output(Name);
		}
		ListDo(Name);
	}
	static void ListCheck(ArrayList<String> Name) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Chọn chức năng: ");
		int a = sc.nextInt();
		switch (a){
		case 1:
			addName(Name);
			break;
		case 2:
			output(Name);
			break;
		case 3:
			SapXep(Name);
			break;
		case 4:
			NgauNhien(Name);
			break;
		case 5:
			Delete(Name);
			break;
		case 6:
			System.out.print("Đã thoát!");
			System.exit(1);
			break;
		default:
			System.out.println("Không có trong danh sách vui lòng nhập lại!");
			ListCheck(Name);
		}	
	}
	static void ListDo(ArrayList<String> Name){
		Scanner sc = new Scanner(System.in);
		System.out.println("+----------------------------------+");
		System.out.println("+ 1. Nhập ArrayList.---------------+");
		System.out.println("+ 2. Xuất ArrayList.---------------+");
		System.out.println("+ 3. Sắp xếp ArrayList.------------+");
		System.out.println("+ 4. Xuất Arraylist ngẩu nhiên.----+");
		System.out.println("+ 5. Xóa.--------------------------+");
		System.out.println("+ 6. Kết thúc.---------------------+");
		System.out.println("+----------------------------------+");
		ListCheck(Name);
	}
	public static void main(String[] args) {
		ArrayList<String> Name = new ArrayList<String>();
		ListDo(Name);
	}
}
