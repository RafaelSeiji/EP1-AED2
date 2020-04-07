package EP_01;

public class Main {
    public static void main(String[] args) {
        String caminho = "C:\\Users\\gabri\\Desktop\\Faculdade\\AED2\\EPs\\EP1\\OD_2017.csv";
        Arquivo entrada = new Arquivo();
        entrada.extrair(caminho);
    }
}
