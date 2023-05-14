package io.junhyeon.chapter05.c01;

import java.util.concurrent.TimeUnit;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableTimerExample {

	public static void main(String[] args) {
		Logger.log(LogType.PRINT, "# Start");
		Observable<String> observable = Observable.timer(2000, TimeUnit.MILLISECONDS)
			.map(count -> "Do work!");

		observable.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

		TimeUtil.sleep(3000);
	}
}
