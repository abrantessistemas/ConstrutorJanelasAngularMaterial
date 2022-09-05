package ConstrutorJanelasAngularMaterial;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        CriadorComponentes cc = new CriadorComponentes();
        ConstrutorTabelaFormulario construtorTabelaFormulario = new ConstrutorTabelaFormulario();

        if (!cc.criarComponente("angular-portal_v14", "areas")) {
            System.out.println("Nao foi possivel criar os componentes angular.");
        } else {
            System.out.println("Componentes angular criados com sucesso!");
            construtorTabelaFormulario.atualizarModulo("angular-portal_v14", "areas");
            construtorTabelaFormulario.construirMecanica(new File("model.txt"), "angular-portal_v14", "areas");
            construtorTabelaFormulario.construirHtml(new File("model.txt"), "angular-portal_v14", "areas");
            construtorTabelaFormulario.atualizarArquivoRota("angular-portal_v14", "areas");
        }
    }
}
