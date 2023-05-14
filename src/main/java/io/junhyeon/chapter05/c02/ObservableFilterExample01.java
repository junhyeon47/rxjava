package io.junhyeon.chapter05.c02;

import io.junhyeon.common.CarMaker;
import io.junhyeon.common.SampleData;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class ObservableFilterExample01 {
	public static void main(String[] args) {
		Observable.fromIterable(SampleData.carList)
			.filter(car -> car.getCarMaker().equals(CarMaker.CHEVROLET))
			.subscribe(car -> Logger.log(LogType.ON_NEXT, car.getCarMaker() + " : " + car.getCarName()));
	}
}
