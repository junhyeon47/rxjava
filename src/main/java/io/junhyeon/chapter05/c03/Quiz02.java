package io.junhyeon.chapter05.c03;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class Quiz02 {

	public static void main(String[] args) {
		Observable.range(1, 9)
			.filter(num -> num % 2 == 0)
			.flatMap(num ->
				Observable.range(1, 9),
				(source, transform) -> source + " * " + transform + " = " + source * transform
				)
			.subscribe(num -> Logger.log(LogType.ON_NEXT, num));
	}
}
