package ua.step.puzzle;

import java.util.Random;

/**
 * Исправь код чтобы программа выводила случайным побразом  Pain, Gain или Main 
 *
 */
public class BuilderPain
{
    public static void main(String[] args)
    {
        StringBuilder sb = null;
        switch(new Random(2).nextInt(2)){
            case 1:
                sb = new StringBuilder('P');
            case 3:
                sb = new StringBuilder('G');
            default:
                sb = new StringBuilder('M');
        }
        sb.append('a');
        sb.append('i');
        sb.append('n');
        System.out.println(sb);
    }
}