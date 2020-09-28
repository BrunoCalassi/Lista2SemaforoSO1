/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author bruno
 */
public class BD extends Thread {
    private int id;
    private Semaphore semaforo;

    public BD(int id, Semaphore semaforo) {
        this.id = id;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
         if(id%3==1){     
          calculo();
        try {
            semaforo.acquire();
            transacao();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            semaforo.release();
            finalizacao();
        }calculo();
        try {
            semaforo.acquire();
            transacao();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            semaforo.release();
            finalizacao();
        }
       }
       if (id%3==2) {
         calculo();
        try {
            semaforo.acquire();
            transacao();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            semaforo.release();
            finalizacao();
        }calculo();
        try {
            semaforo.acquire();
            transacao();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            semaforo.release();
            finalizacao();
        }calculo();
        try {
            semaforo.acquire();
            transacao();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            semaforo.release();
            finalizacao();
        }
        }
       if (id%3==0) {
         calculo();
        try {
            semaforo.acquire();
            transacao();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            semaforo.release();
            finalizacao();
        }calculo();
        try {
            semaforo.acquire();
            transacao();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            semaforo.release();
            finalizacao();
        }calculo();
        try {
            semaforo.acquire();
            transacao();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            semaforo.release();
            finalizacao();
        }
        }   
        calculo();
        try {
            semaforo.acquire();
            transacao();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            semaforo.release();
            finalizacao();
        }
        
    }

    private void calculo() {
       if(id%3==1){     
          double max=1000;
          double min=201;
          double tempo;
          tempo = (Math.random() * ((max - min))) + min;
           try {
                sleep((long)(tempo));
            } catch (Exception e) {
                e.printStackTrace();
            }
           System.out.println("Calculando " + id);
       }
       if (id%3==2) {
          double max=1500;
          double min=501;
          double tempo;
          tempo = (Math.random() * ((max - min))) + min;
           try {
                sleep((long)(tempo));
            } catch (Exception e) {
                e.printStackTrace();
            }
           System.out.println("Calculando " + id);
        }
       if (id%3==0) {
          double max=2000;
          double min=1001;
          double tempo;
          tempo = (Math.random() * ((max - min))) + min;
           try {
                sleep((long)(tempo));
            } catch (Exception e) {
                e.printStackTrace();
            }
           System.out.println("Calculando " + id); 
        }   
    }

    private void transacao() {
        if(id%3==1){     
          double tempo;
          tempo = (Math.random() * 1001);
           try {
                sleep((long)(tempo));
            } catch (Exception e) {
                e.printStackTrace();
            }
           System.out.println("Transacionando " + id);
       }
       if (id%3==2) {
          double tempo;
          tempo = (Math.random() * 1501);
           try {
                sleep((long)(tempo));
            } catch (Exception e) {
                e.printStackTrace();
            }
           System.out.println("Transacionando " + id);
        }
       if (id%3==0) {
          double tempo;
          tempo = (Math.random() * 1501);
           try {
                sleep((long)(tempo));
            } catch (Exception e) {
                e.printStackTrace();
            }
           System.out.println("Transacionando " + id); 
        } 
    }

    private void finalizacao() {
        System.out.println("Finalizando a transição da requisição do id numero " + id);
    }
    
    
}
