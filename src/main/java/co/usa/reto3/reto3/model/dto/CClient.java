package co.usa.reto3.reto3.model.dto;

import co.usa.reto3.reto3.model.Client;

public class CClient {

    private Long total;
    private Client client;

    public CClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
