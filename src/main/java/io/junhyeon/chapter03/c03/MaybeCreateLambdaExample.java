package io.junhyeon.chapter03.c03;

import io.junhyeon.utils.DateUtil;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Maybe;

public class MaybeCreateLambdaExample {
	public static void main(String[] args) {
		Maybe<String> maybe = Maybe.create(emitter -> {
			emitter.onSuccess(DateUtil.getNowDate());
			//emitter.onComplete();
		});

		maybe.subscribe(
			data -> Logger.log(LogType.ON_SUCCESS, "# 현재 날짜시각: " + data),
			error -> Logger.log(LogType.ON_ERROR, error),
			() -> Logger.log(LogType.ON_COMPLETE)
		);
	}
}
