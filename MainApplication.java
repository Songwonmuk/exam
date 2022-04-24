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
					System.out.println("ã�� ��ȣ�� �����ϴ�.");
					return;
				}
				System.out.println("��ȸ�Ͻ� ��ȣ�� : " + searchedMember);
				break;

			case 3:
				printAll(phoneBookMap);
				break;
			case 0:
				System.out.println("����");
				return;

			}
		}
	}

	/**
	 * �޴� ����
	 * 
	 * @return choice
	 */
	private static int menu() {
		System.out.print("1 ���  2. ��ȸ  3. ��ü���  0.���� : ");
		return SCANNER.nextInt();
	}

	/**
	 * ���� �Է� �޾Ƽ� member ��ü ����
	 * 
	 * @return member
	 */
	private static Member createNewMember() {
		System.out.print("��ȭ��ȣ : ");
		String phoneNumber = SCANNER.next();
		System.out.print("�̸� : ");
		String name = SCANNER.next();
		System.out.print("���� : ");
		int age = SCANNER.nextInt();

		return new Member(name, phoneNumber, age);
	}

	/**
	 * ����ȣ�� member ��ȸ
	 * 
	 * @param phoneBookMap ��ȭ��ȣ/member ��ü ������ ���� map
	 * @return member
	 */
	private static Member searchMember(Map<String, Member> phoneBookMap) {
		System.out.print("��ȭ ��ȣ�� �Է��ϼ��� : ");
		String phoneNumber = SCANNER.next();
		return phoneBookMap.get(phoneNumber);
	}

	/**
	 * ��ü ���
	 * 
	 * @param phoneBookMap ��ȭ��ȣ/member ��ü ������ ���� map
	 */
	private static void printAll(Map<String, Member> phoneBookMap) {
		System.out.println("��ü ���");
		for (Member member : phoneBookMap.values()) {
			System.out.println(member);
		}
	}
}

/*
 * 1. ��� 2. ��ȸ 3. ��ü��� 0.���� : 1(����) ��ȭ��ȣ : 000-0000-0000 �̸� : �տ��� ���� : 22
 * 
 * 1.��� 2. ��ȸ 3. ��ü��� 0. ���� : 2(����)
 * 
 * ��ȭ��ȣ : 000-0000-0000 ��ȸ�� ���� 000-0000-0000 / �տ��� /22
 * 
 * 1.��� 2. ��ȸ 3. ��ü��� 0. ���� : 3(����)
 * 
 * ��ü���� 000-0000-0000 / �տ��� / 22 000-0000-0000 / ���Ȱ� / 23 000-0000-0000 / ����� /
 * 24
 * 
 */