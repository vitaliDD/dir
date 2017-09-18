package com.doschechko.matylionak.wcguide.maps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.doschechko.matylionak.domain.entity.WcProfileModel;
import com.doschechko.matylionak.domain.interaction.UseCaseGetListWC;
import com.doschechko.matylionak.wcguide.R;
import com.doschechko.matylionak.wcguide.base.BaseFragmentViewModel;
import com.doschechko.matylionak.wcguide.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

import static android.content.Context.LOCATION_SERVICE;

/**
 * Created by ya on 08.09.2017.
 */

public class Activity_MapsViewModel implements BaseFragmentViewModel, OnMapReadyCallback {


    private Activity_Maps activity;
    // private Context context=activity.getContext();
    //Activity_MapsViewModel activity_mapsViewModel=this;
    Activity_MapsViewModel activity_mapsViewModel = this;
    private ActivityMapsBinding binding;
    private ArrayList<WcProfileModel> listWc = new ArrayList<>();
    private UseCaseGetListWC useCaseGetListWC = new UseCaseGetListWC();
    private SupportMapFragment mapFragment;
    private boolean visibleOnScreen = false;
    private Calendar calendar = Calendar.getInstance();
    private View mapView;

    // private WcProfileModel wcProfileModel=new WcProfileModel();
    public void setBinding(ActivityMapsBinding binding) {
        this.binding = binding;
    }

    public void setActivity(Activity_Maps activity) {
        this.activity = activity;
    }

    @Override
    public void init() {
        visibleOnScreen = true;
        Log.e("final ", " init  ");
        useCaseGetListWC.execute(null, new DisposableObserver<List<WcProfileModel>>() {
            @Override
            public void onNext(@NonNull List<WcProfileModel> wcProfileModels) {
                listWc.addAll(wcProfileModels);
                Log.e("final ", " onNext 00 " + listWc.size());
                /////////////////для логов
                for (WcProfileModel list : listWc) {
                    Log.e("final ", " resume MapsViewModel onNext " + list.toString() + "\n" + list.getCoordinats().split(",")[0].toString());

                }
                //проверка на состояние активити, чтобы не было краша
                if (visibleOnScreen) {
                    mapFragment = (SupportMapFragment) activity.getChildFragmentManager().findFragmentById(R.id.map);
                    mapFragment.getMapAsync(activity_mapsViewModel);
                    mapView = mapFragment.getView();
                }

            }

            @Override
            public void onError(@NonNull Throwable e) {

                Log.e("final ", " onError ");
                Toast.makeText(activity.getContext(),
                        R.string.noInternetConnection,
                        Toast.LENGTH_LONG).show();

            }

            @Override
            public void onComplete() {

                Toast.makeText(activity.getContext(),
                        R.string.mapLoaded,
                        Toast.LENGTH_LONG).show();
                Log.e("final ", " onComplete ");

            }
        });

    }

    @Override
    public void resume() {
        Log.e("final ", " resume  ");

    }

    @Override
    public void pause() {
        visibleOnScreen = false;
        Log.e("final ", " pause  " + listWc.size());


        if (useCaseGetListWC != null)
            useCaseGetListWC.dispose();
    }

    @Override
    public void release() {
        Log.e("final ", " release  ");

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        // MapsInitializer.initialize(activity.getContext());

        Log.e("final ", " onMapReady  ");
        //this.googleMap = googleMap;
        googleMap.getUiSettings().setZoomControlsEnabled(true);//кнопки зума

        //перемещает кнопку MyLocationButton
        View locationButton = ((View) mapView.findViewById(Integer.parseInt("1")).getParent()).findViewById(Integer.parseInt("2"));
        RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) locationButton.getLayoutParams();
        // position on right bottom
        rlp.addRule(RelativeLayout.ALIGN_PARENT_TOP, 0);
        rlp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        rlp.setMargins(0, 0, 30, 400);


        //googleMap.getUiSettings().setMyLocationButtonEnabled(true);//установка кнопки текущего местоположения
        if (ActivityCompat.checkSelfPermission(activity.getContext(), Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(activity.getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            return;
        }
        googleMap.setMyLocationEnabled(true);//разрешение на определение текущего местополощения
        googleMap.setMapType(com.google.android.gms.maps.GoogleMap.MAP_TYPE_NORMAL);//установка типа карты
        Log.e("final ", " onMapReady 22 ");
        Double latitude = 0.0;
        Double longitude = 0.0;

        Log.e("final ", " onMapReady 33 " + listWc.size());

        for (int i = 0; i < listWc.size(); i++) {//расставляем точки из листа,который пришел с сервера
            Log.e("final ", " onMapReady MapsViewModel onNext " + i);
            LatLng coordinatsWC;
            latitude = Double.valueOf(parse(listWc.get(i).getCoordinats())[0]);
            longitude = Double.valueOf(parse(listWc.get(i).getCoordinats())[1]);
            coordinatsWC = new LatLng(latitude, longitude);
            MarkerOptions marker = new MarkerOptions().position(coordinatsWC).title("Free WC, app. 117");
            if(OpenCloseWC(listWc.get(i).getWork_time())) {
                marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.toilet_acion_blue_small));
            }else{
                marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.toilet_acion_red_small));
            }
            googleMap.addMarker(marker);

        }

        //эта куча кода для получения текушего местоположения
        LocationManager locationManager = (LocationManager) activity.getContext().getSystemService(LOCATION_SERVICE);
        Log.e("final ", " locationManager providers" + locationManager.getAllProviders().toString());
        Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(new Criteria(), true));
        Log.e("final ", " locationManager getLatitude " + location.getLatitude());
        Log.e("final ", " locationManager getLongitude " + location.getLongitude());
        //устанавливаем  камеру на текущее местоположение с коэф. 15 без анимации
//        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(),
//                location.getLongitude()), 15));

        //устанавливаем  камеру на текущее местоположение с коэф. 15 с анимацией
        CameraPosition cameraPosition = new CameraPosition.Builder().target(
                new LatLng(location.getLatitude(), location.getLongitude())).zoom(15).build();
//        Log.e("time ", " sravnenie " + OpenCloseWC("15:20"));
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    private boolean OpenCloseWC(String work_time) {

        String[] arrWorkWcTime=parse(work_time);
        String wcStart=arrWorkWcTime[0];
        String wcEnd=arrWorkWcTime[1];

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        long workWcTimeStart = 0;
        long workWcTimeEnd = 0;
        long currentTime = 0;
        try {
            workWcTimeStart = simpleDateFormat.parse(wcStart).getTime();
            workWcTimeEnd = simpleDateFormat.parse(wcEnd).getTime();
            currentTime = simpleDateFormat.parse(simpleDateFormat.format(new Date())).getTime();
            Log.e("time ", " wcStart " + wcStart);
            Log.e("time ", " wcEnd " + wcEnd);
            Log.e("time ", " currentTime " + currentTime);
        } catch (ParseException e) {
            Log.e("time ", " parse exception");
        }

        return (workWcTimeEnd > currentTime)&&(workWcTimeStart<currentTime);
    }

  //  private boolean

    private String[] parse(String s) {

        return s.split("[,-]");

    }


}
