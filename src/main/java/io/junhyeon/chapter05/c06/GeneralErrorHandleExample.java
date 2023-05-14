package io.junhyeon.chapter05.c06;

import java.util.concurrent.TimeUnit;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class GeneralErrorHandleExample {
	public static void main(String[] args) {
		Observable.just(5)
			.flatMap(num -> Observable
				.interval(200L, TimeUnit.MILLISECONDS)
				.doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
				.take(5)
				.map(i -> num /i))
			.subscribe(
				data -> Logger.log(LogType.ON_NEXT, data),
				error -> Logger.log(LogType.ON_ERROR, error),
				() -> Logger.log(LogType.ON_COMPLETE)
			);

		TimeUtil.sleep(1000);
	}
}
