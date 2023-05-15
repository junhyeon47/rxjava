package io.junhyeon.chapter05.c09;

import io.junhyeon.common.SampleData;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class ObservableCountExample01 {
	public static void main(String[] args) {
		Observable.fromIterable(SampleData.carList)
			.count()
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
	}
}
