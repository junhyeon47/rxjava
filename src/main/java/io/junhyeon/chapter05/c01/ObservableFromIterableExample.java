package io.junhyeon.chapter05.c01;

import java.util.Arrays;
import java.util.List;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class ObservableFromIterableExample {
	public static void main(String[] args) {
		List<String> countries = Arrays.asList("Korea", "Canada", "USA", "Italy");

		Observable.fromIterable(countries)
			.subscribe(country -> Logger.log(LogType.ON_NEXT, country));
	}
}
