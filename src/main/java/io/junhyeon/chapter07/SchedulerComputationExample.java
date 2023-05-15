package io.junhyeon.chapter07;

import java.sql.Time;
import java.util.Arrays;
import java.util.Collections;

import io.junhyeon.common.SampleData;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class SchedulerComputationExample {
	public static void main(String[] args) {
		Observable<Integer> observable1 = Observable.fromIterable(SampleData.seoulPM10List);
		Observable<Integer> observable2 = Observable.fromIterable(SampleData.busanPM10List);
		Observable<Integer> observable3 = Observable.fromIterable(SampleData.incheonPM10List);
		Observable<Integer> observable4 = Observable.range(1, 24);

		Observable<String> source = Observable.zip(observable1, observable2, observable3, observable4,
			(data1, data2, data3, hour) -> hour + "시: " + Collections.max(Arrays.asList(data1, data2, data3)));

		source.subscribeOn(Schedulers.computation())
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

		source.subscribeOn(Schedulers.computation())
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

		TimeUtil.sleep(500);
	}
}
