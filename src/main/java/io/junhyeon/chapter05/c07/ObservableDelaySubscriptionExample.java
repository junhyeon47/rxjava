package io.junhyeon.chapter05.c07;

import java.util.concurrent.TimeUnit;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableDelaySubscriptionExample {
	public static void main(String[] args) {
		Logger.log(LogType.PRINT, "# 실행 시작 시간: " + TimeUtil.getCurrentTimeFormatted());

		Observable.just(1, 3, 4, 6)
			.doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
			.delaySubscription(2000L, TimeUnit.MILLISECONDS)
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

		TimeUtil.sleep(2500L);
	}
}
