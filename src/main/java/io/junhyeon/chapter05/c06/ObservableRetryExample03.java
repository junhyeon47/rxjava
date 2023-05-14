package io.junhyeon.chapter05.c06;

import java.util.concurrent.TimeUnit;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableRetryExample03 {
	public static void main(String[] args) {
		Observable.just(10, 12, 15, 16)
			.zipWith(Observable.just(1, 2, 0, 4), (a, b) -> {
				long result;

				try {
					result = a / b;
				} catch (ArithmeticException e) {
					Logger.log(LogType.PRINT, "error: " + e.getMessage());
					throw e;
				}

				return result;
			})
			.retry(5)
			.onErrorReturn(throwable -> -1L)
			.subscribe(
				data -> Logger.log(LogType.ON_NEXT, data),
				error -> Logger.log(LogType.ON_ERROR, error),
				() -> Logger.log(LogType.ON_COMPLETE)
			);

		TimeUtil.sleep(5000);
	}
}
