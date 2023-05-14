package io.junhyeon.chapter05.c02;

import io.junhyeon.common.SampleData;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class ObservableDistinctExample03 {
	public static void main(String[] args) {
		Observable.fromIterable(SampleData.carList)
			.distinct(car -> car.getCarMaker())
			.subscribe(car -> Logger.log(LogType.ON_NEXT, car.getCarName()));
	}
}
