package ui;

import java.util.ArrayList;
import java.util.List;

public class MarkSex {

	private String mark; 
	private int woman; 
	private int man; 
	
	private static ArrayList<MarkSex> markSexList=new ArrayList<MarkSex>();
	
	public MarkSex() {
		
	}
	
	public MarkSex(String mark, int woman, int man) {
		super();
		this.mark = mark;
		this.woman = woman;
		this.man = man;
	}

	public String getMark() {
		return mark;
	}

	public int getWoman() {
		return woman;
	}

	public int getMan() {
		return man;
	}


	public static void  clear() {
		markSexList.clear();
	}
	
	
	public static ArrayList<MarkSex> getMarkSexList() {
		return markSexList;
	}

	
	public static void add(MarkSex newmarkSex) {
		boolean isExists = false;
		//判断item是否在markSexList中，如果不在，则添加，如果在，则取出之前的销售项相加
		for (MarkSex markSex : markSexList) {
			if (markSex.mark.equals(newmarkSex.getMark())) {
				markSex.woman=markSex.woman+newmarkSex.getWoman();
				markSex.man=markSex.woman+newmarkSex.getMan();
				isExists = true;
				break;
			}
		}
		// 退出循环之后，检查是否存在,如果不存在，则添加
		if (!isExists) {
			markSexList.add(newmarkSex);
		}
	}
	

}
