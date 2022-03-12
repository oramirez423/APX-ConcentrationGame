package gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Card;
import model.ConcentrationModel;
import model.Observer;
import ptui.ConcentrationPTUI;

import java.util.*;

/**
 * The ConcentrationGUI application is the UI for Concentration.
 *
 * @author YOUR NAME HERE
 */
public class ConcentrationGUI extends Application implements Observer< ConcentrationModel, Object > {

    //private final static int WIDTH = 650;
    //private final static int HEIGHT = 650;
    private final static int COLS = 4;
    private final static int ROWS = 4;

    private enum Pokemon {
        POKEBALL,
        BULBASAUR,
        ABRA,
        CHARMANDER,
        MEOWTH,
        PIKACHU,
        SQUIRTLE,
        VENOMOTH,
        JIGGLYPUFF,
    }

    private Image pokeball = new Image(getClass().getResourceAsStream(
            "resources/pokeball.png"));
    private Image bulbasaur = new Image(getClass().getResourceAsStream(
            "resources/bulbasaur.png"));
    private Image abra = new Image(getClass().getResourceAsStream(
            "resources/abra.png"));
    private Image charmander = new Image(getClass().getResourceAsStream(
            "resources/charmander.png"));
    private Image meowth = new Image(getClass().getResourceAsStream(
            "resources/meowth.png"));
    private Image pikachu = new Image(getClass().getResourceAsStream(
            "resources/pikachu.png"));
    private Image squirtle = new Image(getClass().getResourceAsStream(
            "resources/squirtle.png"));
    private Image venomoth = new Image(getClass().getResourceAsStream(
            "resources/venomoth.png"));
    private Image jigglypuff = new Image(getClass().getResourceAsStream(
            "resources/jigglypuff.png"));

    private class PokemonButton extends Button {
        private Pokemon pokemon;

        public PokemonButton(Pokemon pokemon){
            this.pokemon = pokemon;
            Image image;
            switch (pokemon) {
                case BULBASAUR:
                    image = bulbasaur;
                    break;
                case ABRA:
                    image = abra;
                    break;
                case CHARMANDER:
                    image = charmander;
                    break;
                case JIGGLYPUFF:
                    image = jigglypuff;
                    break;
                case MEOWTH:
                    image = meowth;
                    break;
                case PIKACHU:
                    image = pikachu;
                    break;
                case SQUIRTLE:
                    image = squirtle;
                    break;
                case VENOMOTH:
                    image = venomoth;
                    break;
                case POKEBALL:
                default:
                    image = pokeball;
            }
            this.setGraphic(new ImageView(image));
        }
        public Pokemon getType() {
            return this.pokemon;
        }
    }

    private GridPane makeGridPane(){
        GridPane gridPane = new GridPane();

        Pokemon pokemon[] = Pokemon.values();
        int i = 0;
        for(int row = 0; row < ROWS; ++row){
            for(int col = 0; col < COLS; ++col){
                PokemonButton button = new PokemonButton(pokemon[0]);
                gridPane.add(button, col, row);
            }
        }
        return gridPane;
    }

    public ConcentrationGUI(){
    }


    @Override
    public void init() throws Exception{
        System.out.println("init: Initialize and connect to model!");
    }

    /**
     * YOUR DOCUMENTATION HERE
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start( Stage stage ) throws Exception {
        BorderPane borderPane = new BorderPane();
        BorderPane bott = new BorderPane();

        Label select = new Label();
        select.setText("Select the first card.");
        borderPane.setTop(select);

        Label counter = new Label();
        counter.setText("0 Moves.");
        bott.setRight(counter);

        GridPane gridPane = makeGridPane();

        HBox hbox = new HBox();
        Button reset = new Button("Reset");
        Button undo = new Button("Undo");
        Button cheat = new Button("Cheat");
        hbox.getChildren().addAll(reset, undo, cheat);

        hbox.setAlignment(Pos.CENTER);
        bott.setCenter(hbox);

        borderPane.setBottom(bott);

        borderPane.setCenter(gridPane);
        Scene scene = new Scene(borderPane);
        stage.setTitle("Concentration");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * YOUR DOCUMENTATION HERE
     *
     * @param concentrationModel
     * @param o
     */
    @Override
    public void update( ConcentrationModel concentrationModel, Object o ) {

    }


    /**
     * main entry point launches the JavaFX GUI.
     *
     * @param args not used
     */
    public static void main( String[] args ) {
        Application.launch(args);
    }
}
