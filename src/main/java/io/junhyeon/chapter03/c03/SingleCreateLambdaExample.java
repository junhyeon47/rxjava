package io.junhyeon.chapter03.c03;

import io.junhyeon.utils.DateUtil;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Single;

public class SingleCreateLambdaExample {
	public static void main(String[] args) {
		Single<String> single = Single.create(emitter -> emitter.onSuccess(DateUtil.getNowDate()));

		single.subscribe(
			data -> Logger.log(LogType.ON_SUCCESS, "# 날짜시각: " + data),
			error -> Logger.log(LogType.ON_ERROR, error)
		);
	}
}
