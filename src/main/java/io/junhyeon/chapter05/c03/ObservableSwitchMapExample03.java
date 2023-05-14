package io.junhyeon.chapter05.c03;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableSwitchMapExample03 {
	public static void main(String[] args) {
		TimeUtil.start();
		Searcher searcher = new Searcher();

		final List<String> keywords = Arrays.asList("M", "Ma", "Mal", "Malay");

		Observable.interval(100L, TimeUnit.MILLISECONDS)
			.take(4)
			.doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
			.switchMap(data -> {
				String keyword = keywords.get(data.intValue());

				return Observable.just(searcher.search(keyword))
					.doOnNext(notUse -> System.out.println("================================================================="))
					.delay(1000L, TimeUnit.MILLISECONDS);
			})
			.flatMap(results -> Observable.fromIterable(results))
			.subscribe(
				data -> Logger.log(LogType.ON_NEXT, data),
				error -> {
				},
				() -> {
					TimeUtil.end();
					TimeUtil.takeTime();;
				}
			);

		TimeUtil.sleep(6000L);
	}
}
