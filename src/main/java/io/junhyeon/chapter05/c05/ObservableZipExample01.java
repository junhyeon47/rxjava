package io.junhyeon.chapter05.c05;

import java.util.concurrent.TimeUnit;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableZipExample01 {
	public static void main(String[] args) {
		Observable<Long> observable1 = Observable.interval(200, TimeUnit.MILLISECONDS).take(4);
		Observable<Long> observable2 = Observable.interval(400, TimeUnit.MILLISECONDS).take(6);

		Observable.zip(observable2, observable1, (data1, data2) -> data1 + data2)
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

		TimeUtil.sleep(3000);
	}
}
