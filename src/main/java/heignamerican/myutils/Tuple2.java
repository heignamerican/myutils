package heignamerican.myutils;

public class Tuple2<T1, T2> {
	public static <_T1, _T2> Tuple2<_T1, _T2> create(final _T1 a1, final _T2 a2) {
		return new Tuple2<_T1, _T2>(a1, a2);
	}

	private final T1 mT1;
	private final T2 mT2;

	public Tuple2(final T1 aT1, final T2 aT2) {
		mT1 = aT1;
		mT2 = aT2;
	}

	public T1 get1() {
		return mT1;
	}

	public T2 get2() {
		return mT2;
	}
}
