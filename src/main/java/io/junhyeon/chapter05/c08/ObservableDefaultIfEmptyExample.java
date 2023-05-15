package io.junhyeon.chapter05.c08;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class ObservableDefaultIfEmptyExample {
	public static void main(String[] args) {
		Observable.just(1,2,3,4,5)
			.filter(num -> num > 10)
			.defaultIfEmpty(10)
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
	}
}
