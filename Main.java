package ConstrutorJanelasAngularMaterial;

public class Main {
    public static void main(String[] args) {
        CriadorComponentes cc = new CriadorComponentes();
        if (!cc.criarComponente("angular-portal_v14", "areas")) {
            System.out.println("Nao foi possivel criar os componentes angular.");
        } else {
            System.out.println("Componentes angular criados com sucesso!");

        }
    }
}
