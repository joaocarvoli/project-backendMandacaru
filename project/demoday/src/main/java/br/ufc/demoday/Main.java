package br.ufc.demoday;

import br.ufc.demoday.service.api.ApiPdSign;
import br.ufc.demoday.service.api.ClientPdSign;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        ClientPdSign client = new ClientPdSign();
        client.doLogin();
        //ApiPdSign api = new ApiPdSign();
        //api.createProcess();
    }
}
