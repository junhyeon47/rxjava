package io.junhyeon.chapter07;

import java.io.File;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class SchedulerIOExample02 {
	public static void main(String[] args) {
		File[] files = new File("src/main/java/io/junhyeon").listFiles();

		Observable.fromArray(files)
			.doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data.getPath()))
			.subscribeOn(Schedulers.io())
			.observeOn(Schedulers.computation())
			.filter(data -> data.isDirectory())
			.map(dir -> dir.getName())
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

		TimeUtil.sleep(1000);
	}
}
