package core;

public class Matrix3f {
	public float matrix[][] = new float[3][3];
	
	public static final Matrix3f IDENTITY = initIdentity();
	
	
	public Matrix3f(){
		
	}
	
	private static Matrix3f initIdentity(){
		Matrix3f m = new Matrix3f();
		m.matrix[0][0] = 1;		m.matrix[1][0] = 0;		m.matrix[2][0] = 0;
		m.matrix[0][1] = 0;		m.matrix[1][1] = 1;		m.matrix[2][1] = 0;
		m.matrix[0][2] = 0;		m.matrix[1][2] = 0;		m.matrix[2][2] = 1;
		return m;
	}
	
	public Matrix3f mul(Matrix3f right){
		Matrix3f ret = new Matrix3f();
		for (int i = 0; i < 3; i++) { // aRow
			for (int j = 0; j < 3; j++) { // bColumn
				for (int k = 0; k < 3; k++) { // aColumn
					ret.matrix[i][j] = matrix[i][k] * right.matrix[k][j];
				}
			}
		}
		return ret;
	}
	
	public static Matrix3f createRotation(float rot){
		Matrix3f m = new Matrix3f();
		m.matrix[0][0] = (float)Math.cos((float)rot);		m.matrix[1][0] = -(float)Math.sin((float)rot);		m.matrix[2][0] = 0;
		m.matrix[0][1] = (float)Math.sin((float)rot);		m.matrix[1][1] = (float)Math.cos((float)rot);		m.matrix[2][1] = 0;
		m.matrix[0][2] = 0;									m.matrix[1][2] = 0;									m.matrix[2][2] = 1;
		return m;
	}
	
	public static Matrix3f createScale(Vector2f scale){
		Matrix3f m = new Matrix3f();
		m.matrix[0][0] = scale.getx();		m.matrix[1][0] = 0;					m.matrix[2][0] = 0;
		m.matrix[0][1] = 0;					m.matrix[1][1] = scale.gety();		m.matrix[2][1] = 0;
		m.matrix[0][2] = 0;					m.matrix[1][2] = 0;					m.matrix[2][2] = 1;
		return m;
	}
	
	public static Matrix3f createTranslation(Vector2f translation){
		Matrix3f m = new Matrix3f();
		m.matrix[0][0] = 0;		m.matrix[1][0] = 0;		m.matrix[2][0] = translation.getx();
		m.matrix[0][1] = 0;		m.matrix[1][1] = 0;		m.matrix[2][1] = translation.gety();
		m.matrix[0][2] = 0;		m.matrix[1][2] = 0;		m.matrix[2][2] = 1;
		return m;
	}
	
	public Vector2f getTranslation(){
		return new Vector2f(matrix[2][0], matrix[2][1]);
	}
}
