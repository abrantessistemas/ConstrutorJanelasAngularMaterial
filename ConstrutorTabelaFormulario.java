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
        private List<String> imports;

        public void atualizarModulo(String nomeProjeto, String nomeFormulario) {
                System.out.println("Iniciando atualizaçao do modulo da tabela do formulario.");
                imports = new ArrayList<>();
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
                                this.imports.add(
                                                "import { MatButtonToggleModule } from '@angular/material/button-toggle';");
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
                                                "import { " + nomeFormulario + "Component } from './"
                                                                + nomeFormulario.toLowerCase()
                                                                + ".component';");
                                this.imports.add(
                                                "import { " + nomeFormulario + "RoutingModule } from './"
                                                                + nomeFormulario.toLowerCase()
                                                                + "-routing.module';");
                                this.imports.add("");
                                this.imports.add("");

                                for (int i = 7; i < 13; i++) {
                                        this.imports.add(this.linhas.get(i));
                                }

                                this.imports.add("    BreadcrumbsModule,");
                                this.imports.add("    ContainerModule,");
                                this.imports.add("    FormsModule,");
                                this.imports.add("    IconModule,");
                                this.imports.add("    MatPaginatorModule,");
                                this.imports.add("    MatTableModule,");
                                this.imports.add("    MatSortModule,");
                                this.imports.add("    MatCheckboxModule,");
                                this.imports.add("    MatIconModule,");
                                this.imports.add("    MatButtonModule,");
                                this.imports.add("    MatMenuModule,");
                                this.imports.add("    MatTooltipModule,");
                                this.imports.add("    MatSelectModule,");
                                this.imports.add("    MatButtonToggleModule,");
                                this.imports.add("    MatSnackBarModule,");
                                this.imports.add("    PageLayoutModule,");
                                this.imports.add("    ReactiveFormsModule,");
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

                                System.out.println(
                                                "Atualizaçao do modulo da tabela do formulario finalizada com sucesso! :)");
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
        }

        public void atualizarArquivoRota(String nomeProjeto, String nomeFormulario) {
                System.out.println("Iniciando atualizaçao do modulo da tabela do formulario.");
                imports = new ArrayList<>();
                File arquivoModulo = new File(
                                nomeProjeto + "/src/app/pages/" + nomeFormulario + "/" + nomeFormulario
                                                + "-routing.module.ts");

                nomeFormulario = nomeFormulario.substring(0, 1).toUpperCase()
                                + nomeFormulario.substring(1, nomeFormulario.length());

                String importacaoFormulario = "import { "
                                + nomeFormulario + "Component } from './" + nomeFormulario.toLowerCase()
                                + ".component';";

                if (arquivoModulo.exists()) {
                        try {

                                this.imports.add("import { NgModule } from '@angular/core';");
                                this.imports.add("import { RouterModule } from '@angular/router';");
                                this.imports.add("import { QuicklinkModule } from 'ngx-quicklink';");
                                this.imports.add(
                                                "import { VexRoutes } from './../../../@vex/interfaces/vex-route.interface';");
                                this.imports.add(importacaoFormulario);
                                this.imports.add("");
                                this.imports.add("const routes: VexRoutes = [");
                                this.imports.add("  {");
                                this.imports.add("    path: '',");
                                this.imports.add("    component: " + nomeFormulario + "Component,");
                                this.imports.add("    data: {");
                                this.imports.add("      toolbarShadowEnabled: false");
                                this.imports.add("    }");
                                this.imports.add("  }");
                                this.imports.add("];");
                                this.imports.add("");
                                this.imports.add("@NgModule({");
                                this.imports.add("  imports: [RouterModule.forChild(routes)],");
                                this.imports.add("  exports: [RouterModule, QuicklinkModule]");
                                this.imports.add("})");
                                this.imports.add("export class " + nomeFormulario + "RoutingModule {}");

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

                                System.out.println(
                                                "Atualizaçao do modulo da tabela do formulario finalizada com sucesso! :)");
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
        }

        public void construirMecanica(File model, String nomeProjeto, String nomeFormulario) {
                System.out.println("Iniciando atualizacao do arquivo ts da tabela do formulario! :)");
                File arquivoComponentHtml = new File(
                                nomeProjeto.toLowerCase() + "/src/app/pages/" + nomeFormulario + "/" + nomeFormulario
                                                + ".component.ts");
                String nomeComponente = nomeFormulario.substring(0, 1).toUpperCase() + nomeFormulario.substring(1);
                String nomeComponenteSingular = "";
                String finalNomeComponente = nomeComponente.substring((nomeComponente.length() - 4),
                                nomeComponente.length());
                List<String> campos = new ArrayList<>();
                StringBuffer colunas = new StringBuffer();
                BufferedReader buffRead;

                if (finalNomeComponente.equals("coes")) {
                        finalNomeComponente = "cao";
                        nomeComponenteSingular = nomeComponente.substring(0, (nomeComponente.length() - 4));
                        nomeComponenteSingular += finalNomeComponente;
                } else {
                        if (finalNomeComponente.substring(3).equals("s")) {
                                nomeComponenteSingular = nomeComponente.substring(0, (nomeComponente.length() - 1));
                        }
                }

                if (model.exists()) {
                        try {
                                buffRead = new BufferedReader(new FileReader(model.getAbsolutePath()));

                                while (buffRead.ready()) {
                                        String campo = buffRead.readLine();
                                        campos.add(campo.trim());
                                }

                                colunas.append("  @Input()\n");
                                colunas.append("  columns: TableColumn<" + nomeComponenteSingular + "Model>[] = [\n");

                                campos.forEach(c -> {
                                        String cc[] = c.split(":");

                                        if (cc.length == 2) {
                                                StringBuilder linha = new StringBuilder("    { label: '");

                                                linha.append(cc[0]);
                                                linha.append("', property: '");
                                                linha.append(cc[0]);

                                                if (cc[1].equals(" boolean;")) {
                                                        linha.append("', type: 'checkbox', visible: false },\n");

                                                } else if (!cc[1].equals(" boolean;") && !cc[1].equals(" Date;")) {
                                                        linha.append("', type: 'text', visible: true },\n");

                                                } else if (cc[1].equals(" Date;")) {
                                                        linha.append("', type: 'date', visible: true },\n");

                                                }

                                                colunas.append(linha.toString());
                                        }
                                });

                                colunas.append("    { label: 'Actions', property: 'actions', type: 'button', visible: true }\n  ]");

                        } catch (IOException e) {
                                e.printStackTrace();
                        }

                }

                if (arquivoComponentHtml.exists()) {
                        try {
                                List<String> linhasArquivoTS = new ArrayList<>();
                                StringBuffer saida = new StringBuffer();

                                linhasArquivoTS.add("import { SelectionModel } from '@angular/cdk/collections';");
                                linhasArquivoTS
                                                .add("import { AfterViewInit, Component, Input, OnInit, ViewChild } from '@angular/core';");
                                linhasArquivoTS.add(
                                                "import { TableColumn } from '../../../@vex/interfaces/table-column.interface';");
                                linhasArquivoTS.add("import { UntypedFormControl } from '@angular/forms';");
                                linhasArquivoTS.add("import { MatDialog } from '@angular/material/dialog';");
                                linhasArquivoTS.add("import { MatSelectChange } from '@angular/material/select';");
                                linhasArquivoTS.add("import { MatPaginator } from '@angular/material/paginator';");
                                linhasArquivoTS.add("import { MatSort } from '@angular/material/sort';");
                                linhasArquivoTS.add("import { MatTableDataSource } from '@angular/material/table';");
                                linhasArquivoTS.add(
                                                "import { MatFormFieldDefaultOptions, MAT_FORM_FIELD_DEFAULT_OPTIONS } from '@angular/material/form-field';");
                                linhasArquivoTS.add("import { Observable, ReplaySubject } from 'rxjs';");
                                linhasArquivoTS.add(
                                                "import { PageableContractModel } from 'src/app/common/pageable-contract.model';");
                                linhasArquivoTS.add(
                                                "import { UntilDestroy, untilDestroyed } from '@ngneat/until-destroy';");
                                linhasArquivoTS.add("import { filter } from 'rxjs/operators';");
                                linhasArquivoTS.add("import icAdd from '@iconify/icons-ic/twotone-add';");
                                linhasArquivoTS.add("import icMoreHoriz from '@iconify/icons-ic/twotone-more-horiz';");
                                linhasArquivoTS.add("import icDelete from '@iconify/icons-ic/twotone-delete';");
                                linhasArquivoTS.add("import icEdit from '@iconify/icons-ic/twotone-edit';");
                                linhasArquivoTS.add(
                                                "import icFilterList from '@iconify/icons-ic/twotone-filter-list';");
                                linhasArquivoTS.add("import icSearch from '@iconify/icons-ic/twotone-search';");
                                linhasArquivoTS.add(
                                                "import { fadeInUp400ms } from '../../../@vex/animations/fade-in-up.animation';");
                                linhasArquivoTS.add(
                                                "import { stagger40ms } from '../../../@vex/animations/stagger.animation';");
                                linhasArquivoTS
                                                .add("import { " + nomeComponenteSingular
                                                                + "Model } from './../../models/"
                                                                + nomeComponente.toLowerCase() + "/"
                                                                + nomeComponenteSingular.toLowerCase() + ".model';");
                                linhasArquivoTS.add(
                                                "import { " + nomeComponenteSingular + "Service } from './../../models/"
                                                                + nomeComponente.toLowerCase() + "/"
                                                                + nomeComponenteSingular.toLowerCase() + ".service';");
                                linhasArquivoTS.add("import { " + nomeComponente + "CreateUpdateComponent } from './"
                                                + nomeComponente.toLowerCase() + "-create-update/"
                                                + nomeComponente.toLowerCase()
                                                + "-create-update.component';");
                                linhasArquivoTS.add("");
                                linhasArquivoTS.add("");
                                linhasArquivoTS.add("@UntilDestroy()");
                                linhasArquivoTS.add("@Component({");
                                linhasArquivoTS.add("  selector: 'vex-" + nomeComponente.toLowerCase() + "',");
                                linhasArquivoTS.add("  templateUrl: './" + nomeComponente.toLowerCase()
                                                + ".component.html',");
                                linhasArquivoTS.add("  styleUrls: ['./" + nomeComponente.toLowerCase()
                                                + ".component.scss'],");
                                linhasArquivoTS.add("  animations: [");
                                linhasArquivoTS.add("    fadeInUp400ms,");
                                linhasArquivoTS.add("    stagger40ms");
                                linhasArquivoTS.add("  ],");
                                linhasArquivoTS.add("  providers: [");
                                linhasArquivoTS.add("    {");
                                linhasArquivoTS.add("      provide: MAT_FORM_FIELD_DEFAULT_OPTIONS,");
                                linhasArquivoTS.add("      useValue: {");
                                linhasArquivoTS.add("        appearance: 'standard'");
                                linhasArquivoTS.add("      } as MatFormFieldDefaultOptions");
                                linhasArquivoTS.add("    }");
                                linhasArquivoTS.add("  ]");
                                linhasArquivoTS.add("})");
                                linhasArquivoTS.add("export class " + nomeComponente
                                                + "Component implements OnInit, AfterViewInit {");
                                linhasArquivoTS.add("  layoutCtrl = new UntypedFormControl('boxed');");
                                linhasArquivoTS
                                                .add("  subject$: ReplaySubject<" + nomeComponenteSingular
                                                                + "Model[]> = new ReplaySubject<"
                                                                + nomeComponenteSingular + "Model[]>(1);");
                                linhasArquivoTS
                                                .add("  data$: Observable<" + nomeComponenteSingular
                                                                + "Model[]> = this.subject$.asObservable();");
                                linhasArquivoTS.add("  " + nomeComponente.toLowerCase() + ": " + nomeComponenteSingular
                                                + "Model[];");
                                linhasArquivoTS.add("");
                                linhasArquivoTS.add("  " + colunas.toString());
                                linhasArquivoTS.add("  pageSize = 10;");
                                linhasArquivoTS.add("  pageSizeOptions: number[] = [5, 10, 20, 50];");
                                linhasArquivoTS.add("  dataSource: MatTableDataSource<" + nomeComponenteSingular
                                                + "Model> | null;");
                                linhasArquivoTS.add("  selection = new SelectionModel<" + nomeComponenteSingular
                                                + "Model>(true, []);");
                                linhasArquivoTS.add("  searchCtrl = new UntypedFormControl;");
                                linhasArquivoTS.add("");
                                linhasArquivoTS.add("  icDelete = icDelete;");
                                linhasArquivoTS.add("  icSearch = icSearch;");
                                linhasArquivoTS.add("  icFilterList = icFilterList;");
                                linhasArquivoTS.add("  icMoreHoriz = icMoreHoriz;");
                                linhasArquivoTS.add("  icAdd = icAdd;");
                                linhasArquivoTS.add("  icEdit = icEdit;");
                                linhasArquivoTS.add("");
                                linhasArquivoTS.add(
                                                "  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;");
                                linhasArquivoTS.add("  @ViewChild(MatSort, { static: true }) sort: MatSort;");
                                linhasArquivoTS
                                                .add("  constructor(private dialog: MatDialog, private "
                                                                + nomeComponenteSingular.toLowerCase()
                                                                + "Service: " + nomeComponenteSingular + "Service) {}");
                                linhasArquivoTS.add("");
                                linhasArquivoTS.add("  get visibleColumns() {");
                                linhasArquivoTS.add(
                                                "    return this.columns.filter(column => column.visible).map(column => column.property);");
                                linhasArquivoTS.add("  }");
                                linhasArquivoTS.add("");
                                linhasArquivoTS.add("  /**");
                                linhasArquivoTS.add(
                                                "   * Example on how to get data and pass it to the table - usually you would want a dedicated service with a HTTP request for this");
                                linhasArquivoTS.add("   * We are simulating this request here.");
                                linhasArquivoTS.add("   */");
                                linhasArquivoTS.add("  getData() {");
                                linhasArquivoTS
                                                .add("    this." + nomeComponenteSingular.toLowerCase()
                                                                + "Service.count().subscribe(total => {");
                                linhasArquivoTS.add(
                                                "      this." + nomeComponenteSingular.toLowerCase()
                                                                + "Service.findAll" + nomeComponente
                                                                + "(1, total).subscribe((result: PageableContractModel<"
                                                                + nomeComponenteSingular + "Model[]>) => {");
                                linhasArquivoTS.add("        this.subject$.next(result.data);");
                                linhasArquivoTS.add("      })");
                                linhasArquivoTS.add("    })");
                                linhasArquivoTS.add("    return this." + nomeComponente.toLowerCase() + ";");
                                linhasArquivoTS.add("  }");
                                linhasArquivoTS.add("");
                                linhasArquivoTS.add("  ngOnInit() {");
                                linhasArquivoTS.add("    this.getData();");
                                linhasArquivoTS.add("");
                                linhasArquivoTS.add("    this.dataSource = new MatTableDataSource();");
                                linhasArquivoTS.add("");
                                linhasArquivoTS.add("    this.data$.pipe(filter<" + nomeComponenteSingular
                                                + "Model[]>(Boolean)");
                                linhasArquivoTS.add("    ).subscribe(" + nomeComponente.toLowerCase() + " => {");
                                linhasArquivoTS
                                                .add("      this." + nomeComponente.toLowerCase() + " = "
                                                                + nomeComponente.toLowerCase() + ";");
                                linhasArquivoTS.add(
                                                "      this.dataSource.data = " + nomeComponente.toLowerCase() + ";");
                                linhasArquivoTS.add("    });");
                                linhasArquivoTS.add("");
                                linhasArquivoTS.add("    this.searchCtrl.valueChanges.pipe(");
                                linhasArquivoTS.add("      untilDestroyed(this)");
                                linhasArquivoTS.add("    ).subscribe(value => this.onFilterChange(value));");
                                linhasArquivoTS.add("  }");
                                linhasArquivoTS.add("");
                                linhasArquivoTS.add("  ngAfterViewInit() {");
                                linhasArquivoTS.add("    this.dataSource.paginator = this.paginator;");
                                linhasArquivoTS.add("    this.dataSource.sort = this.sort;");
                                linhasArquivoTS.add("  }");
                                linhasArquivoTS.add("");
                                linhasArquivoTS.add("  create" + nomeComponenteSingular + "() {");
                                linhasArquivoTS.add(
                                                "    this.dialog.open(" + nomeComponente
                                                                + "CreateUpdateComponent).afterClosed().subscribe(("
                                                                + nomeComponenteSingular.toLowerCase()
                                                                + ": " + nomeComponenteSingular + "Model) => {");
                                linhasArquivoTS.add("      /**");
                                linhasArquivoTS.add(
                                                "       * " + nomeComponenteSingular + " is the updated "
                                                                + nomeComponenteSingular.toLowerCase()
                                                                + " (if the user pressed Save - otherwise it's null)");
                                linhasArquivoTS.add("       */");
                                linhasArquivoTS.add("      if (" + nomeComponenteSingular.toLowerCase() + ") {");
                                linhasArquivoTS.add("        /**");
                                linhasArquivoTS.add("         * Here we are updating our local array.");
                                linhasArquivoTS.add("         * You would probably make an HTTP request here.");
                                linhasArquivoTS.add("         */");
                                linhasArquivoTS.add("        this." + nomeComponente.toLowerCase() + ".unshift("
                                                + nomeComponenteSingular.toLowerCase() + ");");
                                linhasArquivoTS.add("        this.subject$.next(this." + nomeComponente.toLowerCase()
                                                + ");");
                                linhasArquivoTS.add("      }");
                                linhasArquivoTS.add("    });");
                                linhasArquivoTS.add("  }");
                                linhasArquivoTS.add("");
                                linhasArquivoTS
                                                .add("  update" + nomeComponenteSingular + "("
                                                                + nomeComponenteSingular.toLowerCase() + ": "
                                                                + nomeComponenteSingular + "Model) {");
                                linhasArquivoTS.add(
                                                "    this.dialog.open(" + nomeComponente + "CreateUpdateComponent, {");
                                linhasArquivoTS.add("      data: " + nomeComponenteSingular.toLowerCase() + "");
                                linhasArquivoTS.add("    }).afterClosed().subscribe(updated" + nomeComponenteSingular
                                                + " => {");
                                linhasArquivoTS.add("      /**");
                                linhasArquivoTS.add(
                                                "       * " + nomeComponenteSingular
                                                                + " is the updated "
                                                                + nomeComponenteSingular.toLowerCase()
                                                                + " (if the user pressed Save - otherwise it's null)");
                                linhasArquivoTS.add("       */");
                                linhasArquivoTS.add("      if (updated" + nomeComponenteSingular + ") {");
                                linhasArquivoTS.add("        /**");
                                linhasArquivoTS.add("         * Here we are updating our local array.");
                                linhasArquivoTS.add("         * You would probably make an HTTP request here.");
                                linhasArquivoTS.add("         */");
                                linhasArquivoTS.add(
                                                "        const index = this." + nomeComponente.toLowerCase()
                                                                + ".findIndex((existing" + nomeComponenteSingular
                                                                + ") => existing"
                                                                + nomeComponenteSingular + ".uuid"
                                                                + " === updated" + nomeComponenteSingular + ".uuid);");
                                linhasArquivoTS.add(
                                                "        this." + nomeComponente.toLowerCase() + "[index] = updated"
                                                                + nomeComponenteSingular
                                                                + ";");
                                linhasArquivoTS.add("        this.subject$.next(this." + nomeComponente.toLowerCase()
                                                + ");");
                                linhasArquivoTS.add("      }");
                                linhasArquivoTS.add("    });");
                                linhasArquivoTS.add("  }");
                                linhasArquivoTS.add("");
                                linhasArquivoTS
                                                .add("  delete" + nomeComponenteSingular + "("
                                                                + nomeComponenteSingular.toLowerCase() + ": "
                                                                + nomeComponenteSingular + "Model) {");
                                linhasArquivoTS.add("    /**");
                                linhasArquivoTS.add("     * Here we are updating our local array.");
                                linhasArquivoTS.add("     * You would probably make an HTTP request here.");
                                linhasArquivoTS.add("     */");
                                linhasArquivoTS.add(
                                                "    this." + nomeComponente.toLowerCase() + ".splice(this."
                                                                + nomeComponente.toLowerCase()
                                                                + ".findIndex((existing" + nomeComponenteSingular
                                                                + ") => existing"
                                                                + nomeComponenteSingular + ".uuid === "
                                                                + nomeComponenteSingular.toLowerCase()
                                                                + ".uuid), 1);");
                                linhasArquivoTS.add("    this.selection.deselect("
                                                + nomeComponenteSingular.toLowerCase() + ");");
                                linhasArquivoTS.add(
                                                "    this.subject$.next(this." + nomeComponente.toLowerCase() + ");");
                                linhasArquivoTS.add("  }");
                                linhasArquivoTS.add("");
                                linhasArquivoTS.add(
                                                "  deleteSelected" + nomeComponente + "(" + nomeComponente.toLowerCase()
                                                                + ": " + nomeComponenteSingular + "Model[]) {");
                                linhasArquivoTS.add("    /**");
                                linhasArquivoTS.add("     * Here we are updating our local array.");
                                linhasArquivoTS.add("     * You would probably make an HTTP request here.");
                                linhasArquivoTS.add("     */");
                                linhasArquivoTS.add(
                                                "    " + nomeComponente.toLowerCase() + ".forEach(c => this.delete"
                                                                + nomeComponenteSingular
                                                                + "(c));");
                                linhasArquivoTS.add("  }");
                                linhasArquivoTS.add("");
                                linhasArquivoTS.add("  onFilterChange(value: string) {");
                                linhasArquivoTS.add("    if (!this.dataSource) {");
                                linhasArquivoTS.add("      return;");
                                linhasArquivoTS.add("    }");
                                linhasArquivoTS.add("    value = value.trim();");
                                linhasArquivoTS.add("    value = value.toLowerCase();");
                                linhasArquivoTS.add("    this.dataSource.filter = value;");
                                linhasArquivoTS.add("  }");
                                linhasArquivoTS.add("");
                                linhasArquivoTS.add("  toggleColumnVisibility(column, event) {");
                                linhasArquivoTS.add("    event.stopPropagation();");
                                linhasArquivoTS.add("    event.stopImmediatePropagation();");
                                linhasArquivoTS.add("    column.visible = !column.visible;");
                                linhasArquivoTS.add("  }");
                                linhasArquivoTS.add("");
                                linhasArquivoTS
                                                .add("  /** Whether the number of selected elements matches the total number of rows. */");
                                linhasArquivoTS.add("  isAllSelected() {");
                                linhasArquivoTS.add("    const numSelected = this.selection.selected.length;");
                                linhasArquivoTS.add("    const numRows = this.dataSource.data.length;");
                                linhasArquivoTS.add("    return numSelected === numRows;");
                                linhasArquivoTS.add("  }");
                                linhasArquivoTS.add("");
                                linhasArquivoTS
                                                .add("  /** Selects all rows if they are not all selected; otherwise clear selection. */");
                                linhasArquivoTS.add("  masterToggle() {");
                                linhasArquivoTS.add("    this.isAllSelected() ?");
                                linhasArquivoTS.add("      this.selection.clear() :");
                                linhasArquivoTS.add(
                                                "      this.dataSource.data.forEach(row => this.selection.select(row));");
                                linhasArquivoTS.add("  }");
                                linhasArquivoTS.add("");
                                linhasArquivoTS.add("  trackByProperty<T>(index: number, column: TableColumn<T>) {");
                                linhasArquivoTS.add("    return column.property;");
                                linhasArquivoTS.add("  }");
                                linhasArquivoTS.add("");
                                linhasArquivoTS
                                                .add("  onLabelChange(change: MatSelectChange, row: "
                                                                + nomeComponenteSingular + "Model) {");
                                linhasArquivoTS
                                                .add("    const index = this." + nomeComponente.toLowerCase()
                                                                + ".findIndex(c => c === row);");
                                linhasArquivoTS.add(
                                                "    this." + nomeComponente.toLowerCase() + "[index] = change.value;");
                                linhasArquivoTS.add(
                                                "    this.subject$.next(this." + nomeComponente.toLowerCase() + ");");
                                linhasArquivoTS.add("  }");
                                linhasArquivoTS.add("}");
                                linhasArquivoTS.add("");

                                System.out.println(saida.toString());

                                FileWriter fw = new FileWriter(arquivoComponentHtml);
                                BufferedWriter bw = new BufferedWriter(fw);

                                try {
                                        for (String linha : linhasArquivoTS) {
                                                bw.write(linha + "\n");
                                        }
                                } catch (IOException e) {
                                        e.printStackTrace();
                                }

                                bw.close();
                                fw.close();

                                System.out.println(
                                                "Atualizaçao do arquivo ts da tabela do formulario, realizada com sucesso! :)");

                        } catch (IOException e) {
                                e.printStackTrace();
                        }

                }
        }

        public void construirHtml(File model, String nomeProjeto, String nomeFormulario) {
                System.out.println("Iniciando atualizacao do arquivo html da lista de registros! :)");
                String nomeComponenteHtml = nomeFormulario.substring(0, 1).toUpperCase() + nomeFormulario.substring(1);
                String nomeComponenteSingular = "";

                File arquivoComponentHtml = new File(
                                nomeProjeto.toLowerCase() + "/src/app/pages/" + nomeComponenteHtml.toLowerCase() + "/"
                                                + nomeComponenteHtml.toLowerCase() + ".component.html");

                List<String> campos = new ArrayList<>();

                String finalString = nomeComponenteHtml.substring((nomeComponenteHtml.length() - 4),
                                nomeComponenteHtml.length());

                if (finalString.equals("coes")) {
                        finalString = "cao";
                        nomeComponenteSingular = nomeComponenteHtml.substring(0, (nomeComponenteHtml.length() - 4));
                        nomeComponenteSingular += finalString;
                } else {
                        if (finalString.substring(3).equals("s")) {
                                nomeComponenteSingular = nomeComponenteHtml.substring(0,
                                                (nomeComponenteHtml.length() - 1));
                        }
                }

                if (model.exists()) {
                        try {
                                BufferedReader buffRead = new BufferedReader(new FileReader(model.getAbsolutePath()));
                                List<String> linhasArquivoHtml = new ArrayList<>();

                                linhasArquivoHtml.add("<vex-page-layout>");
                                linhasArquivoHtml.add("");
                                linhasArquivoHtml
                                                .add("  <vex-page-layout-header class=\"pb-16 flex flex-col items-start justify-center\">");
                                linhasArquivoHtml.add(
                                                "    <div [class.container]=\"layoutCtrl.value === 'boxed'\" [class.px-gutter]=\"layoutCtrl.value === 'fullwidth'\"");
                                linhasArquivoHtml.add(
                                                "      class=\"w-full flex flex-col sm:flex-row justify-between\">");
                                linhasArquivoHtml.add("      <div>");
                                linhasArquivoHtml
                                                .add("        <h1 class=\"title mt-0 mb-1\">Cadastros de "
                                                                + nomeComponenteHtml + "</h1>");
                                linhasArquivoHtml
                                                .add("        <vex-breadcrumbs [crumbs]=\"['Acesso', '"
                                                                + nomeComponenteHtml
                                                                + "']\"></vex-breadcrumbs>");
                                linhasArquivoHtml.add("      </div>");
                                linhasArquivoHtml.add("");
                                linhasArquivoHtml.add("      <div class=\"hidden sm:block\">");
                                linhasArquivoHtml
                                                .add("        <mat-button-toggle-group [formControl]=\"layoutCtrl\" class=\"mt-4 sm:mt-0\">");
                                linhasArquivoHtml.add(
                                                "          <mat-button-toggle value=\"boxed\">Boxed</mat-button-toggle>");
                                linhasArquivoHtml
                                                .add("          <mat-button-toggle value=\"fullwidth\">Full-Width</mat-button-toggle>");
                                linhasArquivoHtml.add("        </mat-button-toggle-group>");
                                linhasArquivoHtml.add("      </div>");
                                linhasArquivoHtml.add("    </div>");
                                linhasArquivoHtml.add("  </vex-page-layout-header>");
                                linhasArquivoHtml.add("");
                                linhasArquivoHtml.add(
                                                "  <vex-page-layout-content [class.container]=\"layoutCtrl.value === 'boxed'\"");
                                linhasArquivoHtml.add(
                                                "    [class.px-gutter]=\"layoutCtrl.value === 'fullwidth'\" class=\"-mt-6\">");
                                linhasArquivoHtml.add("");
                                linhasArquivoHtml.add("    <div class=\"card overflow-auto -mt-16\">");
                                linhasArquivoHtml
                                                .add("      <div class=\"bg-app-bar px-6 h-16 border-b sticky left-0 flex items-center\">");
                                linhasArquivoHtml.add(
                                                "        <h2 class=\"title my-0 ltr:pr-4 rtl:pl-4 ltr:mr-4 rtl:ml-4 ltr:border-r rtl:border-l hidden sm:block flex-none\">");

                                linhasArquivoHtml
                                                .add("          <span *ngIf=\"selection.isEmpty()\">"
                                                                + nomeComponenteSingular + "</span>");
                                linhasArquivoHtml.add(
                                                "          <span *ngIf=\"selection.hasValue()\">{{ selection.selected.length }}");
                                linhasArquivoHtml.add("            " + nomeComponenteSingular
                                                + "<span *ngIf=\"selection.selected.length > 1\">s</span> selected</span>");
                                linhasArquivoHtml.add("        </h2>");
                                linhasArquivoHtml.add("");
                                linhasArquivoHtml
                                                .add("        <div *ngIf=\"selection.hasValue()\" class=\"mr-4 pr-4 border-r flex-none\">");
                                linhasArquivoHtml
                                                .add("          <button (click)=\"deleteSelected"
                                                                + nomeComponenteHtml
                                                                + "(selection.selected)\" color=\"primary\" mat-icon-button");
                                linhasArquivoHtml.add(
                                                "            matTooltip=\"Deletar registro selecionado.\" type=\"button\">");
                                linhasArquivoHtml.add("            <mat-icon [icIcon]=\"icDelete\"></mat-icon>");
                                linhasArquivoHtml.add("          </button>");
                                linhasArquivoHtml.add("        </div>");
                                linhasArquivoHtml.add("");
                                linhasArquivoHtml.add(
                                                "        <div class=\"bg-foreground rounded-full border px-4 max-w-[400px] flex-auto flex items-center\">");
                                linhasArquivoHtml.add(
                                                "          <ic-icon [icIcon]=\"icSearch\" size=\"20px\"></ic-icon>");
                                linhasArquivoHtml.add(
                                                "          <input [formControl]=\"searchCtrl\" class=\"px-4 py-3 border-0 outline-none w-full bg-transparent\"");
                                linhasArquivoHtml.add("            placeholder=\"Procurar...\" type=\"search\">");
                                linhasArquivoHtml.add("        </div>");
                                linhasArquivoHtml.add("");
                                linhasArquivoHtml.add("        <span class=\"flex-1\"></span>");
                                linhasArquivoHtml.add("");
                                linhasArquivoHtml.add(
                                                "        <button [matMenuTriggerFor]=\"columnFilterMenu\" class=\"ml-4 flex-none\" mat-icon-button");
                                linhasArquivoHtml.add("          matTooltip=\"Filtrar registros\" type=\"button\">");
                                linhasArquivoHtml.add("          <mat-icon [icIcon]=\"icFilterList\"></mat-icon>");
                                linhasArquivoHtml.add("        </button>");
                                linhasArquivoHtml.add("");
                                linhasArquivoHtml.add(
                                                "        <button (click)=\"create" + nomeComponenteSingular
                                                                + "()\" class=\"ml-4 flex-none\" color=\"primary\" mat-mini-fab");
                                linhasArquivoHtml.add(
                                                "             matTooltip=\"Adicionar novo " + nomeComponenteSingular
                                                                + "\" type=\"button\">");
                                linhasArquivoHtml.add("          <mat-icon [icIcon]=\"icAdd\"></mat-icon>");
                                linhasArquivoHtml.add("        </button>");
                                linhasArquivoHtml.add("      </div>");
                                linhasArquivoHtml.add("");

                                // campos
                                while (buffRead.ready()) {
                                        String campo = buffRead.readLine();
                                        campos.add(campo.trim());
                                }

                                StringBuffer tabela = new StringBuffer(
                                                "      <table @stagger [dataSource]=\"dataSource\" class=\"w-full\" mat-table matSort>\n");
                                tabela.append("");

                                campos.forEach(c -> {
                                        String cc[] = c.split(":");

                                        if (cc.length == 2) {
                                                if (cc[1].equals(" boolean;")) {
                                                        tabela.append("        <!-- " + cc[0] + " Column -->\n");
                                                        tabela.append("        <ng-container matColumnDef=\"" + cc[0]
                                                                        + "\">\n");
                                                        tabela.append("          <th *matHeaderCellDef mat-header-cell>\n");
                                                        tabela.append("            <mat-checkbox (change)=\"$event ? masterToggle() : null\" [checked]=\"selection.hasValue() && isAllSelected()\"\n");
                                                        tabela.append("              [indeterminate]=\"selection.hasValue() && !isAllSelected()\" color=\"primary\">\n");
                                                        tabela.append("            </mat-checkbox>\n");
                                                        tabela.append("          </th>\n");
                                                        tabela.append("          <td *matCellDef=\"let row\" class=\"w-4\" mat-cell>\n");
                                                        tabela.append("            <mat-checkbox (change)=\"$event ? selection.toggle(row) : null\" (click)=\"$event.stopPropagation()\"\n");
                                                        tabela.append("              [checked]=\"selection.isSelected(row)\" color=\"primary\">\n");
                                                        tabela.append("            </mat-checkbox>\n");
                                                        tabela.append("          </td>\n");
                                                        tabela.append("        </ng-container>\n");
                                                        tabela.append("\n");

                                                } else if (cc[1].equals(" Date;")) {
                                                        tabela.append("        <!-- " + cc[0] + " Column -->\n");
                                                        tabela.append("        <ng-container matColumnDef=\"" + cc[0]
                                                                        + "\">\n");
                                                        tabela.append("          <th *matHeaderCellDef mat-header-cell mat-sort-header> "
                                                                        + cc[0].toUpperCase() + " </th>\n");
                                                        tabela.append("          <td *matCellDef=\"let row\" mat-cell>{{ row."
                                                                        + cc[0] + " | date:\"dd/MM/yyyy\" }}</td>\n");
                                                        tabela.append("        </ng-container>\n");
                                                        tabela.append("\n");

                                                }
                                        }
                                });

                                tabela.append("        <!-- Text Columns -->\n");
                                tabela.append("        <ng-container *ngFor=\"let column of columns; trackBy: trackByProperty\">\n");
                                tabela.append("          <ng-container *ngIf=\"column.type === 'text'\" [matColumnDef]=\"column.property\">\n");
                                tabela.append("            <th *matHeaderCellDef class=\"uppercase\" mat-header-cell mat-sort-header> {{ column.label }}</th>\n");
                                tabela.append("            <td *matCellDef=\"let row\" [ngClass]=\"column.cssClasses\" mat-cell>{{ row[column.property] }}</td>\n");
                                tabela.append("          </ng-container>\n");
                                tabela.append("        </ng-container>\n");
                                tabela.append("\n");

                                tabela.append("        <!-- Action Column -->\n");
                                tabela.append("        <ng-container matColumnDef=\"actions\">\n");
                                tabela.append("          <th *matHeaderCellDef mat-header-cell mat-sort-header></th>\n");
                                tabela.append("          <td *matCellDef=\"let row\" class=\"w-10 text-secondary\" mat-cell>\n");
                                tabela.append("            <button (click)=\"$event.stopPropagation()\" [matMenuTriggerData]=\"{ "
                                                + nomeComponenteSingular.toLowerCase()
                                                + ": row }\" [matMenuTriggerFor]=\"actionsMenu\" mat-icon-button type=\"button\">\n");
                                tabela.append("              <mat-icon [icIcon]=\"icMoreHoriz\"></mat-icon>\n");
                                tabela.append("            </button>\n");
                                tabela.append("          </td>\n");
                                tabela.append("        </ng-container>\n");
                                tabela.append("\n");
                                tabela.append("        <tr *matHeaderRowDef=\"visibleColumns\" mat-header-row></tr>\n");
                                tabela.append("        <tr (click)=\"update" + nomeComponenteSingular
                                                + "(row)\" *matRowDef=\"let row; columns: visibleColumns;\" @fadeInUp");
                                tabela.append("          class=\"hover:bg-hover trans-ease-out cursor-pointer\" mat-row></tr>\n");
                                tabela.append("      </table>");

                                linhasArquivoHtml.add(tabela.toString());

                                linhasArquivoHtml.add("");
                                linhasArquivoHtml.add(
                                                "      <mat-paginator [pageSizeOptions]=\"pageSizeOptions\" [pageSize]=\"pageSize\" class=\"sticky left-0\"></mat-paginator>");
                                linhasArquivoHtml.add("    </div>");
                                linhasArquivoHtml.add("");
                                linhasArquivoHtml.add("  </vex-page-layout-content>");
                                linhasArquivoHtml.add("");
                                linhasArquivoHtml.add("</vex-page-layout>");
                                linhasArquivoHtml.add("");
                                linhasArquivoHtml
                                                .add("<mat-menu #columnFilterMenu=\"matMenu\" xPosition=\"before\" yPosition=\"below\">");
                                linhasArquivoHtml.add(
                                                "  <button (click)=\"toggleColumnVisibility(column, $event)\" *ngFor=\"let column of columns\"");
                                linhasArquivoHtml.add("    class=\"checkbox-item mat-menu-item\">");
                                linhasArquivoHtml.add(
                                                "    <mat-checkbox (click)=\"$event.stopPropagation()\" [(ngModel)]=\"column.visible\" color=\"primary\">");
                                linhasArquivoHtml.add("      {{ column.label }}");
                                linhasArquivoHtml.add("    </mat-checkbox>");
                                linhasArquivoHtml.add("  </button>");
                                linhasArquivoHtml.add("</mat-menu>");
                                linhasArquivoHtml.add("");
                                linhasArquivoHtml.add(
                                                "<mat-menu #actionsMenu=\"matMenu\" xPosition=\"before\" yPosition=\"below\">");
                                linhasArquivoHtml
                                                .add("  <ng-template let-" + nomeComponenteSingular + "=\""
                                                                + nomeComponenteSingular
                                                                + "\" matMenuContent>");
                                linhasArquivoHtml.add(
                                                "    <button (click)=\"update" + nomeComponenteSingular + "("
                                                                + nomeComponenteSingular
                                                                + ")\" mat-menu-item>");
                                linhasArquivoHtml.add("      <mat-icon [icIcon]=\"icEdit\"></mat-icon>");
                                linhasArquivoHtml.add("      <span>Modificar</span>");
                                linhasArquivoHtml.add("    </button>");
                                linhasArquivoHtml
                                                .add("    <button (click)=\"delete" + nomeComponenteSingular + "("
                                                                + nomeComponenteSingular
                                                                + ")\" mat-menu-item>");
                                linhasArquivoHtml.add("      <mat-icon [icIcon]=\"icDelete\"></mat-icon>");
                                linhasArquivoHtml.add("      <span>Deletar</span>");
                                linhasArquivoHtml.add("    </button>");
                                linhasArquivoHtml.add("  </ng-template>");
                                linhasArquivoHtml.add("</mat-menu>");

                                FileWriter fw = new FileWriter(arquivoComponentHtml);
                                BufferedWriter bw = new BufferedWriter(fw);

                                linhasArquivoHtml.forEach(linha -> {
                                        try {
                                                bw.write(linha + "\n");
                                        } catch (IOException e) {
                                                e.printStackTrace();
                                        }
                                });
                                bw.close();
                                fw.close();

                                System.out.println(
                                                "Atualizaçao do arquivo html da lista de registros, realizada com sucesso! :)");
                                // construirMecanica(model, nomeProjeto, projeto);
                        } catch (IOException e) {
                                e.printStackTrace();
                        }

                }
        }

}
