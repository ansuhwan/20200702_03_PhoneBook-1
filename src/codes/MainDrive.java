package codes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import codes.datas.User;

public class MainDrive {
	
	static List<User> myUserList = new ArrayList<>();

	public static void main(String[] args) {
		
		printMenu();
		
	}
	
	public static void printMenu() {

		Scanner myScan = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("*******전화번호부*******");
			System.out.println("1) 전화번호 추가 등록");
			System.out.println("2) 전체 전화번호 목록 조회");
			System.out.println("0) 프로그램 종료");
			System.out.println("======================");
			
			System.out.print("메뉴 선택 : ");
			int inputMenu = myScan.nextInt();
			
			if (inputMenu == 0) {
				System.out.println("전화번호부를 종료합니다..");
				break;
			}
			else if (inputMenu == 1) {
				addPhoneNumToFile();
			}
			else if (inputMenu == 2) {
				readAllPhoneNum();
			}
			else {
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력해주세요.");
			}
			
		}
		
	}
	
	public static void readAllPhoneNum() {
		
		myUserList.clear();
		
		File file = new File("phoneBook.txt");
		
		try {
			
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			while (true) {
				
				String line = br.readLine();
				
				if (line == null) {
					
					System.out.println("연락처를 모두 읽어왔습니다.");
					break;
					
				}
				
				String[] userInfos = line.split(","); 
				
				String userName = userInfos[0];
				String userPhoneNum = userInfos[1];
				int userBirthYear = Integer.parseInt(userInfos[2]);
				
				User user = new User(userName, userPhoneNum, userBirthYear);
				
				System.out.println(user);
				
				myUserList.add(user);
				
			}
			
			br.close();
			fr.close();
			
			
		} catch (FileNotFoundException e) {
			
			System.out.println("불러올 파일이 없습니다.");
			System.out.println("연락처를 저장하고 다시 시도해주세요.");
			
		} catch (IOException e) {
			
			System.out.println("연락처를 읽어오는 중에 문제가 발생했습니다.");
			e.printStackTrace();
			
		}
		
		System.out.println(String.format("저장된 연락처 갯수 : %d개", myUserList.size()));
		
		
	}
	
	public static void addPhoneNumToFile() {
		
		Scanner myScan = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String name = myScan.nextLine();
		
		System.out.print("전화번호 입력 : ");
		String phoneNum = myScan.nextLine();
		
		System.out.print("생년 입력 : ");
		int birthYear = myScan.nextInt();
		
		
		File phoneBookFile = new File("phoneBook.txt");
		
		try {
			FileWriter fw = new FileWriter(phoneBookFile, true);
			
			BufferedWriter bw = new BufferedWriter(fw);
			
			String infoStr = String.format("%s,%s,%d", name, phoneNum, birthYear);
			
			bw.append(infoStr);
			bw.newLine();
			
			bw.close();
			fw.close();
			
			System.out.println("연락처 저장이 완료 되었습니다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}


