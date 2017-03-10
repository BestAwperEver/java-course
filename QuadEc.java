import java.util.Vector;

public class QuadEc {
	float _a, _b, _c;
	public QuadEc(float a, float b, float c) {
		_a = a;
		_b = b;
		_c = c;
	}
	public QuadEc(float x1, float x2) {
		_a = 1;
		_b = - x1 - x2;
		_c = x1 * x1;
	}
	public Vector<Float> roots() {
		float D = _b*_b - 4*_a*_c;
		if (D < 0) {
			return null;
		}
		Vector<Float> v = new Vector<Float>(2);
		v.addElement((float) ((-_b/2 - Math.sqrt(D))/2/_a));
		v.addElement((float) ((-_b/2 + Math.sqrt(D))/2/_a));
		return v;
	}
	public float extr() {
		return -_b*_b/4/_a + _c;
	}
	public Vector<Pair<Float, Float>> intervals() {
		Vector<Pair<Float, Float>> v = new Vector<Pair<Float, Float>>(2);
		v.add(new Pair<Float, Float>(Float.NEGATIVE_INFINITY, (float) (-_b/2/_a)));
		v.add(new Pair<Float, Float>((float) (-_b/2/_a), Float.POSITIVE_INFINITY));
		return v;
	}
}
