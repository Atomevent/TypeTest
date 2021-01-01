package sample;



import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;


public class Main extends Application {

    private int textC = 0;
    private String CorText ="";
    private int i = 0;
    private String answer="";
    private String text = "You will notice, then, that illustration\n"
            + "paragraphs often answer questions that ask what,\n"
            + "how, in what way questions that need or\n"
            + "ask for explanation, examples, cases,\n"
            + "and details to illustrate how something is true.";
    public static void main(String[] args) {
        launch();
    }
    public void start(Stage stage) {
        String ans[]= text.split("\\s+");
        String anstxt = String.join(" ", ans);

        stage.setHeight(500);
        stage.setWidth(500);



        GridPane main = new GridPane();
        main.setAlignment(Pos.TOP_CENTER);
        main.setPadding(new Insets(10));

        VBox con = new VBox();
        con.setAlignment(Pos.CENTER);
        TextArea type = new TextArea();
        type.setFont(Font.font("Microsoft Sans Serif",20));




        int counter = 0;

        VBox textt = new VBox();
        textt.setAlignment(Pos.CENTER);
        TextFlow quest = new TextFlow();
        Text prompt = new Text(text);


        quest.setTextAlignment(TextAlignment.CENTER);
        quest.setPrefHeight(150);
        prompt.setFont(Font.font("Microsoft Sans Serif",20));


        quest.getChildren().addAll(prompt);
        textt.getChildren().addAll(quest);




        con.getChildren().addAll(textt,type);
        main.add(con, 0, 1,4,6);



        Scene play = new Scene(main);

        HBox overB = new HBox();
        Label Ftext = new Label("You Win!");
        Ftext.setFont(Font.font("Microsoft Sans Serif",20));
        overB.getChildren().addAll(Ftext);
        overB.setAlignment(Pos.CENTER);

        Scene over = new Scene(overB);

        EventHandler<KeyEvent> x = e->{

            String charac = "";
            KeyCode y = e.getCode();
            if(y == KeyCode.ENTER) {
                answer += " ";
                return;
            }
            if(e.isShiftDown()) {
                charac = e.getText().toUpperCase();
                answer+= charac;

            }else {
                charac=e.getText();
                answer+= charac;
                if(e.getCode() == KeyCode.BACK_SPACE) {
                    if(!answer.equals("")) {
                        answer = answer.substring(0,answer.length()-1);
                    }
                }
            }

            if(answer.equals(anstxt.substring(0,answer.length()))) {
                prompt.setFill(Color.GREEN);
            }else {
                prompt.setFill(Color.RED);
            }
            if(answer.equals(anstxt)) {
                stage.setScene(over);
            }


        };

        VBox menu = new VBox();
        menu.setPadding(new Insets(5));
        menu.setSpacing(20);
        menu.setAlignment(Pos.CENTER);
        Label label = new Label("Speed Typer!!");
        menu.setMargin(label, new Insets(0,0,30,0));
        label.setFont(Font.font("Microsoft Sans Serif",50));
        Button start = new Button("Play");
        start.setPrefSize(200, 100);
        start.setFont(Font.font("Microsoft Sans Serif",30));
        start.setOnAction(e->{
            stage.setScene(play);
        });
        menu.getChildren().addAll(label,start);
        Scene men = new Scene(menu);

        type.setOnKeyPressed(x);

        stage.setScene(men);
        stage.show();

    }
}
