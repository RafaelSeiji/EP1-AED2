package EP_01;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Main {
	public int cordenada_x;
	public int cordenada_y;
	public long frequentadores;
	public Main prox;
	static public Main inicio;
	static public Main ultimo;
	public int localx;
	public int localy;
	public int pessoas = 0;
	//public Main proxH;
	static public Main inicioH;
	static public Main ultimoH;
	public static void main(String[] args) {
		boolean flag = true;
		long check = -1;
		inicializarLista();
		inicializarListaH();
		String fileName = "OD_2017.csv";
		File file = new File(fileName);
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNext()) {
				String data =  sc.next();
				String[] valores = data.split(",");//2, 3, 43
				if(flag) {
					flag = false;
				}else {
					int x = Integer.parseInt(valores[2]);
					int y = Integer.parseInt(valores[3]);
					long f = Long.parseLong(valores[43]);
					if(check != f) {
						Main no = criarNo(x,y,f);
						addLista(no);
						//criarHistograma(x , y);
					}
					check = f;
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		printarLista();
	}
	static Main criarNo(int x, int y, long f) {
		Main novo = new Main();
		novo.cordenada_x = x;
		novo.cordenada_y = y;
		novo.frequentadores = f;
		novo.prox = null;
		return novo;
	}
	static void inicializarLista() {
		inicio=null;
	}
	static void addLista(Main no) {
		if(inicio == null) {
			inicio = no;
			ultimo = no;
		}else {
			ultimo.prox = no;
			ultimo = no;
			no.prox = null;
		}
	}
	static void printarNo(Main no) {
		System.out.print("x: "+no.cordenada_x+" ");
		System.out.print("y: "+no.cordenada_y+" ");
		System.out.println("f: "+no.frequentadores);
	}
	static void printarLista() {

		Main atual = inicio;
		while(atual.prox != null) {
			printarNo(atual);
			atual = atual.prox;
		}
	}
	static void criarHistograma(int x, int y) {
		Main noH = criarNoH(x, y);
		
	}
	static Main criarNoH(int x, int y) {
		Main novoH = new Main();
		novoH.localx = x;
		novoH.localy = y;
		//novoH.pessoas++;
		return novoH;
	}
	static void addListaH(Main no) {
		if(inicioH == null) {
			inicioH = no;
			ultimoH = no;
		}else {
			ultimoH.prox = no;
			ultimoH = no;
			no.prox = null;
		}
	}
	static void inicializarListaH() {
		inicioH = null;
	}
}