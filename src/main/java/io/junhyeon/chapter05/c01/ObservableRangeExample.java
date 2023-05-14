package io.junhyeon.chapter05.c01;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class ObservableRangeExample {

	public static void main(String[] args) {
		Observable<Integer> source = Observable.range(0, 5);
		source.subscribe(num -> Logger.log(LogType.ON_NEXT, num));
	}
}
