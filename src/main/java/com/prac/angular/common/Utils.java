package com.prac.angular.common;

import java.util.ArrayList;
import java.util.List;

public final class Utils {
	public static void println(String str) {
		System.out.println("\u001B[31m"+str);
	}
	
	public static Boolean isNullOrEmpty(Object obj) {
		if(obj == null || obj.toString().isEmpty()) {
			return true;
		}else {
			return false;
		}
	}

	public static List<Integer> getRowNumber(BaseVO pageInfo) {
		int page = pageInfo.getPage();
		int pageSize = pageInfo.getPageSize();
		int beginRow = (page * pageSize) - pageSize + 1;
		if(beginRow < 1) {
			beginRow = 1;
		}
		List<Integer> rowNum = new ArrayList<>();
		for(int i=0; i<pageSize; i++) {
			rowNum.add(beginRow);
			beginRow++;
		}
		return rowNum;
	}
}
