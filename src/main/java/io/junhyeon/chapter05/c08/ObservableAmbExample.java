package io.junhyeon.chapter05.c08;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.junhyeon.common.CarMaker;
import io.junhyeon.common.SampleData;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableAmbExample {
	public static void main(String[] args) {
		List<Observable<Integer>> observables = Arrays.asList(
			Observable.fromIterable(SampleData.salesOfBranchA)
				.delay(200L, TimeUnit.MILLISECONDS)
				.doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE, "# branch A's sales")),
			Observable.fromIterable(SampleData.salesOfBranchB)
				.delay(300L, TimeUnit.MILLISECONDS)
				.doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE, "# branch B's sales")),
			Observable.fromIterable(SampleData.salesOfBranchC)
				.delay(500L, TimeUnit.MILLISECONDS)
				.doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE, "# branch C's sales"))
		);

		Observable.amb(observables)
			.doOnComplete(() -> Logger.log(LogType.ON_COMPLETE, "# 완료"))
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

		TimeUtil.sleep(1000);
	}
}
