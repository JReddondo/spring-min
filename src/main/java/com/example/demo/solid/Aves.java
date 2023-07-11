package com.example.demo.solid;

public final class Aves {
    public static void run(){

        var aguila = new Aguila(100,15);
        var pinguino = new Pinguino(10);   
        
        Writer writer = ave->System.out.println(ave);
        
        PrintAves(aguila, writer);
        PrintAves(pinguino, writer);

        PrintAvesVoladoras(aguila, writer);

        //PrintAvesVoladora(pinguino, ave->System.out.println(ave));
        

        
        
    }

    public static void PrintAves(Ave ave, Writer writer){
        writer.run(ave);
    }
    public static void PrintAvesVoladoras(AveVoladora ave, Writer writer){
        writer.run(ave);
    }
}
