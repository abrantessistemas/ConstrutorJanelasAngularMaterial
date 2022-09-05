package ConstrutorJanelasAngularMaterial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConstrutorTabelaFormulario {
    private BufferedReader buffRead;
    private List<String> linhas = new ArrayList<>();
    private List<String> imports = new ArrayList<>();

    public void atualizarModuloTabelaDados(String nomeProjeto, String nomeFormulario) {
        System.out.println("Iniciando atualizaçao do modulo da tabela do formulario.");
        File arquivoModulo = new File(
                nomeProjeto + "/src/app/pages/" + nomeFormulario + "/" + nomeFormulario + ".module.ts");

        nomeFormulario = nomeFormulario.substring(0, 1).toUpperCase()
                + nomeFormulario.substring(1, nomeFormulario.length());

        String importacaoFormulario = "import { "
                + nomeFormulario + "CreateUpdateModule } from './" + nomeFormulario.toLowerCase()
                + "-create-update/" + nomeFormulario.toLowerCase() + "-create-update.module';";

        if (arquivoModulo.exists()) {
            try {
                this.buffRead = new BufferedReader(new FileReader(arquivoModulo.getAbsolutePath()));

                while (this.buffRead.ready()) {
                    String linha = this.buffRead.readLine();
                    this.linhas.add(linha);
                }

                this.imports.add("import { NgModule } from '@angular/core';");
                this.imports.add("import { CommonModule } from '@angular/common';");
                this.imports.add("import { FormsModule, ReactiveFormsModule } from '@angular/forms';");
                this.imports.add("import { MatButtonModule } from '@angular/material/button';");
                this.imports.add("import { MatButtonToggleModule } from '@angular/material/button-toggle';");
                this.imports.add("import { MatCheckboxModule } from '@angular/material/checkbox';");
                this.imports.add("import { MatIconModule } from '@angular/material/icon';");
                this.imports.add("import { MatMenuModule } from '@angular/material/menu';");
                this.imports.add("import { MatPaginatorModule } from '@angular/material/paginator';");
                this.imports.add("import { MatSelectModule } from '@angular/material/select';");
                this.imports.add("import { MatSnackBarModule } from '@angular/material/snack-bar';");
                this.imports.add("import { MatSortModule } from '@angular/material/sort';");
                this.imports.add("import { MatTableModule } from '@angular/material/table';");
                this.imports.add("import { MatTooltipModule } from '@angular/material/tooltip';");
                this.imports.add("import { IconModule } from '@visurel/iconify-angular';");
                this.imports.add(
                        "import { BreadcrumbsModule } from '../../../@vex/components/breadcrumbs/breadcrumbs.module';");
                this.imports.add(
                        "import { PageLayoutModule } from '../../../@vex/components/page-layout/page-layout.module';");
                this.imports
                        .add("import { ContainerModule } from '../../../@vex/directives/container/container.module';");
                this.imports.add(importacaoFormulario);
                this.imports.add(
                        "import { " + nomeFormulario + "Component } from './" + nomeFormulario.toLowerCase()
                                + ".component';");
                this.imports.add(
                        "import { " + nomeFormulario + "RoutingModule } from './" + nomeFormulario.toLowerCase()
                                + "-routing.module';");
                this.imports.add("");
                this.imports.add("");

                for (int i = 7; i < 13; i++) {
                    this.imports.add(this.linhas.get(i));
                }

                this.imports.add("    PageLayoutModule,");
                this.imports.add("    BreadcrumbsModule,");
                this.imports.add("    MatPaginatorModule,");
                this.imports.add("    MatTableModule,");
                this.imports.add("    MatSortModule,");
                this.imports.add("    MatCheckboxModule,");
                this.imports.add("    MatIconModule,");
                this.imports.add("    MatButtonModule,");
                this.imports.add("    MatMenuModule,");
                this.imports.add("    IconModule,");
                this.imports.add("    FormsModule,");
                this.imports.add("    MatTooltipModule,");
                this.imports.add("    ReactiveFormsModule,");
                this.imports.add("    ContainerModule,");
                this.imports.add("    MatSelectModule,");
                this.imports.add("    MatButtonToggleModule,");
                this.imports.add("    MatSnackBarModule,");
                this.imports.add("    MatTooltipModule,");
                this.imports.add("    " + nomeFormulario + "CreateUpdateModule,");

                for (int i = 13; i < 17; i++) {
                    this.imports.add(this.linhas.get(i));
                }

                FileWriter fw = new FileWriter(arquivoModulo);
                BufferedWriter bw = new BufferedWriter(fw);

                this.imports.forEach(linha -> {
                    try {
                        bw.write(linha + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                bw.close();
                fw.close();

                System.out.println("Atualizaçao do modulo da tabela do formulario finalizada com sucesso! :)");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
