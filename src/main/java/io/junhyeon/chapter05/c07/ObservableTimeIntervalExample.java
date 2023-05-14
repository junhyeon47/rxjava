package io.junhyeon.chapter05.c07;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.NumberUtil;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableTimeIntervalExample {
	public static void main(String[] args) {
		Observable.just(1, 3, 5, 7, 9)
			.delay(item -> {
				TimeUtil.sleep(NumberUtil.randomRange(100, 1000));
				return Observable.just(item);
			})
			.timeInterval()
			.subscribe(data -> Logger.log(LogType.ON_NEXT, "# 통지하는데 걸리는 시간: " + data.time() + "ms \t 데이터: " + data.value()));
	}
}
