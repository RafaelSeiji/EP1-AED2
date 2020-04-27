package EP_01;
import java.util.*;
public class Lista{

    protected No inicio;
    protected No ultimo;


    static No criarNo(int x, int y, Float ID){
        No novo = new No();
        novo.coordenada_x = x;
        novo.coordenada_y = y;
        novo.frequentadores.add(ID);
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

    static boolean existeCoord(Lista lista, int coord_x, int coord_y){
        if(lista.inicio == null) return false;
        No aux = lista.inicio;
        do{
            if(aux.coordenada_x == coord_x && aux.coordenada_y == coord_y) return true;
            aux = aux.prox;
        }while (aux != null);

        return false;
    }

    static No returnNo(Lista lista, int coord_x, int coord_y){
        No aux = lista.inicio;
        do{
            if(aux.coordenada_x == coord_x && aux.coordenada_y == coord_y) return aux;
            aux = aux.prox;
        }while (aux != null);
        return null;
    }

    static boolean existeID(No no, Float ID){
        if(no.frequentadores.contains(ID)) return true;
        else return false;
    }

    static void printarNo(No no){
        System.out.print("x: "+no.coordenada_x+" ");
        System.out.print("y: "+no.coordenada_y+" ");
        for(int i = 0; i < no.frequentadores.size(); i++){
            System.out.println("f: "+no.frequentadores.get(i));
        }
    }

    static void printarLista(Lista lista){
        No atual = lista.inicio;
        while(atual.prox != null){
            printarNo(atual);
            atual = atual.prox;
        }
    }

    static Lista contarCasos(Lista lista){
        Lista output = new Lista();
        No aux = lista.inicio;
        while(aux != null){
            int cont = (aux.frequentadores.size()-1);
            No retorno = new No();
            retorno = criarNo(aux.coordenada_x,aux.coordenada_y,(float) cont);
            addLista(output,retorno);
            aux = aux.prox;
        }
        return output;
    }

    static HashMap<Integer, Integer> contarLocal(Lista lista){
        HashMap<Integer,Integer> list = new HashMap();
        No percorre = lista.inicio;
        int casos = Math.round(percorre.frequentadores.get(0));
        list.put(casos,1);
        percorre = percorre.prox;
        while(percorre != null){
            casos = Math.round(percorre.frequentadores.get(0));
            if(list.containsKey(casos)){
                int old = list.get(casos);
                list.put(casos,old+1);
            }
            else{
                list.put(casos,1);
            }
            percorre = percorre.prox;
        }
        return list;
    }
}