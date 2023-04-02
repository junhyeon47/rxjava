package io.junhyeon.chapter03.c01;

import reactor.core.publisher.Flux;

public class ColdPublisherReactor {
	public static void main(String[] args) {
		Flux<Integer> flux = Flux.just(1,3,5,7);

		flux.subscribe(data -> System.out.println("구독자1: " + data));
		flux.subscribe(data -> System.out.println("구독자2: " + data));
	}
}
