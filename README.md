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
 + MapPoint
 + MapWalker3 *)

each of this MapParts requires it's own data-container which mus be defines. The ```MapWalker``` doesn't has
any custom data.

 + MapData
 + FieldData
 + EdgeData
 + PointData

here's an example of how to this, namely on an ```MapField```. Note that the ```MapFieldData``` is generic and can be any cass you
desire

```
    public class DemoMapField extends MapField<MapFieldData, DemoMapField, DemoMapEdge, DemoMapPoint> {

        private MapFieldData mapFieldData = new MapFieldData();

        public DemoMapField(GeoPoint index) {
            super(index);
        }

        @Override
        public void draw(Object drawContext) {
            //custom draw here
        }

        @Override
        public MapFieldData getData() {
            return mapFieldData;
        }

        @Override
        public void setData(MapFieldData mapFieldData) {
            this.mapFieldData = mapFieldData;
        }
    }
```

To create maps you have to implement the ```MapPartFactory```. that's pretty straight forward:

```
    public class DemoMapPartFactory extends MapPartFactory<DemoMap, DemoMapField, DemoMapEdge, DemoMapPoint, DemoMapWalker> {

        @Override
        public DemoMapPoint createMapPoint(int x, int y) { return new DemoMapPoint(x, y); }

        @Override
        public DemoMapEdge createMapEdge(DemoMapPoint a, DemoMapPoint b) { return new DemoMapEdge(a, b); }

        @Override
        public DemoMapField createMapField(GeoPoint index) { return new DemoMapField(index); }

        @Override
        public DemoMap createMap(int width, int height, MapStyle style) { return new DemoMap(width, height, style); }

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

        double[] xs = getPointsOrdered().stream().mapToDouble(MapPoint::getTransformedX).toArray();
        double[] ys = getPointsOrdered().stream().mapToDouble(MapPoint::getTransformedY).toArray();
        int amount = getPoints().size();
        gc.fillPolygon(xs,ys, amount);

        getEdges().forEach(e -> e.draw(drawContext));
        getPoints().forEach(p -> p.draw(drawContext));
    }
```

see how we draw the fields with different colors depending on our ```MapFieldData```? it couldn't be more easy.
