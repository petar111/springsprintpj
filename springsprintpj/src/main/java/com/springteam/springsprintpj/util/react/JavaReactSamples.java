package com.springteam.springsprintpj.util.react;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Lists;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class JavaReactSamples {

	private JavaReactSamples() {
	}

	private static final JavaReactSamples _instance = new JavaReactSamples();

	public static JavaReactSamples getInstance() {
		return _instance;
	}
	
	public static void main(String[] args) {
//		JavaReactSamples.getInstance().showSimpleObserverExample();
//		JavaReactSamples.getInstance().showPeriodicObserverExample();
//		JavaReactSamples.getInstance().showSubjectExample();
		JavaReactSamples.getInstance().showExampleWithOperators();
	}

	public void showSubjectExample() {
		
		Observable<Long> producer = Observable.interval(1, TimeUnit.SECONDS);
		
		Subject<Long> subject = PublishSubject.create();
		
		producer.subscribe(subject);
		
		subject.subscribe(i -> System.out.println("Next integer: " + i));
		subject.subscribe(i -> System.out.println("Next integer*: " + i));
		
		while(true) {}
		
		
	}

	public void showSimpleObserverExample() {
		
		Observable<Integer> producer = Observable.fromArray(1, 2, 3, 4, 5);
		
		
		Observer<Integer> subscriber = new Observer<Integer>() {
			
			@Override
			public void onNext(Integer t) {
				System.out.println("Next integer: " + t);
			}
			
			@Override
			public void onError(Throwable t) {}
			
			@Override
			public void onComplete() {
				System.out.println("Sequence completed.");
			}

			@Override
			public void onSubscribe(@NonNull Disposable d) {}
		}; 
		
		producer.subscribe(subscriber);
		
	}
	
	public void showPeriodicObserverExample() {
		
		Observable<Long> producer = Observable.interval(1, TimeUnit.SECONDS);
		
		
		Observer<Long> subscriber = new Observer<Long>() {
			
			@Override
			public void onNext(Long t) {
				System.out.println("Next integer: " + t);
			}
			
			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void onComplete() {
				System.out.println("Sequence completed.");
			}

			@Override
			public void onSubscribe(@NonNull Disposable d) {
				// TODO Auto-generated method stub
			}
		}; 
		
		producer.subscribe(subscriber);
		
		while(true) {
			
		}
		
	}
	
	public void showExampleWithOperators() {
		List<Integer> items = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);
		
		Observable<Integer> producerA = Observable.fromArray(3, 6, 9);
		
		Observable<Integer> producer = Observable.just(items)
				.flatMap(list -> Observable.fromStream(items.stream()))
				.filter(i -> i % 3 == 0);
		
		
		Observable.zip(producer, producerA, (a, b) -> a + " " + b)
			.subscribe(
					new Observer<String>() {
						@Override
						public void onNext(String t) {
							System.out.println("Next string: " + t);
						}
						
						@Override
						public void onError(Throwable t) {
							// TODO Auto-generated method stub
						}
						
						@Override
						public void onComplete() {
							System.out.println("Sequence completed.");
						}

						@Override
						public void onSubscribe(@NonNull Disposable d) {
							// TODO Auto-generated method stub
						}
					});
	}

}
