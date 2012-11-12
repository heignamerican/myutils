package heignamerican.myutils.collection;

public abstract class ConverterBase<TFrom, TTo> implements Converter<TFrom, TTo> {
	@Override
	public TTo convert(TFrom aFrom) throws ConvertException {
		try {
			return convertReal(aFrom);
		} catch (Exception aCause) {
			throw new ConvertException(aCause);
		}
	}

	protected abstract TTo convertReal(TFrom aFrom) throws Exception;
}
