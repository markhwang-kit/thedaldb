package game;

import java.util.Scanner;

import dao.UserDao;
import dao.UserDaoImpl;
import dto.UserDto;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("디비 게임");
		System.out.println("아이디 있으면 아이디 입력\n없으면 가입하세요.");
		System.out.print("입력: ");
		Scanner sc = new Scanner(System.in);
		String id = sc.next();   // id 입력 받기
		System.out.println("당신이 입력한 ID: " + id);
		UserDao userDao = new UserDaoImpl();
		UserDto dto = userDao.select(id);
		if (dto == null) {
			System.out.println("데이터가 없다");
		} else {
			System.out.println("데이터가 있다");
		}
	}

}
