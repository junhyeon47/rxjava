package io.junhyeon.chapter05.c08;

import io.junhyeon.common.CarMaker;
import io.junhyeon.common.SampleData;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ObservableSequenceEqualExample {
	public static void main(String[] args) {
		Observable<CarMaker> observable1 = Observable.fromArray(SampleData.carMakers)
			.subscribeOn(Schedulers.io())
			.delay(carMaker -> {
				TimeUtil.sleep(500L);
				return Observable.just(carMaker);
			})
			.doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, "# observable1: " + data));

		Observable<CarMaker> observable2 = Observable.fromArray(SampleData.carMakersDuplicated)
			.delay(carMaker -> {
				TimeUtil.sleep(1000L);
				return Observable.just(carMaker);
			})
			.doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, "# observable2: " + data));

		Observable.sequenceEqual(observable1, observable2)
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
	}
}
