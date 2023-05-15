package io.junhyeon.chapter06;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.subjects.PublishSubject;

public class PublishSubjectExample {
	public static void main(String[] args) {
		PublishSubject<Object> subject = PublishSubject.create();

		subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 1: "+ price));
		subject.onNext(3500);
		subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 2: "+ price));
		subject.onNext(3300);
		subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 3: "+ price));
		subject.onNext(3400);

		subject.subscribe(
			price -> Logger.log(LogType.ON_NEXT, "# 소비자 4: "+ price),
			error -> Logger.log(LogType.ON_ERROR, error),
			() -> Logger.log(LogType.ON_COMPLETE)
		);

		subject.onComplete();
	}
}
