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
			// dto 가 null 이기 때문에 new 로 공간을 만들어야함.
			dto = new UserDto();
			System.out.println("아이디가 없습니다");
			System.out.println("회원가입을 시작합니다.");
			System.out.print("이름을 입력하세요: ");
			String name = sc.next();
			// id와 이름을 dto 에 셋팅
			dto.setId(id);
			dto.setName(name);
			// DB에 insert를 한다.
			userDao.insert(dto);
		}
//		} else {
//			System.out.println("데이터가 있다");
//		
//		}
		
		// 유저 정보 출력
		System.out.println("당신의 정보입니다.");
		System.out.println("아이디: " + dto.getId());
		System.out.println("이름: " + dto.getName());
		System.out.println("점수: " + dto.getJumsu());
	}

}
