package com.company.Helper;

import com.company.CostlyObjects.CostlyObjectsPool;
import com.company.History.CareTaker;
import com.company.History.FullDatabase;
import com.company.History.MomentoState;
import com.company.Pokemon.PokemonDatabase;
import com.company.Trainer.TrainerDatabase;

import javax.swing.text.Caret;

public class Helper {
    public static void logCurrentStateToHistory(FullDatabase my_state, CareTaker my_history_log) {
        my_state.setState(new MomentoState(TrainerDatabase.getInstance().getTrainerList(),
                PokemonDatabase.pokemonList, new CostlyObjectsPool().create().getItems()));
        my_history_log.add(my_state.saveStateToMemento());
    }
}
