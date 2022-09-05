package ConstrutorJanelasAngularMaterial;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CriadorComponentes {
    private File arquivoComponente;
    private List<String> comandos = new ArrayList<>();
    private ProcessBuilder builder;
    private Process processo;
    private BufferedReader bufferReader;
    private String linhaLida;

    public boolean criarComponente(String nomeProjeto, String nomeFormulario) {
        boolean concluidoComSucesso = false;

        while (nomeProjeto.isEmpty() || nomeFormulario.isEmpty()) {
            return concluidoComSucesso;
        }

        System.out.println("Criando componentes angular com nome "
                + nomeFormulario.toLowerCase()
                + " no projeto " + nomeProjeto.toUpperCase() + " Aguarde ...");

        File arquivoAngular = new File(nomeProjeto + "/angular.json");

        if (arquivoAngular.exists()) {
            System.out.println("Projeto encontrado com sucesso! criaçao de componentes em andamento!");
            arquivoAngular = new File(nomeProjeto + "/src/app/pages/" + nomeFormulario.toLowerCase());

            if (!arquivoAngular.exists()) {
                this.comandos.add("cd " + nomeProjeto + "/src/app/pages/");
                this.comandos.add("ng g m " + nomeFormulario + " --routing");

                if (!nomeFormulario.isEmpty()) {
                    this.comandos.add("ng g c " + nomeFormulario);
                    arquivoComponente = new File(nomeFormulario.toLowerCase() + "-create-update");

                    if (!arquivoComponente.exists()) {
                        this.comandos
                                .add("ng g m " + nomeFormulario + "/" + nomeFormulario.toLowerCase()
                                        + "-create-update");
                        this.comandos
                                .add("ng g c " + nomeFormulario + "/" + nomeFormulario.toLowerCase()
                                        + "-create-update");
                    }

                    this.comandos.add("cd " + nomeFormulario + "/");
                    String cmds[] = new String[this.comandos.size()];

                    for (int i = 0; i < this.comandos.size(); i++) {
                        cmds[i] = this.comandos.get(i);
                    }

                    try {
                        this.builder = new ProcessBuilder("cmd", "/c", String.join("& ", cmds));
                        builder.redirectErrorStream(true);
                        this.processo = builder.start();
                        this.bufferReader = new BufferedReader(new InputStreamReader(processo.getInputStream()));

                        while (true) {
                            linhaLida = bufferReader.readLine();
                            if (linhaLida == null) {
                                break;
                            }
                        }

                        concluidoComSucesso = true;
                    } catch (Exception e) {
                        System.err.println("Erro inesperado. " + e);
                    }
                }
            }

        } else {
            System.out.println(
                    "Projeto angular nao foi encontrado, verifique o nome do projeto,\nou se o mesmo encontra-se "
                            + "no diretorio de execuçao do contrutor de janelas angular material.");
        }
        return concluidoComSucesso;
    }

}
