package io.junhyeon.chapter03.c03;

import io.junhyeon.utils.DateUtil;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Maybe;

public class MaybeJustExample {
	public static void main(String[] args) {
		Maybe.just(DateUtil.getNowDate())
			.subscribe(
				data -> Logger.log(LogType.ON_SUCCESS, "# 현재 날짜시각: " + data),
				error -> Logger.log(LogType.ON_ERROR, error),
				() -> Logger.log(LogType.ON_COMPLETE)
			);

		Maybe.empty()
			.subscribe(
				data -> Logger.log(LogType.ON_SUCCESS, "# 현재 날짜시각: " + data),
				error -> Logger.log(LogType.ON_ERROR, error),
				() -> Logger.log(LogType.ON_COMPLETE)
			);
	}
}
