package de.quist.app.mapsabstraction.amazonmapswrapper;

import com.amazon.geo.mapsv2.model.TileProvider;

class WrapperTileProvider implements com.amazon.geo.mapsv2.model.TileProvider {

    static de.quist.app.mapsabstraction.model.TileProvider unwrap(TileProvider tileProvider) {
        return tileProvider != null ? ((WrapperTileProvider)tileProvider).original : null;
    }

    static TileProvider wrap(de.quist.app.mapsabstraction.model.TileProvider tileProvider) {
        return tileProvider != null ? new WrapperTileProvider(tileProvider) : null;
    }

    final de.quist.app.mapsabstraction.model.TileProvider original;

    private WrapperTileProvider(de.quist.app.mapsabstraction.model.TileProvider original) {
        this.original = original;
    }

    @Override
    public com.amazon.geo.mapsv2.model.Tile getTile(int x, int y, int zoom) {
        return Tile.unwrap(original.getTile(x, y, zoom));
    }

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof WrapperTileProvider)) {
            return false;
        }

        WrapperTileProvider other = (WrapperTileProvider)o;
        return original.equals(other.original);
    }

    @Override
    public String toString() {
        return original.toString();
    }
}