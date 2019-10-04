/**
 * 
 * @author Lê Mind Tú - 43.01.104.194
 *
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Bai1 {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			ArrayList<Double> Num = new ArrayList<Double>();
			double x=0;
		    while (x!=-1) {
		    	x = sc.nextDouble();
		    	Num.add((double)x);
		    	System.out.print("Nhập tiếp? (-1 để dừng): ");
		    }
		    System.out.println();
		    Num.remove( Num.size()-1);
		    System.out.println("Danh sách các tham số trong ArrayList: " + Num);
		    double kq=0;
		    for (int i = 0;i<Num.size();i++) {
		    	kq += Num.get(i);
		    }
		    System.out.print("Tổng ArrayList: " + kq);
		}
	}
