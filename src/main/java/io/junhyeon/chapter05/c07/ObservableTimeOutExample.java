package io.junhyeon.chapter05.c07;

import java.util.concurrent.TimeUnit;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableTimeOutExample {
	public static void main(String[] args) {
		Observable.range(1, 5)
			.map(num -> {
				long time = 1000L;
				if (num == 4) {
					time = 1500L;
				}
				TimeUtil.sleep(time);
				return num;
			})
			.timeout(1200L, TimeUnit.MILLISECONDS)
			.subscribe(
				data -> Logger.log(LogType.ON_NEXT, data),
				error -> Logger.log(LogType.ON_ERROR, error)
			);

		TimeUtil.sleep(4000L);
	}
}
