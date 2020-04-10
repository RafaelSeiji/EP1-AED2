package EP_01;
import java.io.*;
import java.util.*;

public class Arquivo{


    protected Lista extrair(String caminho, int tipoGrafico){

        Lista lista = new Lista();

        String entrada = caminho;

        long check = -1;     // Verifica se existem linhas duplicadas
        lista.inicializarLista(lista);
        File file = new File(entrada);

        int v1;
        int v2;

        switch (tipoGrafico){
            case 1:
                 v1 = 2;
                 v2 = 3;
                break;
            case 2:
                 v1 = 57;
                 v2 = 58;
                break;
            case 3:
                 v1 = 62;
                 v2 = 63;
                break;
            case 4:
                 v1 = 71;
                 v2 = 72;
                break;
            default:
                v1 = -1;
                v2 = -1;
        }

        try{
            Scanner sc = new Scanner(file);
            sc.nextLine();  //Pula a primeira linha que contem os cabecalhos
            while(sc.hasNext()) {
                String data = sc.next();
                String[] valores = data.split(","); //Pegar as posições de acordo com o que o usuario escolheu
                int x = Integer.parseInt(valores[v1]);
                int y = Integer.parseInt(valores[v2]);
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