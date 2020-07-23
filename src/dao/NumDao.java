package dao;

import java.util.ArrayList;

import dto.NumDto;

public interface NumDao {
	// 숫자 넣는거 2개 숫자
	public void insert(int num1, int num2);
	public void insert(NumDto dto);
	
	// 들어간 숫자를 꺼내오는거
	public ArrayList<NumDto> select();
	public ArrayList<NumDto> select(int num1);
	
	
}
