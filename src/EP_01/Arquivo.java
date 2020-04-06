package EP_01;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

protected class Arquivo{

    protected int localx;
    protected int localy;
    protected int pessoas = 0;

    private Lista lista = new Lista();

    protected void extrair{

        boolean flag = true;
        long check = -1;
        lista.inicializarLista();
        String fileName = "OD_2017.csv";
        File file = new File(fileName);

        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNext()){
                String data = sc.next();
                String[] valores = data.split(','); //Pegar as posições 2, 3 e 43
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