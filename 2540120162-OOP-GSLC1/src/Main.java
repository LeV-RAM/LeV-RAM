import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	ArrayList<Siswa> siswa = new ArrayList<>();
	ArrayList<Account> akun = new ArrayList<>();
	
	public Main () {
		int menu;
		do {
			System.out.println("==============================");
			System.out.println("Welcome to BINUS Score Portal");
			System.out.println("==============================");
			System.out.println("1. Guru");
			System.out.println("2. Siswa");
			System.out.println("3. Exit");
			System.out.print("Choose >> ");
			menu = scan.nextInt();
			scan.nextLine();
			System.out.println("");
			switch (menu) {
			case 1:
				String ver;
				System.out.print("Masukkan kode Verifikasi: ");
				ver = scan.nextLine();
				if(ver.equals("MLJ050303")) {
					System.out.println();
					System.out.println("Selamat Anda Berhasil Melakukan Verifikasi Diri Sebagai Guru!");
					menuGuru();
				}else {
					System.out.println("Kode salah!");
				}
				break;
			case 2:
				menuSiswa();
				break;
			case 3:
				System.exit(0);
				break;
			}
			System.out.println("");
		} while (menu != 3);
	}
	
	public void menuSiswa() {
		int menu;
		boolean back = false;
		do {
			System.out.println();
			System.out.println("1. Sign Up [Belum Memiliki Akun]");
			System.out.println("2. Log In [Telah Memiliki Akun]");
			System.out.print("Choose >> ");
			menu = scan.nextInt();
			scan.nextLine();
			switch (menu) {
			case 1:
				signUp();
				break;
			case 2:
				logIn();
				back = true;
				break;
			}
		} while (back == false);
	}

	public void logIn() {
		String email, pass;
		System.out.println();
		System.out.print("Please Input Your Username [ @abc.ac.id ] :");
		email = scan.nextLine();
		System.out.print("Please Input Your Password :");
		pass = scan.nextLine();
		System.out.println();
		
		int res = searchAccount(email, pass);
		if(res == 1) {
			if(siswa.size() == 0) {
				System.out.println("Belum ada nilai!");
				return;
			}
			System.out.println("Successfully Login");
			System.out.println("Please Enter to Continue....");
			scan.nextLine();
			String name;
			String yesno = "";
			do {
				System.out.print("Nama Siswa: ");
				name = scan.nextLine();
				int res2 = searchName(name);
				
				if (res2 >= 0) {
					System.out.println(
							"Nilai :" + siswa.get(res2).getNilai() + " / " + checkGrade(siswa.get(res2).getNilai()));
					if (checkGrade(siswa.get(res2).getNilai()).equals("C")
							|| checkGrade(siswa.get(res2).getNilai()).equals("D")) {
						System.out.println("Anda Dinyatakan Tidak Lulus!");
					} else {
						System.out.println("Anda Dinyatakan Lulus!");
					}
					System.out.println();
					do {
						System.out.println("Apakah Anda ingin lanjut? [Yes / No]");
						yesno = scan.nextLine();
					} while (!yesno.equals("Yes") && !yesno.equals("No"));
				} else {
					System.out.println("Nama tidak ditemukan!");
				}
				System.out.println();
			} while (yesno.equals("Yes"));
			
		}else if(res == 0) {
			System.out.println("Sorry, program can't find your account!");
		}
		
	}

	public String checkGrade(int nilai) {
		String grade;
		
		if(nilai >= 0 && nilai <= 35) {
			grade = "D";
		}else if(nilai >= 36 && nilai <= 55) {
			grade = "C";
		}else if(nilai >= 56 && nilai <= 78) {
			grade = "B";
		}else if(nilai >= 79 && nilai <= 85) {
			grade = "A-";
		}else {
			grade = "A+";
		}
		
		return grade;
	}

	public void signUp() {
		String email, pass, conEmail, conPass;
		System.out.println();
		do {
			System.out.print("Please Input Your Username [ @binus.ac.id ] :");
			email = scan.nextLine();
		} while (!email.endsWith("@binus.ac.id"));
		do {
			System.out.print("Please Input Your Password :");
			pass = scan.nextLine();
		} while (pass.length() < 5 || pass.length() > 6);
		System.out.println();
		do {
			System.out.print("Konfirmasi Username [ @binus.ac.id ] :");
			conEmail = scan.nextLine();
			System.out.print("Konfirmasi Password :");
			conPass = scan.nextLine();
		} while (!conEmail.equals(email) || !conPass.equals(pass));
		Account acc = new Account(email, pass);
		akun.add(acc);
		System.out.println();
		System.out.println("Successfully created account");
		System.out.println("Please Enter to Continue....");
		scan.nextLine();
	}

	public int searchAccount(String email, String pass) {
		for(int i = 0; i < akun.size(); i++) {
			if(akun.get(i).getEmail().equals(email) && akun.get(i).getPass().equals(pass)){
				return 1;
			}
		}
		return 0;
	}
	
	public int searchName(String name) {
		for(int i = 0; i < siswa.size(); i++) {
			if(siswa.get(i).getName().equals(name)){
				return i;
			}
		}
		return -1;

	}

	public int wordCounter(String name) {
		int count = 0;
		boolean isLetter = false;
		char[] arrName = name.toCharArray();
		
		for(int i=0; i<arrName.length; i++) {
			if((Character.isLetter(arrName[i]) || Character.isDigit(arrName[i])) && i != name.length() - 1) {
				isLetter = true;
			}else if(!(Character.isLetter(arrName[i]) || Character.isDigit(arrName[i])) && isLetter == true) {
				count++;
				isLetter = false;
			}else if((Character.isLetter(arrName[i]) || Character.isDigit(arrName[i])) && i == name.length() - 1) {
				count++;
			}
		}
		
		return count;
	}

	public void menuGuru() {
		int menu;
		boolean back = false;
		do {
			System.out.println("1. Input Nilai");
			System.out.println("2. Lihat Nilai");
			System.out.print("Choose >> ");
			menu = scan.nextInt();
			scan.nextLine();
			switch (menu) {
			case 1:
				inputNilai();
				break;
			case 2:
				if (siswa.size() == 0) {
					System.out.println();
					System.out.println("Belum ada data!");
					back = true;
					break;
				}
				System.out.println();
				lihatNilai();
				back = true;
				break;
			}
		} while (back == false);
	}

	public void inputNilai() {
		String nama;
		int nilai;
		System.out.println();
		do {
			System.out.print("Masukkan Nama Siswa [2 kata] :");
			nama = scan.nextLine();
		} while (wordCounter(nama) < 2);
		do {
			System.out.print("Masukkan Nilai Siswa [0 - 100] :");
			nilai = scan.nextInt();
			scan.nextLine();
		} while (nilai < 0 || nilai > 100);
		
		Siswa sis = new Siswa(nama, nilai);
		siswa.add(sis);
		
		System.out.println();
		System.out.println("Data Updated!");
	}
	
	public void lihatNilai() {
		int total = 0;
		double avg;
		for(int i = 0; i < siswa.size(); i++) {
			System.out.println("________________________________________");
			System.out.println("No			:"+(i+1));
			System.out.println("Nama Siswa		:"+siswa.get(i).getName());
			System.out.println("Nilai Siswa		:"+siswa.get(i).getNilai());
			total += siswa.get(i).getNilai();
		}
		System.out.println("========================================");
	
		avg = total/siswa.size();
		System.out.printf("Nilai Rata-Rata Siswa : %.2f\n", avg);
		System.out.println();
	}

	public static void main(String[] args) {
		new Main();
	}

}
