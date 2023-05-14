package io.junhyeon.chapter05.c07;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableDelayExample02 {
	public static void main(String[] args) {
		Observable.just(1, 3, 5, 7)
			.delay(item -> {
				TimeUtil.sleep(1000);
				return Observable.just(item);
			})
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
	}
}
