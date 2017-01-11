/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

/**
 *
 * @author John
 */
public class TwoThread extends Thread {

 private Thread creatorThread;

 // make a note of the thread that constructed me!
public TwoThread(){
 creatorThread = Thread.currentThread();
 creatorThread.setName("qwerwqer");

}




    @Override
 public void run() {

 for ( int i = 0; i < 10; i++ ) {

 printMsg();
    
 }

 }



 public void printMsg() {

 // get a reference to the thread running this

 Thread t = Thread.currentThread();
     System.out.println(t.getName());




 }
 }