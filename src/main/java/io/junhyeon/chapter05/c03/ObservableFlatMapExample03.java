package io.junhyeon.chapter05.c03;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class ObservableFlatMapExample03 {
	public static void main(String[] args) {
		Observable.range(2, 1)
			.flatMap(
				num -> Observable.range(1, 9),
				(source, transform) -> source + " * " + transform + " = " + source * transform
				)
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
	}
}
