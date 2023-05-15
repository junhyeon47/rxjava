package io.junhyeon.chapter05.c09;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class Quiz01 {
	public static void main(String[] args) {
		final int seed = 10;
		Observable.range(1, 9)
			.reduce(seed, (x, y) -> {
				int b = seed - y;
				Logger.log(LogType.PRINT, x + ", " + b);
				return x - b;
			})
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
	}
}
