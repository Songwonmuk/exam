package exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainApplication {
	private static final Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {
		Map<String, Member> phoneBookMap = new HashMap<>();
		while (true) {
			int menu = menu();
			switch (menu) {
			case 1:
				Member member = createNewMember();
				phoneBookMap.put(member.getPhoneNumber(), member);
				break;
			case 2:
				Member searchedMember = searchMember(phoneBookMap);
				if (searchedMember == null) {
					System.out.println("찾는 번호가 없습니다.");
					return;
				}
				System.out.println("조회하신 번호는 : " + searchedMember);
				break;

			case 3:
				printAll(phoneBookMap);
				break;
			case 0:
				System.out.println("종료");
				return;

			}
		}
	}

	/**
	 * 메뉴 선택
	 * 
	 * @return choice
	 */
	private static int menu() {
		System.out.print("1 등록  2. 조회  3. 전체출력  0.종료 : ");
		return SCANNER.nextInt();
	}

	/**
	 * 정보 입력 받아서 member 객체 생성
	 * 
	 * @return member
	 */
	private static Member createNewMember() {
		System.out.print("전화번호 : ");
		String phoneNumber = SCANNER.next();
		System.out.print("이름 : ");
		String name = SCANNER.next();
		System.out.print("나이 : ");
		int age = SCANNER.nextInt();

		return new Member(name, phoneNumber, age);
	}

	/**
	 * 폰번호로 member 조회
	 * 
	 * @param phoneBookMap 전화번호/member 객체 정보를 담은 map
	 * @return member
	 */
	private static Member searchMember(Map<String, Member> phoneBookMap) {
		System.out.print("전화 번호를 입력하세요 : ");
		String phoneNumber = SCANNER.next();
		return phoneBookMap.get(phoneNumber);
	}

	/**
	 * 전체 출력
	 * 
	 * @param phoneBookMap 전화번호/member 객체 정보를 담은 map
	 */
	private static void printAll(Map<String, Member> phoneBookMap) {
		System.out.println("전체 출력");
		for (Member member : phoneBookMap.values()) {
			System.out.println(member);
		}
	}
}

/*
 * 1. 등록 2. 조회 3. 전체출력 0.종료 : 1(엔터) 전화번호 : 000-0000-0000 이름 : 손오공 나이 : 22
 * 
 * 1.등록 2. 조회 3. 전체출력 0. 종료 : 2(엔터)
 * 
 * 전화번호 : 000-0000-0000 조회된 정보 000-0000-0000 / 손오공 /22
 * 
 * 1.등록 2. 조회 3. 전체출력 0. 종료 : 3(엔터)
 * 
 * 전체정보 000-0000-0000 / 손오공 / 22 000-0000-0000 / 저팔계 / 23 000-0000-0000 / 사오정 /
 * 24
 * 
 */