package io.junhyeon.chapter07;

import java.io.File;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class SchedulerIOExample03 {
	public static void main(String[] args) {
		File[] files = new File("src/main/java/io/junhyeon").listFiles();

		Observable.fromArray(files)
			.doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, "# 데이터 통지"))
			.subscribeOn(Schedulers.io())
			.observeOn(Schedulers.computation())
			.filter(data -> data.isDirectory())
			.doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, "# filter() 거침"))
			.observeOn(Schedulers.computation())
			.map(dir -> dir.getName())
			.doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, "# map() 거침"))
			.observeOn(Schedulers.computation())
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

		TimeUtil.sleep(1000);
	}
}
