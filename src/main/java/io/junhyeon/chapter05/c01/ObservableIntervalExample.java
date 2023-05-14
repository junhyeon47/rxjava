package io.junhyeon.chapter05.c01;

import java.util.concurrent.TimeUnit;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableIntervalExample {

	public static void main(String[] args) {
		Observable.interval(0L, 1000L, TimeUnit.MILLISECONDS)
			.map(num -> num+" count")
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

		TimeUtil.sleep(3000);
	}
}
