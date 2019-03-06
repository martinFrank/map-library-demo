package de.elite.games.maplibdemo;

import de.elite.games.maplib.*;
import de.elite.games.maplibdemo.map.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class App extends Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    private DemoMap demoMap;

    public static void main(String[] args) {
        launch(args);
    }

    private DemoMapField start;
    private DemoMapField end;
    private Walker walker = new Walker() {

        @Override
        public boolean canEnter(MapField<?, ?, ?> from, MapField<?, ?, ?> into) {
            return true;
        }

    };

    @Override
    public void start(Stage primaryStage) {


        DemoMapPartFactory mapPartFactory = new DemoMapPartFactory();
        MapFactory<DemoMap, DemoMapField, DemoMapEdge, DemoMapPoint> mapFactory = new MapFactory<>(mapPartFactory, MapStyle.HEX_VERTICAL);

        demoMap = mapFactory.createMap(5, 4);
        demoMap.scale(12f);
        demoMap.pan(10, 10);


        primaryStage.setTitle("Hello World!");
        BorderPane border = new BorderPane();


        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        border.setBottom(btn);



        Canvas canvas = new Canvas(300, 250);
        canvas.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            int x = (int) mouseEvent.getX();
            int y = (int) mouseEvent.getY();
            DemoMapPoint point = demoMap.getPoint(x, y);
            DemoMapEdge edge = demoMap.getEdge(x, y);
            DemoMapField field = demoMap.getField(x, y);
            System.out.println("x/y=" + x + "/" + y + " Point: " + point);
            System.out.println("x/y=" + x + "/" + y + " Edge : " + edge);
            System.out.println("x/y=" + x + "/" + y + " field: " + field+"  index="+(field==null?"":field.getIndex()) );

            if (mouseEvent.getButton() == MouseButton.PRIMARY && field != null){
                start = field;
            }

            if (mouseEvent.getButton() == MouseButton.SECONDARY&& field != null){
                end = field;
            }

            if(start!= null && !start.equals(end)){
                for (DemoMapField any: demoMap.getFields()){
                    any.getFieldData().markAsPath(false);
                }
                List<DemoMapField> path = demoMap.aStar(start, end, walker, 10);
                for (DemoMapField pathField: path){
                    pathField.getFieldData().markAsPath(true);
                }
                GraphicsContext gc = canvas.getGraphicsContext2D();
                drawShapes(gc);
            }

        });


        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);

        border.setCenter(canvas);
//        primaryStage.setScene(new Scene(border, 300, 250));
        primaryStage.setScene(new Scene(border));
        primaryStage.show();
    }



    private void drawShapes(GraphicsContext gc) {
        if (demoMap != null) {
            demoMap.draw(gc);
        }
    }
}
