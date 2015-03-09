package de.quist.app.maps.amazon;

class VisibleRegion implements de.quist.app.maps.model.VisibleRegion {

    static com.amazon.geo.mapsv2.model.VisibleRegion unwrap(de.quist.app.maps.model.VisibleRegion visibleRegion) {
        return visibleRegion != null ? ((VisibleRegion)visibleRegion).original : null;
    }

    static de.quist.app.maps.model.VisibleRegion wrap(com.amazon.geo.mapsv2.model.VisibleRegion visibleRegion) {
        return visibleRegion != null ? new VisibleRegion(visibleRegion) : null;
    }

    final com.amazon.geo.mapsv2.model.VisibleRegion original;

    private VisibleRegion(com.amazon.geo.mapsv2.model.VisibleRegion original) {
        this.original = original;
    }

    @Override
    public de.quist.app.maps.model.LatLng nearLeft() {
        return LatLng.wrap(original.nearLeft);
    }

    @Override
    public de.quist.app.maps.model.LatLng nearRight() {
        return LatLng.wrap(original.nearRight);
    }

    @Override
    public de.quist.app.maps.model.LatLng farLeft() {
        return LatLng.wrap(original.farLeft);
    }

    @Override
    public de.quist.app.maps.model.LatLng farRight() {
        return LatLng.wrap(original.farRight);
    }

    @Override
    public de.quist.app.maps.model.LatLngBounds latLngBounds() {
        return LatLngBounds.wrap(original.latLngBounds);
    }

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof VisibleRegion)) {
            return false;
        }

        VisibleRegion other = (VisibleRegion)o;
        return original.equals(other.original);
    }

    @Override
    public String toString() {
        return original.toString();
    }
}