package io.junhyeon.chapter05.c04;

import io.junhyeon.common.SampleData;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class Quiz01 {
	public static void main(String[] args) {
		Observable.fromIterable(SampleData.carList)
			.toMap(car -> car.getCarName(), car -> car.getCarMaker())
			.subscribe(map -> Logger.log(LogType.ON_NEXT, map));
	}
}
