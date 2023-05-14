package io.junhyeon.chapter05.c01;

import java.util.concurrent.CompletableFuture;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.junhyeon.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableFromFutureExample {
	public static void main(String[] args) {
		Logger.log(LogType.PRINT, "# start time");

		// 긴 처리 시간이 걸리는 작업
		CompletableFuture<Double> future = longTimeWork();

		// 짧은 처리 시간이 걸리는 작업
		shortTimeWork();

		Observable.fromFuture(future)
			.subscribe(data -> Logger.log(LogType.PRINT, "# 긴 처리 시간 작업 결과: " + data));

		Logger.log(LogType.PRINT, "# ent time");
	}

	private static CompletableFuture<Double> longTimeWork() {
		return CompletableFuture.supplyAsync(ObservableFromFutureExample::calculate);
	}

	private static Double calculate() {
		Logger.log(LogType.PRINT, "# 긴 처리 시간이 걸리는 작업 중......");
		TimeUtil.sleep(6000L);
		return 100000000000000000.0;
	}

	private static void shortTimeWork() {
		TimeUtil.sleep(3000);
		Logger.log(LogType.PRINT, "# 짧은 처리 시간 작업 완료!");
	}
}
