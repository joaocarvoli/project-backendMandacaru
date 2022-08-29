package br.ufc.demoday.service.api.body;

public class DocumentProcessBody {
    private String extension;
    private boolean isPendency;
    private String name;
    private int order;
    private String type;

    public DocumentProcessBody(){
        extension = "PDF";
        isPendency = false;
        type = "SIGN";
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setIsPendency(boolean isPendency) {
        this.isPendency = isPendency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setType(String type) {
        this.type = type;
    }
}
