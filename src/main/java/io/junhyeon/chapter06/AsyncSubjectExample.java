package io.junhyeon.chapter06;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.subjects.AsyncSubject;

public class AsyncSubjectExample {
	public static void main(String[] args) {
		AsyncSubject<Integer> subject = AsyncSubject.create();
		subject.onNext(1000);

		subject.doOnNext(price -> Logger.log(LogType.DO_ON_NEXT, "# 소비자 1: "+ price))
			.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 1: "+ price));
		subject.onNext(2000);

		subject.doOnNext(price -> Logger.log(LogType.DO_ON_NEXT, "# 소비자 2: "+ price))
			.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 2: "+ price));
		subject.onNext(3000);

		subject.doOnNext(price -> Logger.log(LogType.DO_ON_NEXT, "# 소비자 3: "+ price))
			.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 3: "+ price));
		subject.onNext(4000);

		subject.onComplete();

		subject.doOnNext(price -> Logger.log(LogType.DO_ON_NEXT, "# 소비자 4: "+ price))
			.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 4: "+ price));
	}
}
