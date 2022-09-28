/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula_21_09_dinamicidade;

public class Cliente {
    
    public final int id;
    public final String name;
    Cliente next = null;
    Cliente previous = null;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Cliente(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
}
