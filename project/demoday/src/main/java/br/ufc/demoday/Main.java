package br.ufc.demoday;

import br.ufc.demoday.service.ApiPdSign;
import br.ufc.demoday.service.ClientPdSign;

public class Main {
    public static void main(String[] args) {
        ApiPdSign api = new ApiPdSign();
        api.createProcess();
    }
}
