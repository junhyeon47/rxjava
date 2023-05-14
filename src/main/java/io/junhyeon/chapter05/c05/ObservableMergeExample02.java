package io.junhyeon.chapter05.c05;

import java.util.concurrent.TimeUnit;

import io.junhyeon.common.SampleData;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableMergeExample02 {
	public static void main(String[] args) {
		Observable<String> observable1 = SampleData.getSpeedPerSection("A", 55L, SampleData.speedOfSectionA);
		Observable<String> observable2 = SampleData.getSpeedPerSection("B", 100L, SampleData.speedOfSectionB);
		Observable<String> observable3 = SampleData.getSpeedPerSection("C", 77L, SampleData.speedOfSectionC);

		Observable.merge(observable1, observable2, observable3)
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

		TimeUtil.sleep(1000);
	}
}
