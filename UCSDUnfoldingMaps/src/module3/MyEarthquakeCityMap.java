package module3;

import java.util.*;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.*;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.*;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.*;

public class MyEarthquakeCityMap extends PApplet //此处extend是将PApplet里的method继承到MyEarthquakeCityMap吗; extends: Allows a new class to inherit the methods and data fields (variables and constants) from an existing class
{
	private UnfoldingMap map;
	
	public void setup()
	{
		size(950,600,P2D);
		map = new UnfoldingMap (this, 125, 50, 700, 500, new Google.GoogleMapProvider());
		map.zoomToLevel(2);
		MapUtils.createDefaultEventDispatcher(this, map);
		Location valLoc = new Location (-38.14f, -73.03f);
		//Marker val = new SimplePointMarker (valLoc);
		//map.addMarker(val);
		Feature valEq = new PointFeature (valLoc);
		valEq.addProperty("title", "Valdivia Chile");
		valEq.addProperty("magnitude", "9.5");
		valEq.addProperty("date", "May 22 1960");
		valEq.addProperty("year", "1960");
		
		Location alaskaLoc = new Location (60.15f, -176.47);
		Feature alaskaEq = new PointFeature (alaskaLoc);
		valEq.addProperty("title", "Valdivia Chile");
		valEq.addProperty("magnitude", "9.5");
		valEq.addProperty("date", "May 22 1960");
		valEq.addProperty("year", "1960");
		
		Location sumatraLoc = new Location (-0.13f, 96.14f);
		Feature sumatraEq = new PointFeature (sumatraLoc);
		valEq.addProperty("title", "Valdivia Chile");
		valEq.addProperty("magnitude", "9.5");
		valEq.addProperty("date", "May 22 1960");
		valEq.addProperty("year", "1960");
		
		Location japanLoc = new Location (32.20, 119.03f);
		Feature japanEq = new PointFeature (japanLoc);
		valEq.addProperty("title", "Valdivia Chile");
		valEq.addProperty("magnitude", "9.5");
		valEq.addProperty("date", "May 22 1960");
		valEq.addProperty("year", "1960");
		
		Location kamchatkaLoc = new Location (56.13, 159.52f);
		Feature kamchatkaEq = new PointFeature (kamchatkaLoc);
		valEq.addProperty("title", "Valdivia Chile");
		valEq.addProperty("magnitude", "9.5");
		valEq.addProperty("date", "May 22 1960");
		valEq.addProperty("year", "1960");
		
//		Marker valMk = new SimplePointMarker (valLoc, valEq.getProperties());
//		map.addMarker(valMk);
		
		List<PointFeature> bigEqs = new ArrayList<PointFeature>(); 
		bigEqs.add((PointFeature) valEq);
		bigEqs.add((PointFeature) alaskaEq);
		bigEqs.add((PointFeature) sumatraEq);
		bigEqs.add((PointFeature) japanEq);
		bigEqs.add((PointFeature) kamchatkaEq);
		
		List<Marker> markers = new ArrayList<Marker>();
		for (PointFeature eq : bigEqs) {
			markers.add(new SimplePointMarker (eq.getLocation(), eq.getProperties()));
		}
		
		map.addMarkers(markers);
	}
	
	public void draw()
	{
		background(90);
		map.draw();
		//addKey();
		
	}
}