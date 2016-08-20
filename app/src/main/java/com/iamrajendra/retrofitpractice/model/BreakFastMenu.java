package com.iamrajendra.retrofitpractice.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by rajendraverma on 20-08-2016.
 */
@Root(name = "breakfast_menu")
public class BreakFastMenu {
        @ElementList(inline = true)
        List<Food> foodList;

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}




