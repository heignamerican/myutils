package heignamerican.myutils.collection;

public interface Converter<TFrom, TTo> {
	public TTo convert(TFrom aFrom) throws ConvertException;
}
