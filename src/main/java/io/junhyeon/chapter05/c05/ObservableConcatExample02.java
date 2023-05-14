package io.junhyeon.chapter05.c05;

import java.util.Arrays;
import java.util.List;

import io.junhyeon.common.SampleData;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableConcatExample02 {
	public static void main(String[] args) {
		List<Observable<String>> observables = Arrays.asList(
			SampleData.getSpeedPerSection("A", 55L, SampleData.speedOfSectionA),
			SampleData.getSpeedPerSection("B", 100L, SampleData.speedOfSectionB),
			SampleData.getSpeedPerSection("C", 77L, SampleData.speedOfSectionC)
		);

		Observable.concat(observables).subscribe(data -> Logger.log(LogType.ON_NEXT, data));

		TimeUtil.sleep(2000);
	}
}
