package io.junhyeon.chapter05.c01;

import java.time.LocalTime;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableDeferExample {

	public static void main(String[] args) {
		Observable<LocalTime> observable = Observable.defer(() -> {
			LocalTime currentTime = LocalTime.now();
			return Observable.just(currentTime);
		});

		Observable<LocalTime> observableJust = Observable.just(LocalTime.now());

		observable.subscribe(time -> Logger.log(LogType.PRINT, "# defer() 구독1의 구독 시간: " + time));
		observableJust.subscribe(time -> Logger.log(LogType.PRINT, "# just() 구독1의 구독 시간: " + time));

		TimeUtil.sleep(3000);

		observable.subscribe(time -> Logger.log(LogType.PRINT, "# defer() 구독2의 구독 시간: " + time));
		observableJust.subscribe(time -> Logger.log(LogType.PRINT, "# just() 구독2의 구독 시간: " + time));
	}
}
