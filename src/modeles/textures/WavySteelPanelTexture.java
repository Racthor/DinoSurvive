package modeles.textures;

public class WavySteelPanelTexture implements TexturesGenerator {

	@Override
	public float[] genTexture(float indiceTextX, float indiceTextY) {
		return new float[]{
				//north
				0.28125f, 0.1875f,
				0.28125f, 0.15625f,
				0.25f, 0.1875f,
				0.25f, 0.1875f,
				0.28125f, 0.15625f,
				0.25f, 0.15625f,

				0.28125f, 0.15625f,
				0.25f, 0.15625f,
				0.25f, 0.1875f,
				0.28125f, 0.15625f,
				0.25f, 0.1875f,
				0.28125f, 0.1875f,

				//top
				0.28125f, 0.1875f,
				0.28125f, 0.15625f,
				0.25f, 0.1875f,
				0.25f, 0.1875f,
				0.28125f, 0.15625f,
				0.25f, 0.15625f,

				//bottom
				0.25f, 0.15625f,
				0.25f, 0.1875f,
				0.28125f, 0.15625f,
				0.28125f, 0.15625f,
				0.25f, 0.1875f,
				0.28125f, 0.1875f,

				0.28125f, 0.1875f,
				0.28125f, 0.15625f,
				0.25f, 0.1875f,
				0.25f, 0.1875f,
				0.28125f, 0.15625f,
				0.25f, 0.15625f,

				0.25f, 0.1875f,
				0.28125f, 0.15625f,
				0.25f, 0.15625f,
				0.28125f, 0.1875f,
				0.28125f, 0.15625f,
				0.25f, 0.1875f
		};
	}

}
