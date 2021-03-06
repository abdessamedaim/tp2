package main;


// Matrice d'adjacence en java

public class Graphe {
	
	private boolean matriceAdj[][];
	private int noeuds ;

	public Graphe(int noeuds) {
		this.noeuds  = noeuds;
		matriceAdj = new boolean[noeuds][noeuds];
	}

	// ajout d'arêtes entre deux noeuds
	public void ajoutArete(int i, int j) {
		matriceAdj[i-1][j-1] = true;
		matriceAdj[j-1][i-1] = true;
	}
	
	// ajout d'arêtes entre une liste des noeuds
	public void ajoutAretes(int[] nodes) {
		for(int i = 0; i < nodes.length; i++) {
			for(int j = 0; j < nodes.length; j++) {
				if(i != j) {
					matriceAdj[nodes[i]-1][nodes[j]-1] = true;
					matriceAdj[nodes[j]-1][nodes[i]-1] = true;
				}
			}
		}
	}
	
	public boolean adjacent(int i, int j) {
		return matriceAdj[i][j];
	}

	// print matrice
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("    ");
		for(int i = 0; i < noeuds; i++) {
			int k = i + 1;
			String ks = k +"";
			s.append(i < 9 ? "0" + ks : ks );
			s.append(" ");
		}
		s.append("\n");
		for (int i = 0; i < noeuds ; i++) {
			if(i < 9) s.append("0");
			s.append(i+1 + ":  ");
			for (int j = 0; j < matriceAdj[i].length; j++) {
				boolean bool = matriceAdj[i][j];
				int b = bool ? 1 : 0;
//				String bs = "0" + b;
//				s.append(bs + " ");
				s.append(b+"  ");
			}
			s.append("\n");
		}
		return s.toString();
	}
}
