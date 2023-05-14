package io.junhyeon.chapter05.c02;

import io.junhyeon.common.SampleData;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class ObservableDistinctExample01 {
	public static void main(String[] args) {
		Observable.fromArray(SampleData.carMakersDuplicated)
			.distinct()
			.subscribe(carMaker -> Logger.log(LogType.ON_NEXT, carMaker));
	}
}
