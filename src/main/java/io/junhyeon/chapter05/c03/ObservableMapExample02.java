package io.junhyeon.chapter05.c03;

import java.util.Arrays;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class ObservableMapExample02 {
	public static void main(String[] args) {
		Observable.just("korea", "america", "canada", "france", "japan", "china")
			.filter(country -> country.length() == 5)
			.map(country -> country.toUpperCase().charAt(0) + country.substring(1))
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
	}
}
