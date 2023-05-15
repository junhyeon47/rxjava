package io.junhyeon.chapter05.c08;

import io.junhyeon.common.CarMaker;
import io.junhyeon.common.SampleData;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class ObservableAllExample {
	public static void main(String[] args) {
		Observable.fromIterable(SampleData.carList)
			.doOnNext(car -> Logger.log(LogType.DO_ON_NEXT, "Car Maker: " + car.getCarMaker() + ",\tCar Name: " + car.getCarName()))
			.map(car -> car.getCarMaker())
			.all(carMaker -> carMaker.equals(CarMaker.CHEVROLET))
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
	}
}
