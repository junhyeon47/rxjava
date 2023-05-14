package io.junhyeon.chapter05.c02;

import io.junhyeon.common.CarMaker;
import io.junhyeon.common.SampleData;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class ObservableDistinctExample02 {
	public static void main(String[] args) {
		Observable.fromArray(SampleData.carMakersDuplicated)
			.distinct()
			.filter(carMaker -> carMaker.equals(CarMaker.SSANGYOUNG))
			.subscribe(carMaker -> Logger.log(LogType.ON_NEXT, carMaker));
	}
}
