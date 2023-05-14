package io.junhyeon.chapter05.c02;

import java.util.concurrent.TimeUnit;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class Quiz02 {
	public static void main(String[] args) {
		Observable.interval(1000L, TimeUnit.MILLISECONDS)
			.takeWhile(data -> data < 10)
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

		TimeUtil.sleep(11000L);
	}
}
