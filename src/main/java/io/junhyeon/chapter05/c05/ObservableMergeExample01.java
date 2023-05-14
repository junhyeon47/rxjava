package io.junhyeon.chapter05.c05;

import java.util.concurrent.TimeUnit;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableMergeExample01 {
	public static void main(String[] args) {
		Observable<Long> observable1 = Observable.interval(200, TimeUnit.MILLISECONDS).take(5);
		Observable<Long> observable2 = Observable.interval(400, TimeUnit.MILLISECONDS).take(5).map(num -> num + 1000);

		Observable.merge(observable1, observable2)
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

		TimeUtil.sleep(4000);
	}
}
