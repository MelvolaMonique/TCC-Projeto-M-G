package br.com.etec.mogi.TCCprojeto.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "usuariopermissao")
public class Usuariopermissao {

    @ManyToOne
    @JoinColumn (name = "idusuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn (name = "idpermissao")
    private Permissao permissao;



}
