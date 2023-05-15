package io.junhyeon.chapter07;

import java.io.File;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class SchedulerIOExample01 {
	public static void main(String[] args) {
		File[] files = new File("src/main/java/io/junhyeon").listFiles();

		Observable.fromArray(files)
			.doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data.getName()))
			.filter(data -> data.isDirectory())
			.map(dir -> dir.getName())
			.subscribeOn(Schedulers.io())
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

		TimeUtil.sleep(1000);
	}
}
