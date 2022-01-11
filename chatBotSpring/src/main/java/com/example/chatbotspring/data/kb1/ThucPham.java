
package com.example.chatbotspring.data.kb1;

/**
 *
 * @author Admin
 */
public class ThucPham {
    private String name;
    private float kcal;

    public ThucPham() {
    }

    public ThucPham(String name, float kcal) {
        this.name = name;
        this.kcal = kcal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getKcal() {
        return kcal;
    }

    public void setKcal(float kcal) {
        this.kcal = kcal;
    }
    
    public String getThucPham(){
        return name+"("+kcal+"/"+"100g"+")";
    }
}
