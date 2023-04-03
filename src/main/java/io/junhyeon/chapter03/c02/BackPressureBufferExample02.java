package io.junhyeon.chapter03.c02;

import java.util.concurrent.TimeUnit;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class BackPressureBufferExample02 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("# start : " +TimeUtil.getCurrentTimeFormatted());
		Flowable.interval(300L, TimeUnit.MILLISECONDS)
			.doOnNext(data -> Logger.log("#interval doOnNext()", data)) // 데이터를 통지할 때, 호출되는 콜백 함수
			.onBackpressureBuffer(
				2, // 버퍼의 크기
				() -> Logger.log("overflow!"),
				BackpressureOverflowStrategy.DROP_OLDEST)
			.doOnNext(data -> Logger.log("#onBackpressureBuffer doOnNext()", data))
			.observeOn(Schedulers.computation(), false, 1) // bufferSize: 소비자가 생산자에게 요청하는 데이터 개수
			.subscribe(
				data -> {
					TimeUtil.sleep(1000L);
					Logger.log(LogType.ON_NEXT, data);
				},
				error -> Logger.log(LogType.ON_ERROR, error)
			);
		Thread.sleep(2800L);
	}
}
