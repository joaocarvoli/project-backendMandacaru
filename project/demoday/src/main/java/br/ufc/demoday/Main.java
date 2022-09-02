package br.ufc.demoday;

import br.ufc.demoday.service.api.CheckProcessStatus;
import br.ufc.demoday.service.api.CreateProcess;
import br.ufc.demoday.service.api.DocumentProcess;
import br.ufc.demoday.service.api.DocumentUpload;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        CreateProcess process = new CreateProcess();
        DocumentProcess documentProcess = new DocumentProcess(process);
        DocumentUpload documentUpload = new DocumentUpload(documentProcess);
        documentUpload.sendDocument();
        CheckProcessStatus status = new CheckProcessStatus(process);
        status.checkByTimes();
    }
}
