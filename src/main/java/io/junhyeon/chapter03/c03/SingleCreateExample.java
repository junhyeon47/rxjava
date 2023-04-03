package io.junhyeon.chapter03.c03;

import io.junhyeon.utils.DateUtil;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class SingleCreateExample {
	public static void main(String[] args) {
		Single<String> single = Single.create(new SingleOnSubscribe<String>() {
			@Override
			public void subscribe(@NonNull SingleEmitter<String> emitter) throws Exception {
				emitter.onSuccess(DateUtil.getNowDate());
			}
		});

		single.subscribe(new SingleObserver<String>() {
			@Override
			public void onSubscribe(@NonNull Disposable disposable) {
				// 아무것도 하지 않음
			}

			@Override
			public void onSuccess(@NonNull String data) {
				Logger.log(LogType.ON_SUCCESS, "# 날짜시각: "+ data);
			}

			@Override
			public void onError(@NonNull Throwable error) {
				Logger.log(LogType.ON_ERROR, error);
			}
		});
	}
}
