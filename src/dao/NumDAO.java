package dao;

import java.util.ArrayList;

import dto.NumDTO;

public interface NumDAO {
	// 숫자 넣는거 2개 숫자
	public void insert(int num1, int num2);
	public void insert(NumDTO dto);
	
	// 들어간 숫자를 꺼내오는거
	public ArrayList<NumDTO> select();
	public ArrayList<NumDTO> select(int num1);
}
