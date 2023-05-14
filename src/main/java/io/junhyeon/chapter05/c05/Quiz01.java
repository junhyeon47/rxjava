package io.junhyeon.chapter05.c05;

import io.junhyeon.common.SampleData;
import io.junhyeon.utils.LogType;
import io.junhyeon.utils.Logger;
import io.reactivex.Observable;

public class Quiz01 {
	public static void main(String[] args) {
		Observable<Integer> observable1 = Observable.fromIterable(SampleData.salesOfBranchA);
		Observable<Integer> observable2 = Observable.fromIterable(SampleData.salesOfBranchB);
		Observable<Integer> observable3 = Observable.fromIterable(SampleData.salesOfBranchC);

		Observable.zip(observable1, observable2, observable3, (data1, data2, data3) -> data1 + data2 + data3)
			.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
	}
}
