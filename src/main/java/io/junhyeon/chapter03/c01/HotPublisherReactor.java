package io.junhyeon.chapter03.c01;

import io.reactivex.processors.MulticastProcessor;

public class HotPublisherReactor {
	public static void main(String[] args) {
		MulticastProcessor<Integer> processor = MulticastProcessor.create();
		processor.start();
		processor.subscribe(data -> System.out.println("구독자1: " + data));
		processor.onNext(1);
		processor.onNext(3);

		processor.subscribe(data -> System.out.println("구독자2: " + data));
		processor.onNext(5);
		processor.onNext(7);

		processor.onComplete();
	}
}
