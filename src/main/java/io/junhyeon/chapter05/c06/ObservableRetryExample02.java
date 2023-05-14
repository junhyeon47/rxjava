package io.junhyeon.chapter05.c06;

import java.util.concurrent.TimeUnit;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableRetryExample02 {
	private static final int RETRY_MAX = 5;
	public static void main(String[] args) {
		Observable.just(5)
			.flatMap(num -> Observable
				.interval(200L, TimeUnit.MILLISECONDS)
				.doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
				.take(5)
				.map(i -> {
					long result;

					try {
						result = num / i;
					} catch (ArithmeticException e) {
						Logger.log(LogType.PRINT, "error: " + e.getMessage());
						throw e;
					}

					return result;
				})
				.retry((retryCount, e) -> {
					Logger.log(LogType.PRINT, "# 재시도 횟수: " + retryCount);
					TimeUtil.sleep(1000);
					return retryCount < RETRY_MAX;
				})
				.onErrorReturn(throwable -> -1L)
			)
			.subscribe(
				data -> Logger.log(LogType.ON_NEXT, data),
				error -> Logger.log(LogType.ON_ERROR, error),
				() -> Logger.log(LogType.ON_COMPLETE)
			);

		TimeUtil.sleep(6000);
	}
}
