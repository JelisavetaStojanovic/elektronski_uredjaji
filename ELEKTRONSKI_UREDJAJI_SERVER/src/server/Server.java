/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import forme.ServerskaForma;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import niti.ObradaKlijentskihZahteva;

/**
 *
 * @author Korisnik
 */
public class Server extends Thread{
    
    ServerSocket serverSoket;
    ServerskaForma sf;

    public Server(ServerskaForma sf) {
        this.sf = sf;
    }

    public ServerSocket getServerSoket() {
        return serverSoket;
    }
    
    @Override
    public void run() {
        try {
            serverSoket = new ServerSocket(9000);
            while(!serverSoket.isClosed()){
                Socket s = serverSoket.accept();
                
                ObradaKlijentskihZahteva okz = new ObradaKlijentskihZahteva(s);
                okz.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
}
