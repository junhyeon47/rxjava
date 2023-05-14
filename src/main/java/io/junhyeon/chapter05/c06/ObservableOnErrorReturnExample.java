package io.junhyeon.chapter05.c06;

import java.util.concurrent.TimeUnit;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableOnErrorReturnExample {
	public static void main(String[] args) {
		Observable.just(5)
			.flatMap(num -> Observable
				.interval(200L, TimeUnit.MILLISECONDS)
				.doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
				.take(5)
				.map(i -> num /i)
				.onErrorReturn(exception -> {
					if(exception instanceof ArithmeticException) {
						Logger.log(LogType.PRINT, "계산 처리 에러 발생: " + exception.getMessage());
					}

					return -1L;
				})
			)
			.subscribe(
				data -> {
					if(data < 0) {
						Logger.log(LogType.PRINT, "# 예외를 알리는 데이터: " + data);
					} else {
						Logger.log(LogType.ON_NEXT, data);
					}
				},
				error -> Logger.log(LogType.ON_ERROR, error),
				() -> Logger.log(LogType.ON_COMPLETE)
			);

		TimeUtil.sleep(1000);
	}
}
