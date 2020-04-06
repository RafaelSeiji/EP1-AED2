package EP_01;
import java.util.*;
public class Lista{

    protected int coordenada_x;
    protected int coordenada_y;
    protected long frequentadores;
    protected Lista prox;
    static protected Lista inicio;
    static protected Lista ultimo;



    static Lista criarNo(int x, int y, long f){
        Lista novo = new Lista();
        novo.coordenada_x = x;
        novo.coordenada_y = y;
        novo.frequentadores = f;
        novo.prox = null;
        return novo;
    }

    static void inicializarLista(){
        inicio = null;
    }

    static void addLista(Lista no){
        if(inicio == null){
            inicio = no;
            ultimo = no;
        }
        else{
            ultimo.prox = no;
            no.prox = null;
        }
    }

    static void printarNo(Lista no){
        System.out.print("x: "+no.coordenada_x+" ");
        System.out.print("y: "+no.coordenada_y+" ");
        System.out.println("f: "+no.frequentadores);
    }

    static void printarLista(){
        Lista atual = inicio;
        while(atual.prox != null){
            printarNo(atual);
            atual = atual.prox;
        }
    }
}