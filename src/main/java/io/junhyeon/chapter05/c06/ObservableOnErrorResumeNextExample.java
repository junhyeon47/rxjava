package io.junhyeon.chapter05.c06;

import java.util.concurrent.TimeUnit;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableOnErrorResumeNextExample {
	public static void main(String[] args) {
		Observable.just(5)
			.flatMap(num -> Observable
				.interval(200L, TimeUnit.MILLISECONDS)
				.doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
				.take(5)
				.map(i -> num / i)
				.onErrorResumeNext(throwable -> {
					Logger.log(LogType.PRINT, "# 운영자에게 이메일 발송 " + throwable);
					return Observable.interval(200, TimeUnit.MILLISECONDS).take(5).skip(1).map(i -> num / i);
				})
			)
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

		TimeUtil.sleep(2000);
	}
}
