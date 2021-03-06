package de.quist.app.maps.google;

import android.app.Fragment;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;

import java.net.URL;

import de.quist.app.maps.MapsBinding;
import de.quist.app.maps.model.TileProvider;
import de.quist.app.maps.model.UrlTileProvider;


public class GoogleMapsBinding implements MapsBinding {

    public static final MapsBinding INSTANCE = new GoogleMapsBinding();

    private de.quist.app.maps.CameraUpdateFactory cameraUpdateFactory = new de.quist.app.maps.google.CameraUpdateFactory();
    private de.quist.app.maps.model.BitmapDescriptorFactory bitmapDescriptorFactory = new BitmapDescriptorFactory();

    private GoogleMapsBinding() {}

    private static final de.quist.app.maps.model.Tile NO_TILE = Tile.MAPPER.wrap(com.google.android.gms.maps.model.TileProvider.NO_TILE);

    @Override
    public de.quist.app.maps.CameraUpdateFactory cameraUpdateFactory() {
        return cameraUpdateFactory;
    }

    @Override
    public de.quist.app.maps.model.CameraPosition newCameraPosition(de.quist.app.maps.model.LatLng target, float zoom, float tilt, float bearing) {
        return CameraPosition.MAPPER.wrap(new com.google.android.gms.maps.model.CameraPosition(LatLng.MAPPER.unwrap(target), zoom, tilt, bearing));
    }

    @Override
    public de.quist.app.maps.model.CameraPosition cameraPositionFromLatLngZoom(de.quist.app.maps.model.LatLng target, float zoom) {
        return CameraPosition.MAPPER.wrap(com.google.android.gms.maps.model.CameraPosition.fromLatLngZoom(LatLng.MAPPER.unwrap(target), zoom));
    }

    @Override
    public de.quist.app.maps.model.CameraPosition.IBuilder cameraPositionBuilder() {
        return new CameraPosition.Builder();
    }

    @Override
    public de.quist.app.maps.model.CameraPosition.IBuilder cameraPositionBuilder(de.quist.app.maps.model.CameraPosition camera) {
        return new CameraPosition.Builder(camera);
    }

    @Override
    public de.quist.app.maps.model.CircleOptions newCircleOptions() {
        return CircleOptions.MAPPER.wrap(new com.google.android.gms.maps.model.CircleOptions());
    }

    @Override
    public de.quist.app.maps.model.GroundOverlayOptions newGroundOverlayOptions() {
        return GroundOverlayOptions.MAPPER.wrap(new com.google.android.gms.maps.model.GroundOverlayOptions());
    }

    @Override
    public de.quist.app.maps.model.LatLng newLatLng(double latitude, double longitude) {
        return LatLng.MAPPER.wrap(new com.google.android.gms.maps.model.LatLng(latitude, longitude));
    }

    @Override
    public de.quist.app.maps.model.LatLngBounds newLatLngBounds(de.quist.app.maps.model.LatLng southwest, de.quist.app.maps.model.LatLng northeast) {
        return LatLngBounds.MAPPER.wrap(new com.google.android.gms.maps.model.LatLngBounds(LatLng.MAPPER.unwrap(southwest), LatLng.MAPPER.unwrap(northeast)));
    }

    @Override
    public de.quist.app.maps.model.LatLngBounds.IBuilder latLngBoundsBuilder() {
        return LatLngBounds.builder();
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions newMarkerOptions() {
        return MarkerOptions.MAPPER.wrap(new com.google.android.gms.maps.model.MarkerOptions());
    }

    @Override
    public de.quist.app.maps.model.PolygonOptions newPolygonOptions() {
        return PolygonOptions.MAPPER.wrap(new com.google.android.gms.maps.model.PolygonOptions());
    }

    @Override
    public de.quist.app.maps.model.PolylineOptions newPolylineOptions() {
        return PolylineOptions.MAPPER.wrap(new com.google.android.gms.maps.model.PolylineOptions());
    }

    @Override
    public de.quist.app.maps.model.TileOverlayOptions newTileOverlayOptions() {
        return TileOverlayOptions.MAPPER.wrap(new com.google.android.gms.maps.model.TileOverlayOptions());
    }

    @Override
    public de.quist.app.maps.model.Tile newTile(int width, int height, byte[] data) {
        return Tile.MAPPER.wrap(new com.google.android.gms.maps.model.Tile(width, height, data));
    }

    @Override
    public de.quist.app.maps.model.Tile noTile() {
        return NO_TILE;
    }

    @Override
    public de.quist.app.maps.model.VisibleRegion newVisibleRegion(de.quist.app.maps.model.LatLng nearLeft, de.quist.app.maps.model.LatLng nearRight, de.quist.app.maps.model.LatLng farLeft, de.quist.app.maps.model.LatLng farRight, de.quist.app.maps.model.LatLngBounds latLngBounds) {
        return VisibleRegion.MAPPER.wrap(new com.google.android.gms.maps.model.VisibleRegion(LatLng.MAPPER.unwrap(nearLeft), LatLng.MAPPER.unwrap(nearRight), LatLng.MAPPER.unwrap(farLeft), LatLng.MAPPER.unwrap(farRight), LatLngBounds.MAPPER.unwrap(latLngBounds)));
    }

    @Override
    public de.quist.app.maps.model.BitmapDescriptorFactory bitmapDescriptorFactory() {
        return bitmapDescriptorFactory;
    }

    @Override
    public de.quist.app.maps.MapFragmentWrapper mapFragmentWrapperFrom(Object fragment) {
        if (fragment instanceof de.quist.app.maps.MapFragmentWrapper) {
            return (de.quist.app.maps.MapFragmentWrapper) fragment;
        } else if (fragment instanceof com.google.android.gms.maps.SupportMapFragment) {
            return SupportMapFragmentWrapper.MAPPER.wrap((com.google.android.gms.maps.SupportMapFragment) fragment);
        } else if (fragment instanceof com.google.android.gms.maps.MapFragment) {
            return MapFragmentWrapper.MAPPER.wrap((com.google.android.gms.maps.MapFragment) fragment);
        }
        return null;
    }

    @Override
    public MapViewWrapper mapViewWrapperFrom(View view) {
        if (view instanceof com.google.android.gms.maps.MapView) {
            return MapViewWrapper.MAPPER.wrap((com.google.android.gms.maps.MapView) view);
        }
        return null;
    }

    @Override
    public de.quist.app.maps.MapOptions newMapOptions() {
        return MapOptions.MAPPER.wrap(new GoogleMapOptions());
    }

    @Override
    public Fragment newMapFragmentInstance() {
        return com.google.android.gms.maps.MapFragment.newInstance();
    }

    @Override
    public Fragment newMapFragmentInstance(de.quist.app.maps.MapOptions options) {
        return com.google.android.gms.maps.MapFragment.newInstance(MapOptions.MAPPER.unwrap(options));
    }

    @Override
    public android.support.v4.app.Fragment newSupportMapFragmentInstance() {
        return com.google.android.gms.maps.SupportMapFragment.newInstance();
    }

    @Override
    public android.support.v4.app.Fragment newSupportMapFragmentInstance(de.quist.app.maps.MapOptions options) {
        return com.google.android.gms.maps.SupportMapFragment.newInstance(MapOptions.MAPPER.unwrap(options));
    }

    @Override
    public View newMapView(Context context) {
        return new MapView(context);
    }

    @Override
    public View newMapView(Context context, de.quist.app.maps.MapOptions mapOptions) {
        return new MapView(context, MapOptions.MAPPER.unwrap(mapOptions));
    }

    @Override
    public TileProvider newUrlTileProvider(int width, int height, final UrlTileProvider tileProvider) {
        return de.quist.app.maps.google.TileProvider.MAPPER.wrap(new com.google.android.gms.maps.model.UrlTileProvider(width, height) {

            @Override
            public URL getTileUrl(int x, int y, int zoom) {
                return tileProvider.getTileUrl(x, y, zoom);
            }
        });
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static final Parcelable.Creator<GoogleMapsBinding> CREATOR
            = new Parcelable.Creator<GoogleMapsBinding>() {
        public GoogleMapsBinding createFromParcel(Parcel in) {
            return (GoogleMapsBinding) GoogleMapsBinding.INSTANCE;
        }

        public GoogleMapsBinding[] newArray(int size) {
            return new GoogleMapsBinding[size];
        }
    };
}
