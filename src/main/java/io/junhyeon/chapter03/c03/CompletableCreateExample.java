package io.junhyeon.chapter03.c03;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CompletableCreateExample {
	public static void main(String[] args) {
		Completable completable = Completable.create(new CompletableOnSubscribe() {
			@Override
			public void subscribe(@NonNull CompletableEmitter emitter) throws Exception {
				// 데이터를 통지하는 것이 아니라 특정 작업을 수행한 후, 완료를 통지한다.
				int sum = 0;
				for (int i = 0; i < 100; i++) {
					sum += i;
				}
				Logger.log(LogType.PRINT, "# 합계: " + sum);

				emitter.onComplete();
			}
		});

		completable.subscribeOn(Schedulers.computation())
			.subscribe(new CompletableObserver() {
				@Override
				public void onSubscribe(@NonNull Disposable disposable) {
					// 아무것도 하지 않음
				}

				@Override
				public void onComplete() {
					Logger.log(LogType.ON_COMPLETE);
				}

				@Override
				public void onError(@NonNull Throwable error) {
					Logger.log(LogType.ON_ERROR, error);
				}
			});

		TimeUtil.sleep(100L);
	}
}
