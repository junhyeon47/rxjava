package io.junhyeon.chapter05.c08;

import io.junhyeon.common.CarMaker;
import io.junhyeon.common.SampleData;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class ObservableContainsExample {
	public static void main(String[] args) {
		Observable.fromArray(SampleData.carMakersDuplicated)
			.doOnNext(data -> Logger.log(LogType.ON_NEXT, data))
			.contains(CarMaker.SAMSUNG)
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
	}
}
