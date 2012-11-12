package heignamerican.myutils;

public interface Callback<T> {
	public <_T extends T> void notify(_T aT);
}
