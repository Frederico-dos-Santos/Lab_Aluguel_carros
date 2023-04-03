package com.app.config;

import com.app.model.Cliente;
import com.app.service.ClienteService;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Scanner;

@Configuration
public class ConfigBD {

    private final ClienteService CLIENTE_SERVICE;

    private static final String PATH = "/bd/bd.txt";

    public ConfigBD(ClienteService CLIENTE_SERVICE) {
        this.CLIENTE_SERVICE = CLIENTE_SERVICE;
    }

    @EventListener(ApplicationStartedEvent.class)
    public void inicializaBD(){

        Scanner scanner = retornaScanner();

        while (scanner.hasNextLine()){

            String linha = scanner.nextLine();

            String[] split = linha.split(";");

            if(split[0].equals("cliente")){
                salvaCliente(split);
            }

        }

    }

    /* Methods */

    public Scanner retornaScanner(){

        try {
            return new Scanner(new ClassPathResource(PATH).getInputStream());
        } catch (IOException e) {
            throw new RuntimeException("Arquivo bd.txt não existe");
        }

    }

    public void salvaCliente(String[] split){

        Cliente cliente = new Cliente(split[1], split[2], split[3],
                split[4], split[5], split[6], split[7]);

        CLIENTE_SERVICE.insereCliente(cliente);

    }

}
