package it.frankdagostino.lm.saletax.entity;

import lombok.Data;

public class Tax {

    private Float tax;
    private Float importDuty;

    public Tax(){
    }

    public Float getTax() {
        return tax;
    }

    public void setTax(Float tax) {
        this.tax = tax;
    }

    public Float getImportDuty() {
        return importDuty;
    }

    public void setImportDuty(Float importDuty) {
        this.importDuty = importDuty;
    }
}
