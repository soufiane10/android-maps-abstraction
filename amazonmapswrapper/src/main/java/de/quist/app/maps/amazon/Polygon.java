package de.quist.app.maps.amazon;

import java.util.ArrayList;
import java.util.List;

import de.quist.app.maps.utils.Wrapper;

class Polygon extends Wrapper<com.amazon.geo.mapsv2.model.Polygon> implements de.quist.app.maps.model.Polygon {

    static final Mapper<de.quist.app.maps.model.Polygon, Polygon, com.amazon.geo.mapsv2.model.Polygon> MAPPER = new DefaultMapper<de.quist.app.maps.model.Polygon, Polygon, com.amazon.geo.mapsv2.model.Polygon>() {

        @Override
        public Polygon createWrapper(com.amazon.geo.mapsv2.model.Polygon original) {
            return original != null ? new Polygon(original) : null;
        }
    };

    private Polygon(com.amazon.geo.mapsv2.model.Polygon original) {
        super(original);
    }
    
    @Override
    public void remove() {
        original.remove();
    }

    @Override
    public String getId() {
        return original.getId();
    }

    @Override
    public void setPoints(List<de.quist.app.maps.model.LatLng> points) {
        original.setPoints(LatLng.unwrap(points));
    }

    @Override
    public List<de.quist.app.maps.model.LatLng> getPoints() {
        return LatLng.wrap(original.getPoints());
    }

    @Override
    public void setHoles(List<? extends List<de.quist.app.maps.model.LatLng>> holes) {
        List<List<com.amazon.geo.mapsv2.model.LatLng>> unwrappedHoles = new ArrayList<>(holes.size());
        for (List<de.quist.app.maps.model.LatLng> wrappedPoints : holes) {
            unwrappedHoles.add(LatLng.unwrap(wrappedPoints));
        }
        original.setHoles(unwrappedHoles);
    }

    @Override
    public List<List<de.quist.app.maps.model.LatLng>> getHoles() {
        List<List<com.amazon.geo.mapsv2.model.LatLng>> unwrappedHoles = original.getHoles();
        List<List<de.quist.app.maps.model.LatLng>> wrappedHoles = new ArrayList<>(unwrappedHoles.size());
        for (List<com.amazon.geo.mapsv2.model.LatLng> unwrappedPoints : unwrappedHoles) {
            wrappedHoles.add(LatLng.wrap(unwrappedPoints));
        }
        return wrappedHoles;
    }

    @Override
    public void setStrokeWidth(float width) {
        original.setStrokeWidth(width);
    }

    @Override
    public float getStrokeWidth() {
        return original.getStrokeWidth();
    }

    @Override
    public void setStrokeColor(int color) {
        original.setStrokeColor(color);
    }

    @Override
    public int getStrokeColor() {
        return original.getStrokeColor();
    }

    @Override
    public void setFillColor(int color) {
        original.setFillColor(color);
    }

    @Override
    public int getFillColor() {
        return original.getFillColor();
    }

    @Override
    public void setZIndex(float zIndex) {
        original.setZIndex(zIndex);
    }

    @Override
    public float getZIndex() {
        return original.getZIndex();
    }

    @Override
    public void setVisible(boolean visible) {
        original.setVisible(visible);
    }

    @Override
    public boolean isVisible() {
        return original.isVisible();
    }

    @Override
    public void setGeodesic(boolean geodesic) {
        original.setGeodesic(geodesic);
    }

    @Override
    public boolean isGeodesic() {
        return original.isGeodesic();
    }

}
