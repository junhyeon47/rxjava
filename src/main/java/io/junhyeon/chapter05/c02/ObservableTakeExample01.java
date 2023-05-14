package io.junhyeon.chapter05.c02;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class ObservableTakeExample01 {
	public static void main(String[] args) {
		Observable.just("a", "b", "c", "d")
			.take(2)
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
	}
}
