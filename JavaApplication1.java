/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class JavaApplication1 extends Thread {

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }finally{
            System.out.println("running thread name is:" + Thread.currentThread().getName() + " running thread priority is:" + Thread.currentThread().getPriority());
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JavaApplication1 m[] = new JavaApplication1[10];
        for (int i = 0; i < 10; i++) {
            m[i] = new JavaApplication1();
            m[i].setName("" +(i+1));
            if(i>= 0 && i<= 3){
                m[i].setPriority(MIN_PRIORITY );
            }else if(i>= 4 && i<= 6){
                m[i].setPriority(MAX_PRIORITY );
            }else{
                m[i].setPriority(NORM_PRIORITY - 1);
            }
        }
        
        for (int i = 0; i < 10; i++) {
            m[i].start();
        }
    }
}
