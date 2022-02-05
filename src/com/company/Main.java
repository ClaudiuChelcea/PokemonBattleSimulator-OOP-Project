package com.company;

import com.company.Adventure.Adventure;
import com.company.Adventure.Adventure_1_observer;
import com.company.Adventure.Adventure_2_observer;
import com.company.Adventure.Adventure_3_observer;
import com.company.CostlyObjects.CostlyObjectsPool;
import com.company.Helper.Helper;
import com.company.Helper.Logger;
import com.company.History.CareTaker;
import com.company.History.FullDatabase;
import com.company.History.MomentoState;
import com.company.Input.InputManager;
import com.company.Pokemon.Pokemon;
import com.company.Pokemon.PokemonDatabase;
import com.company.Trainer.TrainerDatabase;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    private static final String IN_FILE = "src/JsonFiles/test1.json";

    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

        /* Read input */
        try {
            InputManager.readData(IN_FILE);
        } catch (Exception e) {
            System.out.println(e.getCause() + " " + e.getMessage());
        }

        /* Decide adventure */
        Adventure my_adventure = new Adventure();

        /* Add observers */
        my_adventure.addObserver(new Adventure_1_observer());
        my_adventure.addObserver(new Adventure_2_observer());
        my_adventure.addObserver(new Adventure_3_observer());

        /* Print starting info */
        Logger.printAllDatabases();

        /* Keep history for future logging history */
        FullDatabase my_state = new FullDatabase();
        CareTaker my_history_log = new CareTaker();

        /* Log starting status */
        Helper.logCurrentStateToHistory(my_state, my_history_log);

        /* Start an adventure from the 3 adventures */
        my_adventure.chooseAdventure(my_state, my_history_log);
    }
}
