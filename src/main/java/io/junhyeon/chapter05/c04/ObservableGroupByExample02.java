package io.junhyeon.chapter05.c04;

import io.junhyeon.common.Car;
import io.junhyeon.common.CarMaker;
import io.junhyeon.common.SampleData;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

public class ObservableGroupByExample02 {
	public static void main(String[] args) {
		Observable<GroupedObservable<CarMaker, Car>> observable = Observable.fromIterable(SampleData.carList).groupBy(Car::getCarMaker);

		observable.subscribe(
			groupedObservable -> groupedObservable
				.filter(car -> groupedObservable.getKey().equals(CarMaker.CHEVROLET))
				.subscribe(
					car -> Logger.log(LogType.ON_NEXT, "Group: " + groupedObservable.getKey() + " | Car name: " + car.getCarName())
				)
		);
	}
}
