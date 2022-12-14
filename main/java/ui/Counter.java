package ui;

import java.util.ArrayList;

public class Counter {


	private String item;
	private int sales;

	private static ArrayList<Counter> counterList = new ArrayList<>();

	public Counter() {

	}

	public Counter(String item, int sales) {
		super();
		this.item = item;
		this.sales = sales;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}


	public static ArrayList<Counter> getCounterList() {
		return counterList;
	}

	public static void  clear() {
		counterList.clear();
	}
	

	public static void add(Counter newCounter) {
		boolean isExists = false;
		// 判断item是否在 counterList中，如果不在，则添加，如果在，则取出之前的销售项相加
		for (Counter counter : counterList) {
			if (counter.item.equals(newCounter.getItem())) {
				counter.sales = counter.sales + newCounter.sales;
				isExists = true;
				break;
			}
		}
		// 退出循环之后，检查是否存在
		if (!isExists) {
			counterList.add(newCounter);
		}
	}

}
