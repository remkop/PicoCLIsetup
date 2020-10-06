package edu.bonn.cs.iv.core.config;

import org.apache.commons.cli.*;

import java.util.Arrays;
import java.util.List;

public class Commons_cliTest {

    public static void main(String[] args) throws ParseException {
        final List<String> paras = Arrays.asList("h", "mh", "mls", "ah", "als");
        final Options options = new Options();

        //General
        options.addOption(new Option(paras.get(0),"help",false,"Print this help"));
        //Models
        options.addOption(new Option(paras.get(1),true,"Print model help"));
        options.addOption(new Option(paras.get(2),"Print models"));

        //apps
        options.addOption(new Option(paras.get(3), true,"Print App help"));
        options.addOption(new Option(paras.get(4), "Print Apps"));
        CommandLineParser parser = new DefaultParser();
        var cline = parser.parse(options,args);

        for (String para: paras){
            if(cline.hasOption(para)){
                System.out.println(para + "is present");
            }
        }

        System.out.println(Arrays.asList(cline.getArgs()));
        HelpFormatter formatter = new HelpFormatter();
        String header = "Do something useful with an input file\n\n";
        String footer = "\nPlease report issues at http://example.com/issues";

        formatter.printHelp( "MyApp", header,options,footer,true );
    }
}
