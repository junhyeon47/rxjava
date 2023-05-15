package io.junhyeon.chapter05.c09;

import java.util.Arrays;

import io.junhyeon.common.SampleData;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class ObservableCountExample02 {
	public static void main(String[] args) {
		Observable.concat(
				Arrays.asList(
					Observable.fromIterable(SampleData.seoulPM10List),
					Observable.fromIterable(SampleData.busanPM10List),
					Observable.fromIterable(SampleData.incheonPM10List)
				)
			)
			.count()
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
	}
}
