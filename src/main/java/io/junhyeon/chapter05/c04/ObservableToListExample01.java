package io.junhyeon.chapter05.c04;

import java.util.List;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;
import io.reactivex.Single;

public class ObservableToListExample01 {
	public static void main(String[] args) {
		Single<List<Integer>> single = Observable.just(1, 3, 5, 7, 9).toList();

		single.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
	}
}
