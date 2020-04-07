package EP_01;
import java.util.*;
public class Lista{

    protected No inicio;
    protected No ultimo;


    static No criarNo(int x, int y, long f){
        No novo = new No();
        novo.coordenada_x = x;
        novo.coordenada_y = y;
        novo.frequentadores = f;
        novo.prox = null;
        return novo;
    }

    static void inicializarLista(Lista lista){
        lista.inicio = null;
        lista.ultimo = null;
    }

    static void addLista(Lista lista, No no){
        if(lista.inicio == null){
            lista.inicio = no;
            lista.ultimo = no;
        }
        else{
            lista.ultimo.prox = no;
            lista.ultimo = no;
            no.prox = null;
        }
    }

    static void printarNo(No no){
        System.out.print("x: "+no.coordenada_x+" ");
        System.out.print("y: "+no.coordenada_y+" ");
        System.out.println("f: "+no.frequentadores);
    }

    static void printarLista(Lista lista){
        No atual = lista.inicio;
        while(atual.prox != null){
            printarNo(atual);
            atual = atual.prox;
        }
    }
}