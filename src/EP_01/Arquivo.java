package EP_01;
import java.io.*;
import java.util.*;

public class Arquivo{

    protected int localx;
    protected int localy;
    protected int pessoas = 0;

    private Lista lista = new Lista();

    protected void extrair(){

        Scanner in = new Scanner(System.in);
        String entrada = in.nextLine();
        
        boolean flag = true;
        long check = -1;
        lista.inicializarLista();
        File file = new File(entrada);

        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNext()){
                String data = sc.next();
                String[] valores = data.split(","); //Pegar as posições 2, 3 e 43
                if(flag) flag = false;
                else{
                    int x = Integer.parseInt(valores[2]);
                    int y = Integer.parseInt(valores[3]);
                    long f = Long.parseLong(valores[43]);
                    if(check != f){
                        Lista no = new Lista();
                        no = lista.criarNo(x,y,f);
                        lista.addLista(no);
                    }
                    check = f;
                }
            }
            sc.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        lista.printarLista();
    }
}