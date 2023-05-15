package io.junhyeon.chapter05.c09;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class ObservableReduceExample02 {
	public static void main(String[] args) {
		Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
			.reduce(0, (x, y) -> {
				Logger.log(LogType.PRINT, "# reduce 값: " + x + ", " + y);
				return x + y;
			})
			.subscribe(data -> Logger.log(LogType.ON_NEXT, "# 1부터 10까지의 누적 합계: " + data));
	}
}
