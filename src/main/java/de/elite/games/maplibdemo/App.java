package de.elite.games.maplibdemo;

import de.elite.games.maplib.MapStyle;
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
import java.util.Optional;
import java.util.Random;


public class App extends Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    private DemoMap demoMap;
    private DemoMapWalker walker;

    public static void main(String[] args) {
        launch(args);
    }

    private DemoMapField start;
    private DemoMapField end;


    @Override
    public void start(Stage primaryStage) {
        DemoMapPartFactory mapPartFactory = new DemoMapPartFactory();
        DemoMapFactory mapFactory = new DemoMapFactory(mapPartFactory);
        demoMap = mapFactory.createMap(12, 6, MapStyle.HEX_HORIZONTAL);
        demoMap.scale(14f);
        walker = mapPartFactory.createWalker();

        shuffleWalkCosts();

        primaryStage.setTitle("Hello World!");
        BorderPane border = new BorderPane();
        double w = demoMap.getTransformed().getWidth();
        double h = demoMap.getTransformed().getHeight();
        Canvas canvas = new Canvas(w, h);
        canvas.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            int x = (int) mouseEvent.getX();
            int y = (int) mouseEvent.getY();
            Optional<DemoMapNode> point = demoMap.getNodeAt(x, y);
            Optional<DemoMapEdge> edge = demoMap.getEdgeAt(x, y);
            Optional<DemoMapField> field = demoMap.getFieldAt(x, y);
            LOGGER.debug("x/y:{}/{} Point:{}", x, y, point);
            LOGGER.debug("x/y:{}/{} Edge:{}", x, y, edge);
            LOGGER.debug("x/y:{}/{} Field:{}", x, y, field);

            if (mouseEvent.getButton() == MouseButton.PRIMARY && field.isPresent()) {
                start = field.get();
            }
            if (mouseEvent.getButton() == MouseButton.SECONDARY && field.isPresent()) {
                end = field.get();
            }
            if (start != null && !start.equals(end)) {
                for (DemoMapField any : demoMap.getFields()) {
                    any.getData().markAsPath(false);
                }
                List<DemoMapField> path = demoMap.aStar(start, end, walker, 100);
                for (DemoMapField pathField : path) {
                    pathField.getData().markAsPath(true);
                }
                GraphicsContext gc = canvas.getGraphicsContext2D();
                drawShapes(gc);
            }

        });

        Button btn = new Button();
        btn.setText("Shuffle Map");
        btn.setOnAction(event -> {
            shuffleWalkCosts();
            GraphicsContext gc = canvas.getGraphicsContext2D();
            drawShapes(gc);
        });
        border.setBottom(btn);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);

        border.setCenter(canvas);
        primaryStage.setScene(new Scene(border));
        primaryStage.show();
    }

    private void shuffleWalkCosts() {
        Random random = new Random();
        for (DemoMapField demoMapField : demoMap.getFields()) {
            demoMapField.getData().setWalkCostFactor(1d);
            demoMapField.getData().markAsPath(false);
            int die = random.nextInt(6) + 1;
            if (die == 1) {
                demoMapField.getData().setWalkCostFactor(6d);
            }
            if (die == 2) {
                demoMapField.getData().setWalkCostFactor(3d);
            }
        }
        start = null;
        end = null;
    }


    private void drawShapes(GraphicsContext gc) {
        if (demoMap != null) {
            demoMap.draw(gc);
        }
    }
}
