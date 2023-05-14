package io.junhyeon.chapter05.c02;

import io.junhyeon.common.Car;
import io.junhyeon.common.SampleData;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableTakeUntilExample01 {
	public static void main(String[] args) {
		Observable.fromIterable(SampleData.carList)
			.takeUntil((Car car) -> car.getCarName().equals("트랙스"))
			.subscribe(car -> System.out.println(car.getCarName()));

		TimeUtil.sleep(300L);
	}
}
