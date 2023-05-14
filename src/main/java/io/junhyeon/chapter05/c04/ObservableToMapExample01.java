package io.junhyeon.chapter05.c04;

import java.util.List;
import java.util.Map;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;
import io.reactivex.Single;

public class ObservableToMapExample01 {
	public static void main(String[] args) {
		Single<Map<String, String>> single = Observable.just("a-Alpha", "b-Bravo", "c-Charlie", "e-Echo")
			.toMap(data -> data.split("-")[0]);

		single.subscribe(map -> Logger.log(LogType.ON_NEXT, map));
	}
}
