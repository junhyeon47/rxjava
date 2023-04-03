package io.junhyeon.chapter03.c02;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HelloRxJavaObservableCreateExample {
	public static void main(String[] args) throws InterruptedException {
		Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
			@Override
			public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
				String[] datas = {"Hello", "RxJava"};
				for (String data : datas) {
					if (emitter.isDisposed()) { // 구독이 해지되면 처리 중단
						return;
					}
					emitter.onNext(data); // 데이터 통지
				}
				emitter.onComplete();// 데이터 통지 완료
			}
		});

		observable.observeOn(Schedulers.computation())
			.subscribe(new Observer<String>() {

				@Override
				public void onSubscribe(Disposable disposable) {
					// BackPressure 가 없기 때문에 아무 처리도 하지 않음
				}

				@Override
				public void onNext(String data) {
					Logger.log(LogType.ON_NEXT, data);
				}

				@Override
				public void onError(Throwable error) {
					Logger.log(LogType.ON_ERROR, error);
				}

				@Override
				public void onComplete() {
					Logger.log(LogType.ON_COMPLETE);
				}
			});
		Thread.sleep(500L);
	}
}
