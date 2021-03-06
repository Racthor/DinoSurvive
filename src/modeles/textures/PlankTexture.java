package modeles.textures;

public class PlankTexture implements TexturesGenerator {

	@Override
	public float[] genTexture(float indiceTextX, float indiceTextY) {
		indiceTextX *= 0.03125f;

		indiceTextX = indiceTextX-(indiceTextX%0.001953125f);
		indiceTextY = (int)(indiceTextY * ((1 - 0) + 1))*0.03125f;

		return new float[]{
				//north
				0.34375f+indiceTextX, 0.28125f+indiceTextY,
				0.34375f+indiceTextX, 0.25f+indiceTextY,
				0.3125f+indiceTextX, 0.28125f+indiceTextY,
				0.3125f+indiceTextX, 0.28125f+indiceTextY,
				0.34375f+indiceTextX, 0.25f+indiceTextY,
				0.3125f+indiceTextX, 0.25f+indiceTextY,

				0.34375f+indiceTextX, 0.25f+indiceTextY,
				0.3125f+indiceTextX, 0.25f+indiceTextY,
				0.3125f+indiceTextX, 0.28125f+indiceTextY,
				0.34375f+indiceTextX, 0.25f+indiceTextY,
				0.3125f+indiceTextX, 0.28125f+indiceTextY,
				0.34375f+indiceTextX, 0.28125f+indiceTextY,

				//top
				0.34375f+indiceTextX, 0.28125f+indiceTextY,
				0.34375f+indiceTextX, 0.25f+indiceTextY,
				0.3125f+indiceTextX, 0.28125f+indiceTextY,
				0.3125f+indiceTextX, 0.28125f+indiceTextY,
				0.34375f+indiceTextX, 0.25f+indiceTextY,
				0.3125f+indiceTextX, 0.25f+indiceTextY,

				//bottom
				0.3125f+indiceTextX, 0.25f+indiceTextY,
				0.3125f+indiceTextX, 0.28125f+indiceTextY,
				0.34375f+indiceTextX, 0.25f+indiceTextY,
				0.34375f+indiceTextX, 0.25f+indiceTextY,
				0.3125f+indiceTextX, 0.28125f+indiceTextY,
				0.34375f+indiceTextX, 0.28125f+indiceTextY,

				0.34375f+indiceTextX, 0.28125f+indiceTextY,
				0.34375f+indiceTextX, 0.25f+indiceTextY,
				0.3125f+indiceTextX, 0.28125f+indiceTextY,
				0.3125f+indiceTextX, 0.28125f+indiceTextY,
				0.34375f+indiceTextX, 0.25f+indiceTextY,
				0.3125f+indiceTextX, 0.25f+indiceTextY,

				0.3125f+indiceTextX, 0.28125f+indiceTextY,
				0.34375f+indiceTextX, 0.25f+indiceTextY,
				0.3125f+indiceTextX, 0.25f+indiceTextY,
				0.34375f+indiceTextX, 0.28125f+indiceTextY,
				0.34375f+indiceTextX, 0.25f+indiceTextY,
				0.3125f+indiceTextX, 0.28125f+indiceTextY,


		};
	}

}
