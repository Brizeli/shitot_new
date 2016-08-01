package com.shitot.model;

import javax.persistence.Entity;

/**
 * Created by Next on 12.07.2016.
 */
@Entity(name = "intervals")
public class Interval extends NamedEntity {

    public static final Interval INT_7_8   = new Interval("07:00 - 08:00");
    public static final Interval INT_8_9   = new Interval("08:00 - 09:00");
    public static final Interval INT_9_10  = new Interval("09:00 - 10:00");
    public static final Interval INT_10_11 = new Interval("10:00 - 11:00");
    public static final Interval INT_11_12 = new Interval("11:00 - 12:00");
    public static final Interval INT_12_13 = new Interval("12:00 - 13:00");
    public static final Interval INT_13_14 = new Interval("13:00 - 14:00");
    public static final Interval INT_14_15 = new Interval("14:00 - 15:00");
    public static final Interval INT_15_16 = new Interval("15:00 - 16:00");
    public static final Interval INT_16_17 = new Interval("16:00 - 17:00");
    public static final Interval INT_17_18 = new Interval("17:00 - 18:00");
    public static final Interval INT_18_19 = new Interval("18:00 - 19:00");
    public static final Interval INT_19_20 = new Interval("19:00 - 20:00");
    public static final Interval INT_20_21 = new Interval("20:00 - 21:00");
    public static final Interval INT_21_22 = new Interval("21:00 - 22:00");
    public static final Interval INT_22_23 = new Interval("22:00 - 23:00");

    public Interval() {
    }

    public Interval(String name) {
        super(name);
    }
}
//
//    private String name;
//
//    Interval() {
//    }
//
//    Interval(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return name;
//    }
//}
