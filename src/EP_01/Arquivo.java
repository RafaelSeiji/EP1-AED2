package EP_01;
import java.io.*;
import java.util.*;

public class Arquivo{


    protected Lista extrair(String caminho){

        Lista lista = new Lista();

        String entrada = caminho;

        long check = -1;     // Verifica se existem linhas duplicadas
        lista.inicializarLista(lista);
        File file = new File(entrada);

        try{
            Scanner sc = new Scanner(file);
            sc.nextLine();  //Pula a primeira linha que contem os cabecalhos
            while(sc.hasNext()) {
                String data = sc.next();
                String[] valores = data.split(","); //Pegar as posições 2, 3 e 43
                int x = Integer.parseInt(valores[2]);
                int y = Integer.parseInt(valores[3]);
                Float f = Float.parseFloat(valores[43]);
                if(lista.existeCoord(lista,x,y) == false){
                    No no = new No();
                    no = lista.criarNo(x,y,f);
                    lista.addLista(lista, no);
                }
                else{
                    No aux = lista.returnNo(lista,x,y);
                    if(lista.existeID(aux,f) == false){
                        aux.frequentadores.add(f);
                    }
                }
            }
            sc.close();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        lista.printarLista(lista);
        return lista;
    }
}