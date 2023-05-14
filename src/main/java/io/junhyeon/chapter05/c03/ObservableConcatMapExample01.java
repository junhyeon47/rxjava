package io.junhyeon.chapter05.c03;

import java.util.concurrent.TimeUnit;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableConcatMapExample01 {
	public static void main(String[] args) {
		TimeUtil.start();
		Observable.interval(100L, TimeUnit.MILLISECONDS)
			.take(4)
			.skip(2)
			.concatMap(num ->
				Observable.interval(200L, TimeUnit.MILLISECONDS)
					.take(10)
					.skip(1)
					.map(row -> num + " * " + row + " = " + num * row)
			)
			.subscribe(
				data -> Logger.log(LogType.ON_NEXT, data),
				error -> {
				},
				() -> {
					TimeUtil.end();
					TimeUtil.takeTime();
				}
			);

		TimeUtil.sleep(5000L);
	}
}
