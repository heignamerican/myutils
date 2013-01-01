package heignamerican.myutils.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionUtil {
	public static <TFrom, TTo, CollectionTo extends Collection<TTo>> CollectionTo mapping(TFrom[] aInput, Converter<TFrom, TTo> aConverter) throws ConvertException {
		@SuppressWarnings("unchecked")
		CollectionTo tTo = (CollectionTo) new ArrayList<TTo>();
		return mapping(aInput, tTo, aConverter);
	}

	public static <TFrom, TTo, CollectionTo extends Collection<TTo>> CollectionTo mapping(Collection<TFrom> aInput, Converter<TFrom, TTo> aConverter) throws ConvertException {
		try {
			@SuppressWarnings("unchecked")
			CollectionTo tTo = (CollectionTo) aInput.getClass().newInstance();

			return mapping(aInput, tTo, aConverter);
		} catch (Exception aCause) {
			throw new RuntimeException(aCause);
		}
	}

	static <TFrom, TTo, CollectionTo extends Collection<TTo>> CollectionTo mapping(TFrom[] aInput, CollectionTo aResult, Converter<TFrom, TTo> aConverter) throws ConvertException {
		for (TFrom tFrom : aInput) {
			aResult.add(aConverter.convert(tFrom));
		}
		return aResult;
	}

	static <TFrom, TTo, CollectionTo extends Collection<TTo>> CollectionTo mapping(Collection<TFrom> aInput, CollectionTo aResult, Converter<TFrom, TTo> aConverter) throws ConvertException {
		for (TFrom tFrom : aInput) {
			aResult.add(aConverter.convert(tFrom));
		}
		return aResult;
	}

	public static <T, CollectionType extends Collection<T>> CollectionType select(Collection<T> aSource, Filter<T> aFilter) {
		try {
			@SuppressWarnings("unchecked")
			CollectionType tNewInstance = (CollectionType) aSource.getClass().newInstance();
			for (T tT : aSource) {
				if (aFilter.accept(tT))
					tNewInstance.add(tT);
			}
			return tNewInstance;
		} catch (Exception aCause) {
			throw new RuntimeException(aCause);
		}
	}

	public static <T, TCollection extends Collection<? super T>> TCollection copy(Collection<? extends T> aSource, TCollection aTarget) {
		aTarget.addAll(aSource);
		return aTarget;
	}
}
