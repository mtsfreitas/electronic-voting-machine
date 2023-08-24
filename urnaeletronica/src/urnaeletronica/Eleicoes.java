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
public class Eleicoes {
     public static void main(String[] args) {
        Eleitor eleitor1, eleitor2, eleitor3;
        Candidato candidato1, candidato2, candidato3;
        Mesario mesario;
        UrnaEletronica urna_eletronica;
        
        eleitor1 = new Eleitor("Pafuncio Figueiredo", 150);
        eleitor2 = new Eleitor("Nirosmar Francisco", 300);
        eleitor3 = new Eleitor("Antenor Albuquerque", 500);
        
        candidato1 = new Candidato("Jair Lula da Silva", "PT", 13);
        candidato2 = new Candidato("Cleiton Rastha", "DEM", 35);
        candidato3 = new Candidato("Aecio Nove", "PSDB", 17);
        
        mesario = new Mesario("081");
        mesario.inicializarUrna();
        urna_eletronica = mesario.getUrna_eletronica();
        urna_eletronica.inserirEleitor(eleitor1);
        urna_eletronica.inserirEleitor(eleitor2);
        urna_eletronica.inserirEleitor(eleitor3);
        urna_eletronica.inserirCandidato(candidato1);
        urna_eletronica.inserirCandidato(candidato2);
        urna_eletronica.inserirCandidato(candidato3);
        
        mesario.autorizarEleitor(eleitor1);
        mesario.autorizarEleitor(eleitor2);
        mesario.autorizarEleitor(eleitor3);
        
        eleitor1.votar(urna_eletronica, Voto.NULO);
        eleitor2.votar(urna_eletronica, 13);
        eleitor3.votar(urna_eletronica, 51);
        
        mesario.gerarRelatorioUrna();
     }
}
