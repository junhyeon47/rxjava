package io.junhyeon.chapter05.c03;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class Quiz01 {

	public static void main(String[] args) {
		Observable.range(1, 15)
			.filter(num -> num % 2 == 0)
			.map(num -> num * num)
			.subscribe(num -> Logger.log(LogType.ON_NEXT, num));
	}
}
