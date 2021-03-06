package de.quist.app.maps;

import android.graphics.Point;

import de.quist.app.maps.model.CameraPosition;
import de.quist.app.maps.model.LatLng;
import de.quist.app.maps.model.LatLngBounds;

public interface CameraUpdateFactory {

    CameraUpdate zoomIn();
    CameraUpdate zoomOut();
    CameraUpdate scrollBy(float xPixel, float yPixel);
    CameraUpdate zoomTo(float zoom);
    CameraUpdate zoomBy(float amount);
    CameraUpdate zoomBy(float amount, Point focus);
    CameraUpdate newCameraPosition(CameraPosition cameraPosition);
    CameraUpdate newLatLng(LatLng latLng);
    CameraUpdate newLatLngZoom(LatLng latLng, float zoom);
    CameraUpdate newLatLngBounds(LatLngBounds bounds, int padding);
    CameraUpdate newLatLngBounds(LatLngBounds bounds, int width, int height, int padding);

}
