package drivers.entities;

import javafx.scene.control.TextField;

public class TS {
    public int vin;
    public String marka;
    public String model;
    public String type;
    public String category;
    public String numberDvigatel;
    public String modelDvigatel;
    public String yesrDvigatel;
    public String colorNumber;
    public double powerDvigatel;
    public double powerDvigatelHorse;
    public double maxPressure;
    public double weight;
    public String typeDvigatel;
    public double weightKG;
    public String typePrivoda;
    public String notes;
    public String owner;

    public TS() {
    }

    public TS(int vin, String marka, String model, String type, String category, String numberDvigatel, String modelDvigatel, String yesrDvigatel, String colorNumber, double powerDvigatel, double powerDvigatelHorse, double maxPressure, double weight, String typeDvigatel, double weightKG, String typePrivoda, String notes, String owner) {
        this.vin = vin;
        this.marka = marka;
        this.model = model;
        this.type = type;
        this.category = category;
        this.numberDvigatel = numberDvigatel;
        this.modelDvigatel = modelDvigatel;
        this.yesrDvigatel = yesrDvigatel;
        this.colorNumber = colorNumber;
        this.powerDvigatel = powerDvigatel;
        this.powerDvigatelHorse = powerDvigatelHorse;
        this.maxPressure = maxPressure;
        this.weight = weight;
        this.typeDvigatel = typeDvigatel;
        this.weightKG = weightKG;
        this.typePrivoda = typePrivoda;
        this.notes = notes;
        this.owner = owner;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNumberDvigatel() {
        return numberDvigatel;
    }

    public void setNumberDvigatel(String numberDvigatel) {
        this.numberDvigatel = numberDvigatel;
    }

    public String getModelDvigatel() {
        return modelDvigatel;
    }

    public void setModelDvigatel(String modelDvigatel) {
        this.modelDvigatel = modelDvigatel;
    }

    public String getYesrDvigatel() {
        return yesrDvigatel;
    }

    public void setYesrDvigatel(String yesrDvigatel) {
        this.yesrDvigatel = yesrDvigatel;
    }

    public String getColorNumber() {
        return colorNumber;
    }

    public void setColorNumber(String colorNumber) {
        this.colorNumber = colorNumber;
    }

    public double getPowerDvigatel() {
        return powerDvigatel;
    }

    public void setPowerDvigatel(double powerDvigatel) {
        this.powerDvigatel = powerDvigatel;
    }

    public double getPowerDvigatelHorse() {
        return powerDvigatelHorse;
    }

    public void setPowerDvigatelHorse(double powerDvigatelHorse) {
        this.powerDvigatelHorse = powerDvigatelHorse;
    }

    public double getMaxPressure() {
        return maxPressure;
    }

    public void setMaxPressure(double maxPressure) {
        this.maxPressure = maxPressure;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getTypeDvigatel() {
        return typeDvigatel;
    }

    public void setTypeDvigatel(String typeDvigatel) {
        this.typeDvigatel = typeDvigatel;
    }

    public double getWeightKG() {
        return weightKG;
    }

    public void setWeightKG(double weightKG) {
        this.weightKG = weightKG;
    }

    public String getTypePrivoda() {
        return typePrivoda;
    }

    public void setTypePrivoda(String typePrivoda) {
        this.typePrivoda = typePrivoda;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
