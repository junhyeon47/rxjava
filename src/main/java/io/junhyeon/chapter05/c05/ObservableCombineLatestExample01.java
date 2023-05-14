package io.junhyeon.chapter05.c05;

import java.util.concurrent.TimeUnit;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableCombineLatestExample01 {
	public static void main(String[] args) {
		Observable<Long> observable1 = Observable.interval(500, TimeUnit.MILLISECONDS).take(4);
		Observable<Long> observable2 = Observable.interval(700, TimeUnit.MILLISECONDS).take(4);

		Observable.combineLatest(observable1, observable2, (data1, data2) -> "data1: " + data1 + "\tdata2: " + data2)
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

		TimeUtil.sleep(3000);
	}
}
