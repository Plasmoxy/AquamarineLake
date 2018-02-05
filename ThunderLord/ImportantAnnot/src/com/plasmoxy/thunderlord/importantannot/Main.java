package com.plasmoxy.thunderlord.importantannot;

import java.lang.reflect.Field;

public class Main {

    private static final int DEFAULT_INT = 3;
    private @Default @Printed int hello;
    
    private @Printed BaseClass base;
    private @Printed ExtendedClass extended;
    
    public Main() {
        for (Field f : getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(Default.class)) {
                if (f.getType() == int.class) {
                    try {
                        f.set(this, DEFAULT_INT);
                    } catch(IllegalAccessException ex) {}
                }
            }
            
            if (f.isAnnotationPresent(Printed.class)) {
                try {
                    System.out.println(f.getType().getSimpleName() + " " + f.getName() + " = " + f.get(this));
                } catch(IllegalAccessException ex) {}
            }
            
            if (f.getType().getSuperclass() == BaseClass.class) {
                System.out.println(" -> THIS FIELD EXTENDS BaseClass");
            }
        }
    }
    
    public static void main(String[] args) {
        new Main();
    }

}
