package io.junhyeon.chapter03.c03;

import io.junhyeon.utils.DateUtil;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class MaybeFromSingleExample {
	public static void main(String[] args) {
		Single<String> single = Single.just(DateUtil.getNowDate());
		Maybe.fromSingle(single)
			.subscribe(
				data -> Logger.log(LogType.ON_SUCCESS, "# 현재 날짜시각: " + data),
				error -> Logger.log(LogType.ON_ERROR, error),
				() -> Logger.log(LogType.ON_COMPLETE)
			);
	}
}
