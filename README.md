# map-library-demo
demo implementation for the map library

this demo implementation shows how easy it is to make maps:

```
    DemoMapPartFactory mapPartFactory = new DemoMapPartFactory();
    DemoMapFactory mapFactory = new DemoMapFactory(mapPartFactory);
    demoMap = mapFactory.createMap(5, 4, MapStyle.HEX_VERTICAL);
```

Prequisites:
you have to define you own, custom MapParts:

 + Map
 + MapField
 + MapEdge
 + MapNode
 + MapWalker *)

each of this MapParts requires it's own data-container which mus be defines. The ```MapWalker``` doesn't has
any custom data.

 + MapData
 + MapFieldData
 + MapEdgeData
 + MapNodeData

here's an example of how to this, namely on an ```MapField```. Note that the ```MapFieldData``` is generic and can be any cass you
desire

```
    public class DemoMapField extends MapField<MapFieldData, DemoMapField, DemoMapEdge, DemoMapNode> {

        public DemoMapField(MapFieldData mapFieldData) {
            super(mapFieldData);
        }

        @Override
        public void draw(Object drawContext) {
            //custom draw here
        }

    }
```

To create maps you have to implement the ```MapPartFactory```. that's pretty straight forward:

```
    public class DemoMapPartFactory extends MapPartFactory<DemoMap, DemoMapField, DemoMapEdge, DemoMapPoint, DemoMapWalker> {

        @Override
        public DemoMapNode createMapNode() { return new DemoMapNode(new MapNodeData()); }

        @Override
        public DemoMapEdge createMapEdge() { return new DemoMapEdge(new MapEdgeData()); }

        @Override
        public DemoMapField createMapField() { return new DemoMapField(new MapFieldData()); }

        @Override
        public DemoMap createMap(int width, int height, MapStyle style) { return new DemoMap(width, height, style, new MapData()); }

        @Override
        public DemoMapWalker createWalker() { return new DemoMapWalker(); }
    }
```

then comes the funny part, creating custom maps:

### example: set ```walkCosts``` randomly and see how A*Star works
```
    private void shuffleWalkCosts() {
        Random random = new Random();
        for (DemoMapField demoMapField : demoMap.getFields()) {
            demoMapField.getData().setWalkCostFactor(1d);
            int die = random.nextInt(6) + 1;
            if (die == 1) {
                demoMapField.getData().setWalkCostFactor(6d);
            }
            if (die == 2) {
                demoMapField.getData().setWalkCostFactor(3d);
            }
        }
    }
```
you can see how simple the access to the ```MapFieldData``` is, since the lib is generic:

### example MapWalker
now that the data on the field has different walk cost we can make our walker to apply these changes

```
public class DemoMapWalker extends MapWalker<DemoMapField, DemoMapEdge, DemoMapNode> {

    @Override
    public boolean canEnter(DemoMapField from, DemoMapField into) {
        return true; //can walk into any field
    }

    @Override
    public int getEnterCosts(DemoMapField from, DemoMapField into) {
        //here we see, how the walker applies the walk costs from the field
        return (int) into.getData().getWalkCostFactor() * 10;
    }

    @Override
    public List<DemoMapField> getNeighbours(DemoMapField field) {
        //this walker can only cross over edges,
        //but you could also pass over the nodes...
        //return getNeighboursFromNodes(field);
        return getNeighboursFromEdges(field);
    }
}
```

### example: custom draw with ```MapFieldData```
depending on your implementaion you do custom draw depending on your ```MapFieldData```. In Our App we use JavaFx,
so the drawContext is of ```GraphicsContext```. you have to cast here. The idea is that you can implement
platform independ maps and use it on android or swing or whatever.

```
    @Override
    public void draw(Object drawContext) {
        GraphicsContext gc = (GraphicsContext) drawContext;
        gc.setFill(Color.GRAY);
        if (getData().getWalkCostFactor() >= 1) {
            gc.setFill(Color.LIGHTGRAY);
        }
        gc.setStroke(Color.DARKGRAY);
        gc.setLineWidth(1);

        Shape shape = getShape().getTransformed();
        double[] xs = shape.getPoints().stream().mapToDouble(Point::getX).toArray();
        double[] ys = shape.getPoints().stream().mapToDouble(Point::getY).toArray();
        int amount = xs.length;
        gc.fillPolygon(xs,ys, amount);

        getEdges().forEach(e -> e.draw(drawContext));
        getNodes().forEach(p -> p.draw(drawContext));
    }
```

see how we draw the fields with different colors depending on our ```MapFieldData```? it couldn't be more easy.
