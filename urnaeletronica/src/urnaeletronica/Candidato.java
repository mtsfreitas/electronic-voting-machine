/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urnaeletronica;

/**
 *
 * @author Freitas
 */
public class Candidato {
    
    private String nome;
    private String partido;
    private int numero_votacao;

    public Candidato(){
        
    }
    
    public Candidato(String nome, String partido, int numero_votacao){
        this.nome = nome;
        this.partido = partido;
        this.numero_votacao = numero_votacao;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public int getNumero_votacao() {
        return numero_votacao;
    }

    public void setNumero_votacao(int numero_votacao) {
        this.numero_votacao = numero_votacao;
    }
    
    //Compara dois candidatos para ver se o candidato é o mesmo que candidato_2.
     
    public boolean comparaCandidatos(Candidato candidato_2){
        return (this.numero_votacao == candidato_2.numero_votacao);
    }
    
}
