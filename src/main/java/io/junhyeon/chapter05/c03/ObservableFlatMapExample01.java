package io.junhyeon.chapter05.c03;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class ObservableFlatMapExample01 {
	public static void main(String[] args) {
		Observable.just("Hello")
			.flatMap(hello -> Observable.just("자바", "파이썬", "안드로이드").map(lang -> hello +", " + lang))
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
	}
}
