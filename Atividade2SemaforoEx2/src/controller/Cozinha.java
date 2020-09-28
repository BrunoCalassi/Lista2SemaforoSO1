/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.concurrent.Semaphore;

/**
 *
 * @author bruno
 */
public class Cozinha extends Thread {
    private int id;
    private double cozimento=0;
    private int porcentagem;
    private String nome;
    private Semaphore semaforo;

    public Cozinha(int id, Semaphore semaforo) {
        this.id = id;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
         try {
            Cozinhar();
            semaforo.acquire();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
          
            Entregar();
            semaforo.release();
        }
    }

    private void Cozinhar() {
        if(id%2==0){
            nome= " Lasanha a Bolonhesa";
            double max=800;
            double min=501;
            double tempo;
            System.out.println("Prato " + id +" " + nome + " foi iniciado");
            tempo = (Math.random() * ((max - min))) + min;
            System.out.println("Tempo de cozimento"+tempo/1000+"s");
            while(tempo>cozimento){
                try {
                sleep((100));
                cozimento+=100;
                porcentagem= (int) ((cozimento*100/tempo));
                System.out.println("Porcentagem de cozimento " + porcentagem+ " do prato " + id +" "+nome);
            } catch (Exception e) {
                e.printStackTrace();
            }
            }
           
        }else{
            nome= "Sopa de Cebola";
            double max=1200;
            double min=601;
            double tempo;
            System.out.println("Prato " + id +" " + nome + " foi iniciado");
            tempo = (Math.random() * ((max - min))) + min;
            System.out.println("Tempo de cozimento"+tempo/1000+"s");
            while(tempo>cozimento){
                try {
                cozimento+=100;
                porcentagem= (int) ((cozimento*100/tempo));
                sleep((100));
                System.out.println("Porcentagem de cozimento " + porcentagem+ " do prato " + id +" "+nome);
            } catch (Exception e) {
                e.printStackTrace();
            }
            }
        }
    }

    private void Entregar() {
        double tempo = 500;
        try {
                sleep((long)(tempo));
            } catch (Exception e) {
                e.printStackTrace();
            }
        System.out.println("Prato " + id +" " + nome + " foi entregado");
    }
    
    
}
