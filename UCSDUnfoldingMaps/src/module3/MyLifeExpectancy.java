package module3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.fhpotsdam.unfolding.*;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.*;

public class MyLifeExpectancy extends PApplet
{
	private static final long serialVersionUID = 1L;
	UnfoldingMap map;
	Map<String, Float> lifeExpByCountry;
	List<Feature> countries;
	List<Marker> countryMarkers;
	
	public void setup()
	{
		size(800,600,P2D);
		map = new UnfoldingMap (this, 50, 50, 700, 500, new Google.GoogleMapProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
		lifeExpByCountry = loadLifeExpectancyFromCSV ("/Users/liqian/eclipse-workspace/UCSDUnfoldingMaps/data/LifeExpectancyWorldBankModule3.csv");
		//unfolding库中的method，载入数据并返回feature（包括location，fields和values）
		countries = GeoJSONReader.loadData(this, "countries.geo.json"); 
		//unfolding库中的method，input一个feature后返回a list of markers
		countryMarkers = MapUtils.createSimpleMarkers(countries);
		
		map.addMarkers(countryMarkers);
		shadeCountries();
	}
	
	private void shadeCountries() {
		for (Marker marker : countryMarkers) {
			String countryID = marker.getId();
			if (lifeExpByCountry.containsKey(countryID)) {
				Float lifeExp = lifeExpByCountry.get(countryID);
				int colorLevel = (int) map(lifeExp, 40, 90, 10, 255);
				marker.setColor(color(255-colorLevel, 100, colorLevel));
			}
			else {
				marker.setColor(color(155,155,155));
			}
		}
	}

	public void draw()
	{
		background(90);
		map.draw();
	}
	
	private Map<String, Float> loadLifeExpectancyFromCSV (String fileName)
	{
		Map<String, Float> lifeExpMap = new HashMap<String, Float>();
		String[] rows = loadStrings(fileName); //fileName格式要么是单纯的文件名，要么是完整的文件路径
		for (String row : rows)
		{
			String[] columns = row.split(",");
			if (columns.length == 6 && !columns[5].equals(".."))
			{ 
				lifeExpMap.put(columns[4], Float.parseFloat(columns[5]));
			}
			
		}
		return lifeExpMap; 
	}
	
}
