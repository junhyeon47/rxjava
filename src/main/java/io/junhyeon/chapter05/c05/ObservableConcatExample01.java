package io.junhyeon.chapter05.c05;

import java.util.concurrent.TimeUnit;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableConcatExample01 {
	public static void main(String[] args) {
		Observable<Long> observable1 = Observable.interval(500, TimeUnit.MILLISECONDS).take(4);
		Observable<Long> observable2 = Observable.interval(300, TimeUnit.MILLISECONDS).take(5).map(num -> num + 1000);

		Observable.concat(observable2, observable1)
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

		TimeUtil.sleep(3500);
	}
}
