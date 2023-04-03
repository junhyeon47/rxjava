package io.junhyeon.chapter03.c02;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HelloRxJavaObservableCreateLambdaExample {
	public static void main(String[] args) throws InterruptedException {
		Observable<String> observable = Observable.create(emitter -> {
			String[] datas = {"Hello", "RxJava"};
			for (String data : datas) {
				if (emitter.isDisposed()) { // 구독이 해지되면 처리 중단
					return;
				}
				emitter.onNext(data); // 데이터 통지
			}
			emitter.onComplete();// 데이터 통지 완료
		});

		observable.observeOn(Schedulers.computation())
			.subscribe(
				data -> Logger.log(LogType.ON_NEXT, data),
				error -> Logger.log(LogType.ON_ERROR, error),
				() -> Logger.log(LogType.ON_COMPLETE),
				disposable -> {/**아무것도 하지 않는다.*/}
		);

		Thread.sleep(500L);
	}
}
