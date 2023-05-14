package io.junhyeon.chapter05.c03;

import java.util.Arrays;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class ObservableMapExample01 {
	public static void main(String[] args) {
		Observable.fromIterable(Arrays.asList(1, 3, 5, 7))
			.map(num -> "1을 더한 결과: " + (num + 1))
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
	}
}
