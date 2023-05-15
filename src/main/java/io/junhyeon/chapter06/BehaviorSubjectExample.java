package io.junhyeon.chapter06;

import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.subjects.BehaviorSubject;

public class BehaviorSubjectExample {
	public static void main(String[] args) {
		BehaviorSubject<Integer> subject = BehaviorSubject.createDefault(3000);

		subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 1: "+ price));
		subject.onNext(3500);

		subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 2: "+ price));
		subject.onNext(3300);

		subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 3: "+ price));
		subject.onNext(3400);
	}
}
