package io.junhyeon.chapter05.c05;

import java.util.concurrent.TimeUnit;

import io.junhyeon.common.SampleData;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.NumberUtil;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableCombineLatestExample02 {
	public static void main(String[] args) {
		Observable<Integer> observable1 = Observable.interval(NumberUtil.randomRange(100, 500), TimeUnit.MILLISECONDS)
			.take(10)
			.map(notUse -> SampleData.temperatureOfSeoul[NumberUtil.randomRange(0, 5)]);

		Observable<Integer> observable2 = Observable.interval(NumberUtil.randomRange(100, 500), TimeUnit.MILLISECONDS)
			.take(10)
			.map(notUse -> SampleData.humidityOfSeoul[NumberUtil.randomRange(0, 5)]);

		Observable.combineLatest(observable1, observable2,
				(temperature, humidity) -> "최신 온습도 데이터 - 온도: " + temperature + "\t습도: " + humidity + "%")
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

		TimeUtil.sleep(3000);
	}
}
