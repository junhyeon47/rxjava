package io.junhyeon.chapter07;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class SchedulerSingleExample {
	public static void main(String[] args) {
		Observable<String> observable = Observable.just("1", "2", "3", "4", "5");

		observable.subscribeOn(Schedulers.single())
			.map(data -> "## " + data + " ##")
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

		observable.subscribeOn(Schedulers.single())
			.map(data -> "$$ " + data + " $$")
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

		TimeUtil.sleep(300);
	}
}
