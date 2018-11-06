package utility;

import java.util.HashMap;

public class PlayerDatabase {

    static public HashMap<String,String> teamToNames;

    static {
        teamToNames = new HashMap<>();
        teamToNames.put("FCIM", "Falico Serghey,Balmus Ion,Perebinos Mihai,Beethoven Ludvig,Bill Geyts");
        teamToNames.put("Zenit", "Kolobkov Aleksandr,Hromoy Dmitry,Mozila Ivan,Kosoy Serghey,Tormoz Pavel");
        teamToNames.put("Barcelona","Juan Gonzalez,Pedro Muchachez,Paulo Carnavalaz,Antuan Fereiro,Sergio Ramos");
    }

}
