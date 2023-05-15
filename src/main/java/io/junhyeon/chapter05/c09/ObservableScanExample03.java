package io.junhyeon.chapter05.c09;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class ObservableScanExample03 {
	public static void main(String[] args) {
		Observable.just("a", "b", "c", "d", "e")
			.scan((x, y) -> "(" + x + ", " + y + ")")
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
	}
}
