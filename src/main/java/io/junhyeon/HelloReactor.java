package io.junhyeon;

import reactor.core.publisher.Flux;

public class HelloReactor {
	public static void main(String[] args) {
		Flux<String> flux = Flux.just("Hello", "Reactor");
		flux.subscribe(data -> System.out.println(data));
	}
}
