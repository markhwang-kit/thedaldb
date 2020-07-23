package dao;

import java.util.ArrayList;

import dto.UserDto;

public interface UserDao {

	// 데이터 넣고 
	public void insert(UserDto dto);
	
	// ID로 검색하고
	public UserDto select(String id);
	
	// 전체 데이터 가져오기
	public ArrayList<UserDto> select();
	
	// 점수 정보 업데이트
	public void update(UserDto dto);
}
