package main.java;

import java.util.regex.Pattern;

/**
 * Regular expression that matches binary number inputs that are multiple of 3
 */
public class RegexpMod3 {

    public static Pattern multipleOf3() {
        return Pattern.compile("0*(1(01*0)*10*)*0*");
        // 0* () 0* - state A of FSM https://math.stackexchange.com/questions/140283/why-does-this-fsm-accept-binary-numbers-divisible-by-three
        // (1()10*) - 11 to state B and back to A, then 0* can be in A any long
        // (01*0) - to state C and back to B
     }

}