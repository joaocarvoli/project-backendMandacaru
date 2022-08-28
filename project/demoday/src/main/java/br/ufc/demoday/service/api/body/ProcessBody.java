package br.ufc.demoday.service.api.body;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.ArrayList;
import java.util.HashMap;

public class ProcessBody {
    private String title;
    private Requester requester;
    private Company company;
    private Flow flow;
    private ArrayList<Member> members;


    private HashMap<String, String> loadEnvs(){
        final Dotenv dotenv = Dotenv.load();
        HashMap<String, String> envs = new HashMap<>();
        envs.put("requesterId", dotenv.get("REQUESTER_ID"));
        envs.put("companyId", dotenv.get("COMPANY_ID"));
        //envs.put("username", dotenv.get("USERNAME_API"));
        //envs.put("userEmail", dotenv.get("USER_EMAIL"));
        //envs.put("documentId", dotenv.get("DOCUMENT_ID"));
        return envs;
    }
    public ProcessBody(){
        HashMap<String, String> envs = loadEnvs();
        requester = new Requester();
        company = new Company();
        flow = new Flow();
        members = new ArrayList<>();
        title = "Teste apresentacao";
        requester.setId("44afea47-2bfa-4380-9dae-e1e2ebe7a64d");
        company.setId(envs.get("companyId"));
        flow.setDefineOrderOfInvolves(true);
        flow.setHasExpiration(true);
        flow.setExpiration("2022-12-30");
    }
    public void addMember(String username, String userEmail, String documentId){
        members.add(0, new Member());
        members.get(0).setName(username);
        members.get(0).setEmail(userEmail);
        members.get(0).setDocumentType("CPF");
        members.get(0).setDocumentCode(documentId);
    }
}

class Requester {
    private String id;

    public void setId(String id) {
        this.id = id;
    }
}

class Company {
    private String id;

    public void setId(String id) {
        this.id = id;
    }
}

class Flow {
    private boolean defineOrderOfInvolves;
    private boolean hasExpiration;
    private String expiration;

    public void setDefineOrderOfInvolves(boolean defineOrderOfInvolves) {
        this.defineOrderOfInvolves = defineOrderOfInvolves;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public void setHasExpiration(boolean hasExpiration) {
        this.hasExpiration = hasExpiration;
    }
}

class Member {
    private String name;
    private String email;
    private String documentType;
    private String documentCode;
    private ActionType actionType;
    private Responsabilty responsabilty;
    private AuthenticationType authenticationType;
    private int order  = 1;
    private String type = "SUBSCRIBER";
    private Representation representation;

    public Member() {
        actionType = new ActionType();
        authenticationType = new AuthenticationType();
        responsabilty = new Responsabilty();
        representation = new Representation();
        actionType.setId("510b226e-c705-4120-ad9d-4a19633ea3df");
        responsabilty.setId("50a625b5-213a-4743-ae92-f3732d87f159");
        authenticationType.setId("841c8833-8566-4a9a-be5b-b30839ed138d");
        representation.setWillActAsPhysicalPerson(true);
        representation.setWillActRepresentingAnyCompany(false);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public void setDocumentCode(String documentTypeCode) {
        this.documentCode = documentTypeCode;
    }
}

class ActionType {
    private String id;

    public void setId(String id) {
        this.id = id;
    }
}

class Responsabilty {
    private String id;

    public void setId(String id) {
        this.id = id;
    }
}

class AuthenticationType {
    private String id;

    public AuthenticationType(){
        id  = "841c8833-8566-4a9a-be5b-b30839ed138d";
    }

    public void setId(String id) {
        this.id = id;
    }
}

class Representation {
    private boolean willActAsPhysicalPerson;
    private boolean willActRepresentingAnyCompany;

    public void setWillActAsPhysicalPerson(boolean willActAsPhysicalPerson) {
        this.willActAsPhysicalPerson = willActAsPhysicalPerson;
    }

    public void setWillActRepresentingAnyCompany(boolean willActRepresentingAnyCompany) {
        this.willActRepresentingAnyCompany = willActRepresentingAnyCompany;
    }
}
