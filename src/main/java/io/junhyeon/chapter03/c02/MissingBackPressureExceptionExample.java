package io.junhyeon.chapter03.c02;

import java.util.concurrent.TimeUnit;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class MissingBackPressureExceptionExample {
	public static void main(String[] args) throws InterruptedException {
		Flowable.interval(1L, TimeUnit.MILLISECONDS)
			.doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data)) // 데이터를 통지할 때, 호출되는 콜백 함수
			.observeOn(Schedulers.computation()) // 데이터를 처리하는 스레드를 분리
			.subscribe(
				data -> {
					Logger.log(LogType.PRINT, "# 소비자 처리 대기 중..");
					TimeUtil.sleep(1000L);
					Logger.log(LogType.ON_NEXT, data);
				},
				error -> Logger.log(LogType.ON_ERROR, error),
				() -> Logger.log(LogType.DO_ON_COMPLETE)
			);
		Thread.sleep(2000L);
	}
}
