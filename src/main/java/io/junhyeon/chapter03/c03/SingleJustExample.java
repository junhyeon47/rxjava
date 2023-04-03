package io.junhyeon.chapter03.c03;

import io.junhyeon.utils.DateUtil;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Single;

public class SingleJustExample {
	public static void main(String[] args) {
		Single.just(DateUtil.getNowDate())
			.subscribe(
			data -> Logger.log(LogType.ON_SUCCESS, "# 날짜시각: " + data),
			error -> Logger.log(LogType.ON_ERROR, error)
		);
	}
}
