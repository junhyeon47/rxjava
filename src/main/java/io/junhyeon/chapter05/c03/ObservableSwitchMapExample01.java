package io.junhyeon.chapter05.c03;

import java.util.concurrent.TimeUnit;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableSwitchMapExample01 {
	public static void main(String[] args) {
		Observable.interval(100L, TimeUnit.MILLISECONDS)
			.take(4)
			.skip(2)
			.doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
			.switchMap(num ->
				Observable.interval(200L, TimeUnit.MILLISECONDS)
					.take(10)
					.skip(1)
					.map(row -> num + " * " + row + " = " + num * row)
			)
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

		TimeUtil.sleep(5000L);
	}
}
