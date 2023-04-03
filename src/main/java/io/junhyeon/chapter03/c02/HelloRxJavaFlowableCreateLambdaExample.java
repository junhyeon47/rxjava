package io.junhyeon.chapter03.c02;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class HelloRxJavaFlowableCreateLambdaExample {
	public static void main(String[] args) throws InterruptedException {
		Flowable<String> flowable = Flowable.create(emitter -> {
			String[] datas = {"Hello", "RxJava"};
			for (String data : datas) {
				if (emitter.isCancelled()) { // 구독이 해지되면 처리 중단
					return;
				}
				emitter.onNext(data); // 데이터 통지
			}
			emitter.onComplete();// 데이터 통지 완료
		}, BackpressureStrategy.BUFFER);

		flowable.observeOn(Schedulers.computation())
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data),
				error -> Logger.log(LogType.ON_ERROR, error),
				() -> Logger.log(LogType.ON_COMPLETE),
				subscription -> subscription.request(Long.MAX_VALUE));

		Thread.sleep(500L);
	}
}
