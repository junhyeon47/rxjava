package io.junhyeon.chapter05.c02;

import java.util.concurrent.TimeUnit;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableTakeUntilExample02 {
	public static void main(String[] args) {
		Observable.interval(1000L, TimeUnit.MILLISECONDS)
			.takeUntil(Observable.timer(5500L, TimeUnit.MILLISECONDS))
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

		TimeUtil.sleep(7500L);
	}
}
