package io.junhyeon.chapter03.c03;

import io.junhyeon.utils.DateUtil;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MaybeCreateExample {
	public static void main(String[] args) {
		Maybe<String> maybe = Maybe.create(new MaybeOnSubscribe<String>() {
			@Override
			public void subscribe(@NonNull MaybeEmitter<String> emitter) throws Exception {
				emitter.onSuccess(DateUtil.getNowDate());

				//emitter.onComplete();
			}
		});

		maybe.subscribe(new MaybeObserver<String>() {
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

			@Override
			public void onComplete() {
				Logger.log(LogType.ON_COMPLETE);
			}
		});
	}
}
