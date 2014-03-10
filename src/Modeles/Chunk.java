package Modeles;

import java.util.Vector;

import org.lwjgl.util.vector.Vector3f;

import Controleur.Controleur;
import Modeles.entities.*;

public class Chunk {
	private Cube3dVbo[][][] cubes;
	private Vector<Cube3dVbo> renderCubes;
	private Controleur clone;
	private int x,y,z,id;

	//constructeur d'un chunk, poss�de des cubes et des vecteurs de cubes ˆ dŽssinŽ
	public Chunk(int x,int y,int z, int id, Controleur contr){
		cubes = new Cube3dVbo[16][16][16];
		renderCubes = new Vector<Cube3dVbo>();
		clone = contr;

		this.x = x;
		this.y = y;
		this.z = z;
		//pour l'instant : id = ligne dans le programme, changer ça !!! (extrapoler l'iD des XYZ)
		this.id = id;
	}
	
	//getter de cube dans le chunk
	public Cube3dVbo getCubeInChunk(int i, int j, int k){
		return cubes[i][j][k];		
		
	}

	//boucle qui ajoute tout les cube liŽ ˆ l'ID du chunk (aka la ligne dans le programme)
	public void addCubes(){
		clone.getMapRead().setCubes(cubes, id);
	}

	//vérife quels cubes sont actife ou non (visible ou non) et les met dans la liste de rendue
	public void checkState(){
		clearChunk();
		for(int i=0; i<16; i++){
			for(int j =0; j<16; j++){
				for(int k=0; k<16; k++){
					if(cubes[i][j][k]!=null){
						if(cubes[i][j][k].getState()){
							renderCubes.add(cubes[i][j][k]);
						}
					}
				}
			}
		}
	}


	//génère les cubes dans le buffer;
	//DOIT ETRE ASSOCIER A UNE METHODE DE RESET DES BUFFER !!
	public void genCubes(){
		for(Cube3dVbo cube : renderCubes){
			cube.genCube();
		}
	}

	//dessine tous les cubes actifs
	public void draw(TextureManager texMan){
		checkState();
		for(Cube3dVbo cube : renderCubes){
			cube.bindBuffers();
			
			texMan.genText(cube.getType());
			texMan.bindBuffer();
			
			cube.bindDrawCube();
			texMan.bindDrawTexture();
			
			cube.enableCube();
			texMan.enableTexture();
			
			cube.draw();
			
			texMan.disableTexture();
			cube.disableCube();
		}
	}

	//vide la liste de rendus
	public void clearChunk(){
		renderCubes.clear();
	}

	//getter de la liste des cubes
	public Cube3D[][][] getArrayCubes(){
		return cubes;
	}
	
	public void bindBuffers(){
		for(int i=0; i<16; i++){
			for(int j =0; j<16; j++){
				for(int k=0; k<16; k++){
					if(cubes[i][j][k]!=null){
						//cubes[i][j][k].bindBuffers();
					}
				}
			}
		}
	}
	
	//ajout de cube dans le chunk
	public void addCube3dVbo(Cube3dVbo cube){
		//il faut vérifier que le cube peut être dans ce chunk là
		//on fera ça après, ajoutons sauvagement un cube
		cubes[cube.getX()][cube.getY()][cube.getZ()] = cube;		
	}
	
	//génération d'un arbre à une position donnée (cube de départ du tronc)
	//utilisation d'un random pour déterminer la taille de l'arbre
	//génère un arbre moche (mais fonctionnel)
	public void genTree(float x, float y, float z, float size){
		//arbre d'une taille comprise entre 3 et 6 cubes de tronc
		//wouhou aléatoire !
		int taille = (int)((6-3)*Math.random()) +3;
		//size des cubes pour le moment 1
		for (int i = 0; i<taille; ++i){
			//à chaque itération il crée un cube de type tronc (11, cf TextureManager)
			Cube3dVbo tronc = new Cube3dVbo(x, y+i, z, size, 11);
			//il l'ajoute dans le cube
			addCube3dVbo(tronc);
			//création de feuilles (12 cf TextureManager)
			//schéma différent entre les différents niveaux de feuilles
			if (i==2){
				//feuilles en croix sur le premier niveau
				Cube3dVbo feuilles = new Cube3dVbo(x-1, y+i, z, size, 12);
				Cube3dVbo feuilles2 = new Cube3dVbo(x+1, y+i, z, size, 12);
				Cube3dVbo feuilles3 = new Cube3dVbo(x, y+i, z+1, size, 12);
				Cube3dVbo feuilles4 = new Cube3dVbo(x, y+i, z-1, size, 12);
				addCube3dVbo(feuilles);
				addCube3dVbo(feuilles2);
				addCube3dVbo(feuilles3);
				addCube3dVbo(feuilles4);
			}
			else if (i>2){
				//feuilles partout
				Cube3dVbo feuilles = new Cube3dVbo(x-1, y+i, z, size, 12);
				Cube3dVbo feuilles2 = new Cube3dVbo(x+1, y+i, z, size, 12);
				Cube3dVbo feuilles3 = new Cube3dVbo(x, y+i, z+1, size, 12);
				Cube3dVbo feuilles4 = new Cube3dVbo(x, y+i, z-1, size, 12);
				Cube3dVbo feuilles5 = new Cube3dVbo(x-1, y+i, z-1, size, 12);
				Cube3dVbo feuilles6 = new Cube3dVbo(x+1, y+i, z+1, size, 12);
				Cube3dVbo feuilles7 = new Cube3dVbo(x-1, y+i, z+1, size, 12);
				Cube3dVbo feuilles8 = new Cube3dVbo(x+1, y+i, z-1, size, 12);
				addCube3dVbo(feuilles);
				addCube3dVbo(feuilles2);
				addCube3dVbo(feuilles3);
				addCube3dVbo(feuilles4);
				addCube3dVbo(feuilles5);
				addCube3dVbo(feuilles6);
				addCube3dVbo(feuilles7);
				addCube3dVbo(feuilles8);				
			}
		}
		// à la fin de la génération de l'arbre, on génère une couche de feuilles au dessus
		Cube3dVbo feuilles = new Cube3dVbo(x-1, y+taille, z, size, 12);
		Cube3dVbo feuilles2 = new Cube3dVbo(x, y+taille, z, size, 12);
		Cube3dVbo feuilles3 = new Cube3dVbo(x-1, y+taille, z-1, size, 12);
		Cube3dVbo feuilles4 = new Cube3dVbo(x-1, y+taille, z+1, size, 12);
		Cube3dVbo feuilles5 = new Cube3dVbo(x+1, y+taille, z, size, 12);
		Cube3dVbo feuilles6 = new Cube3dVbo(x+1, y+taille, z-1, size, 12);
		Cube3dVbo feuilles7 = new Cube3dVbo(x+1, y+taille, z+1, size, 12);
		Cube3dVbo feuilles8 = new Cube3dVbo(x, y+taille, z+1, size, 12);
		Cube3dVbo feuilles9 = new Cube3dVbo(x, y+taille, z-1, size, 12);
		addCube3dVbo(feuilles);
		addCube3dVbo(feuilles2);
		addCube3dVbo(feuilles3);
		addCube3dVbo(feuilles4);
		addCube3dVbo(feuilles5);
		addCube3dVbo(feuilles6);
		addCube3dVbo(feuilles7);
		addCube3dVbo(feuilles8);
		addCube3dVbo(feuilles9);
		
	}

}