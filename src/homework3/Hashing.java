/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homework3;

/**
 *
 * @author turker
 */
public abstract class Hashing {

    // first hash function
    public abstract int funcH1(int x);

    // second hash function
    public abstract int funcH2(int x);

    // collision resolution method => open addressing
    public abstract int funcProb(int x, int i);
}
