package io.junhyeon.chapter05.c04;

import io.junhyeon.common.SampleData;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class ObservableToListExample02 {
	public static void main(String[] args) {
		Observable.fromIterable(SampleData.carList)
			.toList()
			.subscribe(cars -> Logger.log(LogType.ON_NEXT, cars));
	}
}
