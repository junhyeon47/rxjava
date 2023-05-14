package io.junhyeon.chapter05.c02;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class ObservableSkipExample01 {
	public static void main(String[] args) {
		Observable.range(1, 15)
			.skip(3)
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
	}
}
