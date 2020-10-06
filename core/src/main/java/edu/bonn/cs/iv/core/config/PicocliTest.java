package edu.bonn.cs.iv.core.config;

import picocli.CommandLine;

@CommandLine.Command(name = "MyApp", description = "CLI Parser Test\n",
        subcommands = PicocliTest.Help.Sub.class)

public class PicocliTest {

    @CommandLine.ArgGroup(validate = false, heading = "Help\n")
    Help help;

    public static class Help{
        @CommandLine.Option(names = { "-h", "--help" }, description = "Print this help message")
        boolean helpRequested = false;

        @CommandLine.Command(name = "sub")
        static class Sub implements Runnable {

            @CommandLine.Option(names = "-y")
            int y;

            public void run() {}
        }
    }

    @CommandLine.ArgGroup(validate = false, heading = "\nApplications\n")
    Apps apps;
    public static class Apps{
        @CommandLine.Option(names = { "-ha" }, arity = "0..1",defaultValue = "0", fallbackValue = "-1", paramLabel = "application",
        description = "Prints all Applications or help for specified application")
        byte appsHelp;
    }

    public static void main(String[] args) {
        var config = ConfigHandler.crateEmptyConfig();

        args = new String[]{};
        var bm = new PicocliTest();
        new CommandLine(bm).parseArgs(args);
        new CommandLine(bm).usage(System.out);
    }




    //Other stuff
    /*    @CommandLine.Parameters(index = "0", description = "Output File", paramLabel = "OutFile")
    String outFile;

    @CommandLine.Parameters(index = "1", description = "Model", paramLabel = "Model")
    String model;

    @CommandLine.Option(names = "-d", order = 10, description = "Debug")
    boolean debug;

    @CommandLine.Option(names = { "-h", "--help" }, order = 11, description = "display a help message")
    boolean helpRequested = false;*/

}





